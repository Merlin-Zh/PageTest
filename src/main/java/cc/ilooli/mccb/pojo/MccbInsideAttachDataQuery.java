package cc.ilooli.mccb.pojo;

import cc.ilooli.common.result.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * mccb内部附加数据查询
 *
 * @author OVO
 * @date 2021/11/12
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MccbInsideAttachDataQuery extends PageQuery {
    private String model;
    private String name;
    private String note;
    private Long creatorId;
    private Long modifierId;
}
