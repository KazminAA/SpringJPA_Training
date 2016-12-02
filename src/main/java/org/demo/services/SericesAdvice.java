package org.demo.services;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Alexandr on 25.11.2016.
 */
@Component
@Aspect
public class SericesAdvice {
    @Autowired
    ApplicationContext ctx;

    @Pointcut("execution(* org.demo.services.Services.deleteByField(Class, String, String)) " +
            "&& args(tClass, fieldName, value)))")
    public <T> void Deleted(Class<T> tClass, String fieldName, String value) {
    }

    @Before("Deleted(tClass, fieldName, value)")
    public <T> void LastChanse(Class<T> tClass, String fieldName, String value) {
        System.out.println(tClass.getClass().getSimpleName());
        System.out.println(fieldName);
        System.out.println(value);
        Services<T> service = (Services<T>) ctx.getBean("comservice");
        List<T> result = service.getByField(tClass, fieldName, value);
        result.forEach(System.out::println);
    }
}
