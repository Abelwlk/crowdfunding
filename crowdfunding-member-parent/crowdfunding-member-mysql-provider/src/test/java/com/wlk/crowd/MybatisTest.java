package com.wlk.crowd;

import com.wlk.crowd.entity.po.MemberPO;
import com.wlk.crowd.mapper.MemberPOMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private MemberPOMapper memberPOMapper;

    @Test
    public void test01() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(dataSource);
    }

    @Test
    public void test02() throws SQLException {
        MemberPO memberPO = new MemberPO(1, "wlk", "123456", "wlk", "wlk@qq.com", 1, 1, "aaa", "1", 1);
        int insert = memberPOMapper.insert(memberPO);
        System.out.println(insert);
    }
}
