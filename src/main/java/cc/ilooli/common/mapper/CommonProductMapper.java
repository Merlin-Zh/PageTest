package cc.ilooli.common.mapper;

import cc.ilooli.common.pojo.ProductDO;
import cc.ilooli.common.pojo.ProductQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 公共的产品mapper
 *
 * @author OVO
 * @date 2021/11/11
 */
@Mapper
public interface CommonProductMapper {
    /**
     * 通过代码获取
     *
     * @param code 代码
     * @return {@link ProductDO}
     */
    ProductDO getByCode(String code);

    /**
     * 得到的信息
     * 通过属性获取
     *
     * @param query 查询
     * @return {@link ProductDO}
     */
    List<ProductDO> getByInfo(ProductQuery query);

    /**
     * 通过分页查询的方式获取产品列表
     *
     * @param query 查询
     * @return {@link List}<{@link ProductDO}>
     */
    List<ProductDO> getAll(ProductQuery query);

    /**
     * 无参的获取所有产品列表方式
     *
     * @return {@link List}<{@link ProductDO}>
     */
    default List<ProductDO> getAll() {
        return this.getAll(new ProductQuery());
    }
}
