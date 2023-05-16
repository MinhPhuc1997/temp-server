package minhphuc.serverjva;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import minhphuc.serverjva.domain.system.SystemAccount;
import minhphuc.serverjva.mapper.system.SystemAccountMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("minhphuc.serverjva.mapper")
class ServerjvaApplicationTests {

    @Autowired
    SystemAccountMapper systemAccountMapper;

    @Test
    void contextLoads() {
      List<SystemAccount> as = systemAccountMapper.selectList(new QueryWrapper<>());
      System.out.println(as);
    }

}
