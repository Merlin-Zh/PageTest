package cc.ilooli.mccb.mapper;

import cc.ilooli.mccb.pojo.MccbBodyRulesDO;
import cc.ilooli.mccb.pojo.MccbBodyRulesQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BodyRulesMapperTest {
    @Autowired
    BodyRulesMapper mapper;
    MccbBodyRulesQuery query;

    @BeforeEach
    void setUp() {
        query = new MccbBodyRulesQuery();
        query.setSeries("BM30");
    }

    @Test
    void getRulesByDO() {
        List<MccbBodyRulesDO> rulesByDO = mapper.getRulesByDO(query);
        rulesByDO.forEach(System.out::println);
    }
}