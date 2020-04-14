package me.ixk.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(me.ixk.aop.annotation.Log)")
    public void pointCut() {}

    @Before("pointCut()")
    // 前置切面
    public void before() {
        System.out.println("Before Aspect");
    }

    @After("pointCut()")
    // 后置切面
    public void after() {
        System.out.println("After Aspect");
    }

    @Around("pointCut()")
    // 环绕切面
    // 在 joinPoint.proceed() 方法前的等同于 @After
    // 在 joinPoint.proceed() 方法后的等同于 @Before
    public Object around(ProceedingJoinPoint joinPoint) throws Exception {
        System.out.println("Before Aspect [Around]");
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("After Aspect [Around]");
        // throw new Exception("Error");
        return result;
    }

    @AfterReturning("pointCut()")
    // 切面如果没出现异常 @AfterReturning 就会被执行
    public void returning() {
        System.out.println("Returning");
    }

    @AfterThrowing("pointCut()")
    // 切面出现异常 @AfterThrowing 就会被执行
    public void throwing() {
        System.out.println("Throwing");
    }
}
