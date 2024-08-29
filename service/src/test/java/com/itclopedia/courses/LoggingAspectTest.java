package com.itclopedia.courses;

import com.itclopedia.courses.config.AppConfig;
import com.itclopedia.courses.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoggingAspectTest {

    @Test
    public void testLoggingAspect() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        assertNotNull(userService);
        userService.getUserById(1);

        context.close();
    }
}
