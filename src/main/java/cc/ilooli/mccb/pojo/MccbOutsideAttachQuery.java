package cc.ilooli.mccb.pojo;

import cc.ilooli.common.result.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * mccb外部附件查询
 *
 * @author OVO
 * @date 2021/11/12
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MccbOutsideAttachQuery extends PageQuery {
    private String model;
    private String name;
    private String note;
    private String creator;
    private String modifier;
}
