package cc.ilooli.common.service;

import cc.ilooli.common.pojo.ProductDTO;

/**
 * 公共的bom服务
 *
 * @author OVO
 * @date 2021/11/11
 */
public interface CommonBomService {
    /**
     * 添加物料清单
     *
     * @param productDTO 产品dto
     */
    void addBom(ProductDTO productDTO);
}
