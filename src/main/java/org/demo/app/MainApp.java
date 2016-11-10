package org.demo.app;

import org.demo.models.ProductsEntity;
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
        Services<ProductsEntity> productsServices = (Services<ProductsEntity>) ctx.getBean("comservice");
        //ProductsServices productsServices = (ProductsServices) ctx.getBean("productservice");
        List<ProductsEntity> entityList = productsServices.getAll(ProductsEntity.class);
        entityList.forEach(System.out::println);
    }
}
