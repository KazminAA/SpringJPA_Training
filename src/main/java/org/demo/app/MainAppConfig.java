package org.demo.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.demo.services.ProductsServices;

@Configuration
public class MainAppConfig {

    @Bean
    public ProductsServices productsServices(){
        return new ProductsServices();
    }
}
