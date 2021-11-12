package cc.ilooli.mccb.mapper;

import cc.ilooli.mccb.pojo.*;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * mccb附件mapper
 *
 * @author OVO
 * @date 2021/11/12
 */
@Mapper
@DS("second")
public interface MccbAttachMapper {

    /**
     * 通过编码和型号获取附件名称
     *
     * @param code  编码
     * @param model 型号
     * @return {@link String}
     */
    String getByInfo(@Param("code") String code, @Param("model") String model);

    /**
     * 获取内部附件信息
     *
     * @param model 型号
     * @param name  名称
     * @param note  备注
     * @return {@link MccbInsideAttachDataDO}
     */
    MccbInsideAttachDataDO getInsideAttachByInfo(@Param("model") String model, @Param("name") String name, @Param("note") String note);

    /**
     * 获取外部附件信息
     *
     * @param attachsDO 外部附件DO
     * @return {@link MccbOutsideAttachsDO}
     */
    MccbOutsideAttachsDO getOutsideAttach(MccbOutsideAttachsDO attachsDO);

    /**
     * 以分页形式获取外部附件列表
     *
     * @param query 查询
     * @return {@link List}<{@link MccbOutsideAttachsDO}>
     */
    List<MccbOutsideAttachsDO> getOutsideAttachsList(MccbOutsideAttachQuery query);

    /**
     * 以分页形式获取内部附件列表
     *
     * @param query 查询
     * @return {@link List}<{@link MccbInsideAttachDataDO}>
     */
    List<MccbInsideAttachDataDO> getInsideAttachDataList(MccbInsideAttachDataQuery query);

    /**
     * 以分页形式获取内部附件代号表
     *
     * @param query 查询
     * @return {@link List}<{@link MccbInsideAttachCodeDO}>
     */
    List<MccbInsideAttachCodeDO> getInsideAttachCodeList(MccbInsideAttachCodeQuery query);

    /**
     * 保存外部附件
     *
     * @param attachsDO 外部附件
     * @return boolean
     */
    boolean saveOutsideAttach(MccbOutsideAttachsDO attachsDO);

    /**
     * 保存内部附件数据
     *
     * @param dataDO 内部附件
     * @return boolean
     */
    boolean saveInsideAttachData(MccbInsideAttachDataDO dataDO);

    /**
     * 保存内部附件代号
     *
     * @param codeDO 附件代号信息
     * @return boolean
     */
    boolean saveInsideAttachCode(MccbInsideAttachCodeDO codeDO);

    /**
     * 更新外部附件
     *
     * @param attachsDO 外部附件
     * @return boolean
     */
    boolean updateOutsideAttach(MccbOutsideAttachsDO attachsDO);

    /**
     * 更新内部附件数据
     *
     * @param dataDO 内部附件
     * @return boolean
     */
    boolean updateInsideAttachData(MccbInsideAttachDataDO dataDO);

    /**
     * 更新内部附件代号
     *
     * @param codeDO 内部附件代号信息
     * @return boolean
     */
    boolean updateInsideAttachCode(MccbInsideAttachCodeDO codeDO);

    /**
     * 删除外部附件
     *
     * @param id id
     * @return boolean
     */
    boolean deleteOutsideAttach(@Param("id") Long id);

    /**
     * 删除内部附件数据
     *
     * @param id id
     * @return boolean
     */
    boolean deleteInsideAttachData(@Param("id") Long id);

    /**
     * 删除内部附件代号
     *
     * @param id id
     * @return boolean
     */
    boolean deleteInsideAttachCode(@Param("id") Long id);
}
