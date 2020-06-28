package net.lz1998.demo;

import net.lz1998.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest(classes = SpringCqDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringCqDemoApplicationTests {

    @Autowired
    UserService userService;

    @Test
    @Rollback(false)
    void contextLoads() {
        userService.addNewUser(1L,"1");
    }

}
