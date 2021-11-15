package cc.ilooli.common.service.impl;

import cc.ilooli.common.Constant;
import cc.ilooli.common.exception.CustomException;
import cc.ilooli.common.exception.ErrorEnum;
import cc.ilooli.common.mapper.CommonProductMapper;
import cc.ilooli.common.pojo.BomDTO;
import cc.ilooli.common.pojo.ProductDO;
import cc.ilooli.common.pojo.ProductDTO;
import cc.ilooli.common.pojo.ProductQuery;
import cc.ilooli.common.service.CommonBomService;
import cc.ilooli.common.service.CommonProductService;
import cn.hutool.core.convert.Convert;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import static java.util.regex.Pattern.compile;

/**
 * 公共的产品Service impl
 *
 * @author OVO
 * @date 2021/11/15
 */
@Service
public class CommonProductServiceImpl implements CommonProductService {

    private static final Log logger = LogFactory.get();

    private ProductDTO productDTO;

    private final CommonProductMapper mapper;
    @Qualifier("MccbBomServiceImpl")
    private CommonBomService mccbBomService;
    @Qualifier("AcbBomServiceImpl")
    private CommonBomService acbBomService;
    @Qualifier("mcbBomServiceImpl")
    private CommonBomService mcBomService;

    public CommonProductServiceImpl(CommonProductMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ProductDTO getProductByCode(String code) {
        ProductDO productDO = mapper.getByCode(code);
        if (productDO == null) {
            logger.error("获取 {} 的产品信息失败，请检查输入信息或等待该物料同步到MES后重试");
            throw new CustomException(ErrorEnum.CODE_1001);
        }
        productDTO = Convert.convert(ProductDTO.class, productDO);
        this.addInfo();
        logger.info("获取到产品信息：", productDO);
        return productDTO;
    }

    @Override
    public ProductDTO getProductByInfo(ProductQuery query) {
        List<ProductDO> productDOList = mapper.getByInfo(query);
        if (productDOList == null || productDOList.size() == 0) {
            logger.error("获取 {} 的产品信息失败，请检查输入信息或等待该物料同步到MES后重试");
            throw new CustomException(ErrorEnum.CODE_1001);
        }
        if (productDOList.size() > 1) {
            logger.error("通过产品信息查询到 {} 的物料有 {} 条，无法确定具体物料，请检查输入值或去重后重试",
                    query.getModel(), productDOList.size());
            throw new CustomException(1001, "通过产品信息查询到 " + query.getModel()
                    + " 的物料有 " + productDOList.size() + " 条，无法确定具体物料，请检查输入值或去重后重试");
        }
        productDTO = Convert.convert(ProductDTO.class, productDOList.get(0));
        this.addInfo();
        logger.info("获取到产品信息：", productDTO);
        return productDTO;
    }

    @Override
    public List<BomDTO> getProductBom(ProductDTO productDTO) {
//        if (infoUtils.getMccbSeries().contains(product.getInfo().get(Constant.Product.SERIES))) {
//            // 如果是塑壳产品，mccbBomService为product添加bom
//            mccbBomService.addBom(product);
//        } else if (infoUtils.getAcbSeries().contains(product.getInfo().get(Constant.Product.SERIES))) {
//            // 如果是框架产品，acbBomService为product添加bom
//            acbBomService.addBom(product);
//        } else if (infoUtils.getMcbSeries().contains(product.getInfo().get(Constant.Product.SERIES))) {
//            // 如果是微断产品，mcbComService为product添加bom
//            mcbBomService.addBom(product);
//        } else {
//            logger.error("未找到<" + product.getMaterialCode() + ">的BOM信息");
//            throw new CustomException(ResultEnum.CODE_400);
//        }
        return productDTO.getBom();
    }


    /**
     * 添加产品的基础信息
     * 拆分产品型号，得到各个属性及属性值，保存到map中
     */
    private void addInfo() {
        // 获取产品系列
        Matcher matcher = compile("(\\w*\\d*\\w*)-").matcher(productDTO.getMaterialModel());
        String series = matcher.find() ? matcher.group(1) : "";

        productDTO.getInfo().put(Constant.Product.SERIES, series);
        productDTO.getInfo().put(Constant.Product.MODEL, productDTO.getMaterialModel());
        productDTO.getInfo().put(Constant.Product.CURRENT, productDTO.getMaterialCurrent());
        productDTO.getInfo().put(Constant.Product.NAME, productDTO.getMaterialName());
        productDTO.getInfo().put(Constant.Product.NOTE, productDTO.getMaterialNote());

        // if productDTO is a MCCB product, then call MccbProductProcessor to add other infomations
        if ()

    }
}
