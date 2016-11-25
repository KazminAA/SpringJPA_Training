package org.demo.services;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Alexandr on 25.11.2016.
 */
@Aspect
public class SericesAdvice {
    @Pointcut("execution(* org.demo.services.Services.deleteByField(Class, String, String)) " +
            "&& args(tClass, fieldName, value)))")
    public <T> void LastChanse(Class<T> tClass, String fieldName, String value) {
    }
}
