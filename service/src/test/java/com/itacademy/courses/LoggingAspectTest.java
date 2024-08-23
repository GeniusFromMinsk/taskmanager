package com.itacademy.courses;

import com.itacademy.courses.config.AppConfig;
import com.itacademy.courses.services.UserService;
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
