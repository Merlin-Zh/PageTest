package cc.ilooli.mccb.pojo;

import cc.ilooli.common.result.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * mccb本体规则查询
 *
 * @author OVO
 * @date 2021/11/12
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MccbBodyRulesQuery extends PageQuery {
    private String series;
    private String inm;
    private String icu;
    private String poles;
    private String trip;
    private String use;
    private String alarm;
    private String specialUse;
    private Integer priority;
    private String rule;
    private Long creatorId;
    private Long modifierId;
}
