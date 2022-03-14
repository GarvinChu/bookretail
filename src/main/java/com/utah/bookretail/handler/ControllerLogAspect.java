package com.utah.bookretail.handler;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class ControllerLogAspect {

    // controller 下的所有方法
    @Around("execution(* com.utah.bookretail.controller..*.*(..))")
    public Object doAround(ProceedingJoinPoint call) throws Throwable {
        MethodSignature signature = (MethodSignature) call.getSignature();
        Object[] args = call.getArgs();
        if (args.length <= 0) {
            return call.proceed();
        }
        Method method = signature.getMethod();
        String methodName = method.getName();
        String[] classNameArray = method.getDeclaringClass().getName().split("\\.");
        String className = classNameArray[classNameArray.length - 1];
        StringBuilder buffer = new StringBuilder();
        for (Object arg : args) {
            buffer.append(" ");
            buffer.append(arg);
        }
        log.info("请求方法:{},请求参数:{}", className + "." + methodName, buffer.toString());
        // 主要业务
        Object result = call.proceed();
        // 返回结果
        String resJson = JSON.toJSONString(result);
        log.info("请求返回结果{}", resJson);
        return result;
    }

}
