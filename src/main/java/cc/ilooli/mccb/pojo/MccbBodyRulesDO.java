package cc.ilooli.mccb.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author OVO
 */
@Data
public class MccbBodyRulesDO {
    private Long id;
    private String series;
    private String inm;
    private String icu;
    private String poles;
    private String trip;
    private String use;
    private String alarm;
    private String specialUse;
    private String toInm;
    private String toIcu;
    private String toPoles;
    private String toTrip;
    private String toUse;
    private String toAlarm;
    private String toSpecialUse;
    private Integer priority;
    private String rule;
    private Long creatorId;
    private Date createTime;
    private Long modifierId;
    private Date modifiedTime;
}
