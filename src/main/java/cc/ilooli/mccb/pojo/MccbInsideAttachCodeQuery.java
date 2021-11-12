package cc.ilooli.mccb.pojo;

import cc.ilooli.common.result.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * mccb内部附件代号查询
 *
 * @author OVO
 * @date 2021/11/12
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MccbInsideAttachCodeQuery extends PageQuery {
    private String model;
    private String code;
    private String attachs;
    private Long creatorId;
    private Long modifierId;
}
