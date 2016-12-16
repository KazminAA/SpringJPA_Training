package org.demo.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Alexandr on 11.11.2016.
 */

@Configuration
@ComponentScan(basePackages = {
        "org.demo"
})
@EnableAspectJAutoProxy
@PropertySource("classpath:/application.properties")
@EnableJpaRepositories(basePackages = {
        "org.demo.daos"
})
@EnableTransactionManagement
public class PersistenceContext {

    @Autowired
    Environment env;

    @Bean(destroyMethod = "close")
    DataSource dataSource() {
       /* BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
        dataSource.setUrl(env.getRequiredProperty("db.url"));
        dataSource.setUsername(env.getRequiredProperty("db.user"));
        dataSource.setPassword(env.getRequiredProperty("db.pwd"));
*/
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(env.getRequiredProperty("db.driver"));
        hikariConfig.setJdbcUrl(env.getRequiredProperty("db.url"));
        hikariConfig.setUsername(env.getRequiredProperty("db.user"));
        hikariConfig.setPassword(env.getRequiredProperty("db.pwd"));

        hikariConfig.setPoolName("hikariCPPool");
        hikariConfig.setMaximumPoolSize(Integer.parseInt(env.getRequiredProperty("max_pool_size")));
        hikariConfig.setConnectionTestQuery("SELECT 1");

        hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
        hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");


        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        return dataSource;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("org.demo.models");

        Properties jpaProperies = new Properties();
        jpaProperies.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        jpaProperies.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        jpaProperies.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        jpaProperies.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));

        entityManagerFactoryBean.setJpaProperties(jpaProperies);

        return entityManagerFactoryBean;
    }

    @Bean
    JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
/*
    @Bean
    SericesAdvice sericesAdvice() {
        return new SericesAdvice();
    }*/
@Bean
public BeanPostProcessor persistenceTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
}
}
