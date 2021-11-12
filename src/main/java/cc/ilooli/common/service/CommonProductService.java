package cc.ilooli.common.service;

import cc.ilooli.common.pojo.BomDTO;
import cc.ilooli.common.pojo.ProductDTO;

import java.util.List;

/**
 * 公共的产品service
 *
 * @author OVO
 * @date 2021/11/11
 */
public interface CommonProductService {
    /**
     * 获取产品代码
     *
     * @param code 代码
     * @return {@link ProductDTO}
     */
    ProductDTO getProductByCode(String code);

    /**
     * 获取产品信息
     *
     * @param productDTO 产品dto
     * @return {@link ProductDTO}
     */
    ProductDTO getProductByInfo(ProductDTO productDTO);

    /**
     * 获取产品物料清单
     *
     * @param productDTO 产品dto
     * @return {@link List}<{@link BomDTO}>
     */
    List<BomDTO> getProductBom(ProductDTO productDTO);
}
