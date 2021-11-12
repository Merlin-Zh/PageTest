package cc.ilooli.mccb.pojo;

import lombok.Data;

/**
 * mccb内部附件数据
 *
 * @author OVO
 * @date 2021/11/12
 */
@Data
public class MccbInsideAttachDataDO {
    /** 物料编码 */
    private String code;
    /** 型号 */
    private String model;
    /** 名称 */
    private String name;
    /** 备注 */
    private String note;
}
