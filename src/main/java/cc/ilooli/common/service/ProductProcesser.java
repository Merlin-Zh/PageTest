package cc.ilooli.common.service;

import cc.ilooli.common.pojo.ProductDTO;

/**
 * 产品规则处理
 *
 * @author OVO
 * @date 2021/11/12
 */
public interface ProductProcesser {
    /**
     * 获取经过规则处理之后的产品
     *
     * @param product 产品
     * @return {@link ProductDTO}
     */
    ProductDTO getProcessedProduct(ProductDTO product);
}
