package me.ixk.filter_interceptor.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Around("@annotation(me.ixk.filter_interceptor.annotation.Log)")
    public Object around(ProceedingJoinPoint joinPoint) {
        System.out.println("开始执行切面");
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(result);
        System.out.println("切面执行完毕");
        return result;
    }
}
