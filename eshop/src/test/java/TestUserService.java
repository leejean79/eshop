
import com.leejean.eshop.model.User;
import com.leejean.eshop.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试UserService类
 */
public class TestUserService {

    @Test
    public void saveUser() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserService us = (UserService) ac.getBean("userService");
        User u = new User();
        u.setName("tom");
        u.setPassword("123456");
        us.saveEntity(u);
    }
}
