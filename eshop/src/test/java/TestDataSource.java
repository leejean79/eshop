import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

public class TestDataSource {

     //测试连接是否成
    @Test
    public void getConn() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        DataSource ds = (DataSource) ac.getBean("dataSource");
        Connection conn = ds.getConnection() ;
        System.out.println(conn);
    }
}
