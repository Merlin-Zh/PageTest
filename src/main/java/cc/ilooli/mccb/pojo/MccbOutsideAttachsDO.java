package cc.ilooli.mccb.pojo;

import lombok.Data;

import java.util.Date;

/**
 * mccb 外部附件
 *
 * @author OVO
 * @date 2021/11/12
 */
@Data
public class MccbOutsideAttachsDO {
  private Long id;
  private String code;
  private String model;
  private String series;
  private String inm;
  private String icu;
  private String poles;
  private String trip;
  private String specialUse;
  private String attachName;
  private String note;
  private String amount;
  private Long creatorId;
  private Date createTime;
  private Long modifierId;
  private Date modifiedTime;
}
