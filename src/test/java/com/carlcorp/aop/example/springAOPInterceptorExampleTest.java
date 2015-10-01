package com.carlcorp.aop.example;

import com.carlcorp.model.User;
import com.carlcorp.service.useractivities.UserLoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;


public class springAOPInterceptorExampleTest {

    private final String CONFIG_PATH = "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml";

    protected ApplicationContext applicationContext;
    protected UserLoginService userLoginService;

    @BeforeClass
    public void setup() {
        this.applicationContext = new  ClassPathXmlApplicationContext(CONFIG_PATH);
        this.userLoginService = (UserLoginService)applicationContext.getBean("userLoginService");
    }

    @Test
    public void testPrintWelcome(){

        int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));

//        ((ClassPathXmlApplicationContext) applicationContext).close();

        System.out.println("test start");
        userLoginService.verifyCurrentUser(new User(1, "carl"));
        System.out.println("end\n");
    }
}
