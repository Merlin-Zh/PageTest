package cc.ilooli.mccb.mapper;

import cc.ilooli.mccb.pojo.MccbBodyRulesDO;
import cc.ilooli.mccb.pojo.MccbBodyRulesQuery;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 本体规则映射器
 *
 * @author OVO
 * @date 2021/11/12
 */
@Mapper
@DS("second")
public interface BodyRulesMapper {

    /**
     * 以分页形式获取本体规则列表
     *
     * @param query 查询
     * @return {@link List}<{@link MccbBodyRulesDO}>
     */
    List<MccbBodyRulesDO> getByQuery(MccbBodyRulesQuery query);

    /**
     * 保存
     *
     * @param rulesDO 规则
     * @return boolean
     */
    boolean save(MccbBodyRulesDO rulesDO);

    /**
     * 更新
     *
     * @param rulesDO 规则
     * @return boolean
     */
    boolean update(MccbBodyRulesDO rulesDO);

    /**
     * 删除
     *
     * @param id id
     * @return boolean
     */
    boolean delete(@Param("id") Long id);
}
