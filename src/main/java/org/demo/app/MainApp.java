package org.demo.app;

import org.demo.models.OfficesEntity;
import org.demo.services.Services;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Alexandr on 10.11.2016.
 */
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context_spring.xml");//new AnnotationConfigApplicationContext("org.demo");
        Services<OfficesEntity> productsServices = (Services<OfficesEntity>) ctx.getBean("comservice");
        //ProductsServices productsServices = (ProductsServices) ctx.getBean("productservice");
        List<OfficesEntity> entityList = productsServices.getAll(OfficesEntity.class);
        entityList.forEach(System.out::println);
    }
}
