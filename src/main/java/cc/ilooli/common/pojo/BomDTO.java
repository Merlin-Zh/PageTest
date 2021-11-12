package cc.ilooli.common.pojo;

import lombok.Data;

@Data
public class BomDTO {
    String motherCode;
    String childCode;
    String childName;
    String childModel;
    String current;
    String note;
    Integer amount;
    String tag;
}
