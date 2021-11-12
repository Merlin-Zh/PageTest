package cc.ilooli.common.pojo;

import cc.ilooli.common.result.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 产品查询
 *
 * @author OVO
 * @date 2021/11/11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductQuery extends PageQuery {
    /** 型号 */
    private String model;
    /** 名称 */
    private String name;
    /** 电流 */
    private String current;
    /** 备注 */
    private String note;
}
