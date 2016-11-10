package app;

import models.ProductsEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.ProductsServices;

import java.util.List;

/**
 * Created by Alexandr on 10.11.2016.
 */
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context_spring.xml");
        //Services<ProductsEntity> productsServices = (Services<ProductsEntity>) ctx.getBean("CommonServicesImpl");
        ProductsServices productsServices = (ProductsServices) ctx.getBean("ProductsServices");
        List<ProductsEntity> entityList = productsServices.getAll(ProductsEntity.class);
        entityList.forEach(System.out::println);
    }
}
