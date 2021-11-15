package cc.ilooli.mccb.service;

import cc.ilooli.common.Constant;
import cc.ilooli.common.Constant.Product.Mccb;
import cc.ilooli.common.pojo.ProductDTO;
import cc.ilooli.common.service.ProductProcesser;
import cc.ilooli.mccb.mapper.BodyRulesMapper;
import cc.ilooli.mccb.pojo.MccbBodyRulesDO;
import cc.ilooli.mccb.pojo.MccbBodyRulesQuery;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import info.codesaway.util.regex.Matcher;
import info.codesaway.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * 塑壳本体规则处理类
 *
 * @author OVO
 * @date 2021/11/12
 */
@Service("MccbProductProcesser")
@PropertySource("classpath:config/product.properties")
public class MccbProductProcesser implements ProductProcesser {
    private static final Log logger = LogFactory.get();
    private ProductDTO product;
    private Map<String, String> info;

    @Value("${mccb.regexp}")
    private String regex;
    @Value("${mccb.series}")
    private List<String> series;

    private final BodyRulesMapper bodyRulesMapper;

    public MccbProductProcesser(BodyRulesMapper bodyRulesMapper) {
        this.bodyRulesMapper = bodyRulesMapper;
    }

    /**
     * 获取经过规则处理之后的产品信息
     *
     * @param product 产品
     * @return {@link ProductDTO}
     */
    @Override
    public ProductDTO getProcessedProduct(ProductDTO product) {
        this.product = product;
        this.info = product.getInfo();
        logger.info("开始处理 {} 的规则", product.getMaterialModel());
        // get product' field and info by regex
        this.addInfo();
        // process product's body rules by product's field
        this.processBody();
        // process electronic current rating by product's field
        this.processCurrent();

        return this.product;
    }

    @Override
    public void addInfo() {
        String model = this.product.getMaterialModel();
        Matcher matcher = Pattern.compile(regex).matcher(model);
        while (matcher.find()) {
            this.info.put(Constant.Product.SERIES, matcher.group(Constant.Product.SERIES));
            this.info.put(Mccb.INM, matcher.group(Mccb.INM));
            this.info.put(Mccb.ICU, matcher.group(Mccb.ICU));
            this.info.put(Mccb.OPERATING_MODE, matcher.group(Mccb.OPERATING_MODE));
            this.info.put(Mccb.POLES, matcher.group(Mccb.POLES));
            this.info.put(Mccb.TRIPPING_WAY, matcher.group(Mccb.TRIPPING_WAY));
            this.info.put(Mccb.INSIDE_ATTACHMENT, matcher.group(Mccb.INSIDE_ATTACHMENT));
            this.info.put(Mccb.DIFFERENT_USES, matcher.group(Mccb.DIFFERENT_USES));
            this.info.put(Mccb.QUADRUPOLE_CODE, matcher.group(Mccb.QUADRUPOLE_CODE));
            this.info.put(Mccb.TRIPPING_SHAPE, matcher.group(Mccb.TRIPPING_SHAPE));
            this.info.put(Mccb.CONNECTION_MODE, matcher.group(Mccb.CONNECTION_MODE));
            this.info.put(Mccb.ELECTRONIC_FUNCTION, matcher.group(Mccb.ELECTRONIC_FUNCTION));
            this.info.put(Mccb.OVERLOAD_ALARM, matcher.group(Mccb.OVERLOAD_ALARM));
            this.info.put(Mccb.SHORT_TIME_DELAY_CODE, matcher.group(Mccb.SHORT_TIME_DELAY_CODE));
            this.info.put(Mccb.LEAKAGE_MODEL, matcher.group(Mccb.LEAKAGE_MODEL));
            this.info.put(Mccb.CONTROLLER, matcher.group(Mccb.CONTROLLER));
            this.info.put(Mccb.FUNCTION, matcher.group(Mccb.FUNCTION));
            this.info.put(Mccb.ELECTRONIC_INM_CURRENT, matcher.group(Mccb.ELECTRONIC_INM_CURRENT));
            this.info.put(Mccb.INSTALLATION, matcher.group(Mccb.INSTALLATION));
            this.info.put(Mccb.OUTSIDE_ATTACHMENT, matcher.group(Mccb.OUTSIDE_ATTACHMENT));
            this.info.put(Mccb.SPECIAL_USE, matcher.group(Mccb.SPECIAL_USE));
        }
    }

    @Override
    public List<String> getSeries() {
        return this.series;
    }

    private void processBody() {
        MccbBodyRulesQuery query = new MccbBodyRulesQuery();
        query.setSeries(this.info.get(Constant.Product.SERIES));
        query.setInm(this.info.get(Mccb.INM));
        query.setIcu(this.info.get(Mccb.ICU));
        query.setPoles(this.info.get(Mccb.POLES));
        query.setTrip(this.info.get(Mccb.TRIPPING_WAY));
        query.setUse(this.info.get(Mccb.DIFFERENT_USES));
        query.setAlarm(this.info.get(Mccb.OVERLOAD_ALARM));
        query.setSpecialUse(this.info.get(Mccb.SPECIAL_USE));

        List<MccbBodyRulesDO> rulesDOList = bodyRulesMapper.getByQuery(query);
        logger.info("获取到 {} 的本体规则列表为：\n{}", this.product.getMaterialModel(), rulesDOList);

        rulesDOList.forEach(rulesDO -> {
            Field[] fields = rulesDO.getClass().getDeclaredFields();
            String value = null;
            for (Field field : fields) {
                try {
                    Method getMethod = rulesDO.getClass().getMethod("get" + field.getName());
                    value = (String) getMethod.invoke(rulesDO);
                } catch (NoSuchMethodException e) {
                    logger.error("获取本体规则的get方法失败", e.getMessage());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    logger.error("反射获取属性值失败：", e.getMessage());
                }
                if (!"to".equals(field.getName()) || "*".equals(value)) {
                    continue;
                }
                this.info.put(field.getName().replace("to", ""), value);
            }
        });
    }

    private void processCurrent() {
        final String electronic = "E";
        final String prefix = "Ir1=";
        if (this.info.get(Constant.Product.SERIES).contains(electronic)) {
            this.product.setMaterialCurrent(prefix + this.info.get(Mccb.ELECTRONIC_INM_CURRENT));
            this.info.put(Constant.Product.CURRENT, prefix + this.info.get(Mccb.ELECTRONIC_INM_CURRENT));
        }
    }
}
