package org.demo.app;

import org.demo.models.OfficesEntity;
import org.demo.models.ProductsEntity;
import org.demo.services.Services;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alexandr on 10.11.2016.
 */
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("org.demo");//new ClassPathXmlApplicationContext("context_spring.xml");
        Services<ProductsEntity> productsServices = (Services<ProductsEntity>) ctx.getBean("comservice");
        Services<OfficesEntity> officesServices = (Services<OfficesEntity>) ctx.getBean("comservice");
        //ProductsServices productsServices = (ProductsServices) ctx.getBean("productservice");
        List<ProductsEntity> entityList = productsServices.getAll(ProductsEntity.class);
        entityList.forEach(System.out::println);
        List<OfficesEntity> officesEntities = officesServices.getByField(OfficesEntity.class, "city", "Denver");
        officesEntities.forEach(System.out::println);
        List<Integer> numbers = Arrays.asList(3, 2, 2, 5, 3, 7, 10);
        List<Integer> sql = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        sql.forEach(System.out::print);
    }
}
