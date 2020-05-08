import com.wlk.crowd.entity.Admin;
import com.wlk.crowd.entity.Role;
import com.wlk.crowd.mapper.AdminMapper;
import com.wlk.crowd.mapper.RoleMapper;
import com.wlk.crowd.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml","classpath:spring-web-mvc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CrowdTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void testBCryptPasswordEncoder(){
        System.out.println(passwordEncoder.encode("123456"));
    }


    @Test
    public void testPageHelper(){
        for (int i =0;i<150;i++){
            //adminMapper.insert(new Admin(null, "loginAccT"+i, "123456", "汤姆"+i, "tom@qq.com"+i, null));
            roleMapper.insert(new Role(null,"role"+i));
        }
    }

    @Test
    public void testAdminService() {
        Admin admin = new Admin(null, "tom", "123456", "汤姆", "tom@qq.com", null);
        adminService.saveAdmin(admin);
    }

    @Test
    public void testAdmin() {
        Admin admin = new Admin(null, "tom", "123456", "汤姆", "tom@qq.com", null);
        int i = adminMapper.insert(admin);
        System.out.println(i);
    }

    @Test
    public void testDatasource() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }


}
