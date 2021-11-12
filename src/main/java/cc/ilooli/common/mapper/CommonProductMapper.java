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
     * 通过属性获取
     *
     * @param model   型号
     * @param current 额定电流
     * @param note    备注
     * @return {@link ProductDO}
     */
    ProductDO getByInfo(String model, String current, String note);

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
