package cc.ilooli.common.pojo;

import cc.ilooli.common.service.ProductProcesser;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品dto
 *
 * @author OVO
 * @date 2021/11/15
 */
@Data
public class ProductDTO {
    private String materialCode;
    private String materialName;
    private String materialModel;
    private String materialNote;
    private String materialCurrent;

    private Map<String, String> info;
    private List<BomDTO> bom;

    public ProductDTO() {
        this.info = new HashMap<>();
        this.bom = new ArrayList<>();
    }
}
