package cc.ilooli.mccb.mapper;

import cc.ilooli.mccb.pojo.MccbBodyRulesDO;
import cc.ilooli.mccb.pojo.MccbBodyRulesQuery;
import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
//@Transactional
@ExtendWith(MockitoExtension.class)
class BodyRulesMapperTest {
    @Autowired
    private BodyRulesMapper mapper;
    private MccbBodyRulesQuery query;
    private MccbBodyRulesDO rule;

    @BeforeEach
    void setUp() {
        query = new MccbBodyRulesQuery();
        query.setSeries("BM30");

        rule = new MccbBodyRulesDO();
        rule.setSeries("BM5");
        rule.setInm("125");
        rule.setIcu("H");
        rule.setPoles("3");
        rule.setToIcu("M");
        rule.setToPoles("3");
        rule.setPriority(1);
    }

    @Test
    void testGetRulesByDO() {
        List<MccbBodyRulesDO> rulesByDO = mapper.getByQuery(query);
        rulesByDO.forEach(System.out::println);
        if (rulesByDO.size() > 0) {
            for (MccbBodyRulesDO rulesDO : rulesByDO) {
                System.out.println(rulesDO);
            }
        } else {
            System.out.println("cannot get anything...");
        }
    }

    @Test
    void save() {
        MccbBodyRulesQuery query = new MccbBodyRulesQuery();
        query.setSeries(rule.getSeries());
        query.setInm(rule.getInm());
        query.setIcu(rule.getIcu());
        rule.setCreatorId(10001L);
        rule.setCreateTime(DateUtil.date());

        rule.setModifierId(10001L);
        rule.setCreateTime(DateUtil.date());

        mapper.save(rule);
        List<MccbBodyRulesDO> rulesDOS = mapper.getByQuery(query);
        rulesDOS.forEach(System.out::println);
    }

    @Test
    void update() {
        if (rule.getId() == null) {
            rule.setId(32L);
        }
        rule.setModifierId(10002L);
        rule.setModifiedTime(DateUtil.date());

        System.out.println(mapper.update(rule));
    }

    @Test
    void delete() {
        if (rule.getId() == null) {
            rule.setId(32L);
        }
        assertFalse(mapper.delete(33L));
        System.out.println(mapper.delete(rule.getId()));
    }
}