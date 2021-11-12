package cc.ilooli.mccb.pojo;

import lombok.Data;

import java.util.Date;

/**
 * mccb内部附件代码
 *
 * @author OVO
 * @date 2021/11/12
 */
@Data
public class MccbInsideAttachCodeDO {
    /** id */
    private Long id;
    /** 适配型号 */
    private String model;
    /** 代号 */
    private String code;
    /** 附件 */
    private String attachs;
    /** pole2 */
    private String pole2;
    /** pole3 */
    private String pole3;
    /** pole4 */
    private String pole4;
    /** 创造者id */
    private Long creatorId;
    /** 创建时间 */
    private Date createTime;
    /** 修饰符id */
    private Long modifierId;
    /** 修改时间 */
    private Date modifiedTime;
}
