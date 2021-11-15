package cc.ilooli.common.controller;

import cc.ilooli.common.pojo.BomDTO;
import cc.ilooli.common.pojo.BomVO;
import cc.ilooli.common.pojo.ProductDTO;
import cc.ilooli.common.pojo.ProductQuery;
import cc.ilooli.common.result.BaseResult;
import cc.ilooli.common.service.CommonProductService;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * bom控制器
 *
 * @author OVO
 * @date 2021/11/15
 */
@RestController
@RequestMapping("/api")
public class BomController {

    private static final Log logger = LogFactory.get();

    private final CommonProductService productService;

    public BomController(CommonProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getBomsByCodes")
    public BaseResult<List<BomVO>> getBomsByCodes(@RequestBody List<String> codes) {
        logger.info("接收到物料编码： {}", codes);
        List<BomVO> bomList = new ArrayList<>();

        codes.forEach(code -> {
            logger.info("开始获取 {} 的BOM信息...", code);
            ProductDTO product = productService.getProductByCode(code);
            List<BomDTO> bomDTOList = productService.getProductBom(product);
            bomList.addAll(Convert.convert(new TypeReference<List<BomVO>>() {}, bomDTOList));
        });
        logger.info("本次获取到的BOM列表为：", bomList);
        return BaseResult.success(bomList);
    }

    @PostMapping("/getBomsByInfos")
    public BaseResult<List<BomVO>> getBomByInfos(@RequestBody List<ProductQuery> queryList){
        logger.info("接收到物料信息：", queryList);
        List<BomVO> bomList = new ArrayList<>();

        queryList.forEach(query -> {
            logger.info("开始获取 {} 的BOM信息...", query.getModel());
            ProductDTO product = productService.getProductByInfo(query);
            List<BomDTO> bomDTOList = productService.getProductBom(product);
            bomList.addAll(Convert.convert(new TypeReference<>(){}, bomDTOList));
        });
        logger.info("本次获取到的BOM列表为：", bomList);
        return BaseResult.success();
    }
}
