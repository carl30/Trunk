package com.carlcorp.aop.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SpringAOPInterceptorExample {

    private static Logger logger = LogManager.getLogger(SpringAOPInterceptorExample.class.getName());

    @Pointcut("execution(* com.carlcorp.service.useractivities.UserLoginService.*(..))")
    private void userLoginPointCut(){}

    @Before(value = "userLoginPointCut()")
    private void beforeUserlogin(){
       logger.info("beforeUserlogin");
    }

    @After(value = "userLoginPointCut()")
    private void afterUserlogin(){
        logger.info("afterUserlogin");
    }

}
