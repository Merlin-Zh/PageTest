package cc.ilooli.common.service;

import cc.ilooli.common.pojo.ProductDTO;

import java.util.List;

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

    /**  添加信息 */
    void addInfo();

    /**
     * 获取系列
     *
     * @return {@link List}<{@link String}>
     */
    List<String> getSeries();

    static String nullConversion(String str, String... args) {
        str = str == null ? "" : str.trim();
        if (args.length != 0 && !"".equals(str)) {
            str = args[0] + str.trim();
        }
        return str;
    }
}
