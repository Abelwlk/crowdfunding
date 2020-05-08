import com.wlk.crowd.util.CrowdUtil;
import org.junit.Test;

public class StringTest {

    @Test
    public void test(){
        String source = "123456";
        String s = CrowdUtil.md5(source);
        System.out.println(s);
    }
}
