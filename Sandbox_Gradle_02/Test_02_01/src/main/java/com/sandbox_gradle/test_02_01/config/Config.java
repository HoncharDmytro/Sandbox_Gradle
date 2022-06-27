package com.sandbox_gradle.test_02_01.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@PropertySource("classpath:properties/app.properties")
@ComponentScan(basePackages = {"com.sandbox_gradle.test_02_01.dao", "com.sandbox_gradle.test_02_01.config"})
@EnableTransactionManagement
public class Config {
    private static final Logger logger = LoggerFactory.getLogger(Config.class);

    @Value("${driverClassName}")
    private String driverClassName;
    @Value("${url}")
    private String url;
    @Value("${user}")
    private String username;
    @Value("${password}")
    private String password;
    @Value("${dialect}")
    private String dialect;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public BasicDataSource dataSource() {
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName(driverClassName);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            return dataSource;
        } catch (Exception e) {
            logger.error("BasicDataSource bean cannot be created!", e);
            return null;
        }
    }

    private Properties hibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.dialect", dialect);
        hibernateProp.put("hibernate.hbm2ddl.auto", "create");
//        hibernateProp.put("hibernate.format_sql", true);
//        hibernateProp.put("hibernate.use_sql_comments", true);
//        hibernateProp.put("hibernate.show_sql", true);
        hibernateProp.put("hibernate.max_fetch_depth", 3);
        hibernateProp.put("hibernate.jdbc.batch_size", 10);
        hibernateProp.put("hibernate.jdbc.fetch_size", 50);
        return hibernateProp;
    }

    @Bean(initMethod = "initDB", destroyMethod = "clearDB")
    public SessionFactory sessionFactory() {
        return new LocalSessionFactoryBuilder(dataSource())
                .scanPackages("com.sandbox_gradle.test_02_01.entities")
                .addProperties(hibernateProperties())
                .buildSessionFactory();
    }

    @Bean()
    public PlatformTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory());
    }
}