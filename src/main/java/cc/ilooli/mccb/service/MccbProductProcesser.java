package cc.ilooli.mccb.service;

import cc.ilooli.common.pojo.ProductDTO;
import cc.ilooli.common.service.ProductProcesser;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 塑壳本体规则处理类
 *
 * @author OVO
 * @date 2021/11/12
 */
@Service
public class MccbProductProcesser implements ProductProcesser {
    private static final Log logger = LogFactory.get();
    private ProductDTO product;
    private Map<String, String> info;


    /**
     * 获取经过规则处理之后的产品信息
     *
     * @param productDTO 产品dto
     * @return {@link ProductDTO}
     */
    @Override
    public ProductDTO getProcessedProduct(ProductDTO product){
        this.product = product;
        this.info = product.getInfo();
        logger.info("开始处理 {} 的规则", product.getMaterialModel());

        // 处理本体规则
        this.processBody();
        // 处理内部附件规则

        return this.product;
    }

    private void processBody() {

    }
}
