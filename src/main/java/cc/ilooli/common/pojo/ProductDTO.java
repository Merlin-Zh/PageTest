package cc.ilooli.common.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ProductDTO {
    private String materialCode;
    private String materialName;
    private String materialModel;
    private String materialNote;
    private String materialCurrent;

    private Map<String, String> info = new HashMap<>();
    private List<BomDTO> bom = new ArrayList<>();
}
