package cc.ilooli.mccb.service;

import cc.ilooli.common.mapper.CommonProductMapper;
import cc.ilooli.common.pojo.ProductDTO;
import cc.ilooli.common.service.CommonBomService;
import cc.ilooli.mccb.mapper.MccbAttachMapper;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 塑壳BOM service实现
 *
 * @author OVO
 * @date 2021/11/12
 */
@Service("MccbBomServiceImpl")
public class MccbBomServiceImpl implements CommonBomService {

    private static final Log logger = LogFactory.get();
    private final CommonProductMapper commonProductMapper;
    private final MccbAttachMapper attachMapper;
    private final MccbProductProcesser processer;
    private ProductDTO product;

    public MccbBomServiceImpl(CommonProductMapper commonProductMapper,
                              MccbAttachMapper attachMapper, MccbProductProcesser processer) {
        this.commonProductMapper = commonProductMapper;
        this.attachMapper = attachMapper;
        this.processer = processer;
    }

    @Override
    public void addBom(ProductDTO productDTO) {
        // process productDTO to acquire product's field and info map
        this.product = this.processer.getProcessedProduct(productDTO);

        this.getBodyBom();
        this.getInsideAttachBom();
        this.getOutsideAttachBom();
        this.getOperation();
        this.getInstallation();
    }

    private void getBodyBom() {
    }

    private void getInsideAttachBom() {
    }

    private void getOutsideAttachBom() {
    }

    private void getOperation() {
    }

    private void getInstallation() {
    }
}
