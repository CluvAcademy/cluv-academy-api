package com.ec.cluv.academy.config.bdd.bddcluv;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "pubEntityManagerFactory",
        transactionManagerRef = "pubTransactionManager",
        basePackages = {
                "com.ec.cluv.academy.repository.publick",
                "com.ec.cluv.academy.repository.academy"
        }
)
public class SchPublicConfig {

    @Autowired
    private Environment env;


    @Primary
    @Bean(name = "pubDataSource")
    public DataSource adminDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("db.spring.datasource.url"));
        dataSource.setUsername(env.getProperty("db.spring.datasource.username"));
        dataSource.setPassword(env.getProperty("db.spring.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));


        return dataSource;
    }

    @Primary
    @Bean(name = "pubEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(adminDatasource());
        em.setPackagesToScan(
                "com.ec.cluv.academy.model.entities.publick",
                "com.ec.cluv.academy.model.entities.academy");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql"));
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.database-platform"));

        em.setJpaPropertyMap(properties);

        return em;

    }

    @Primary
    @Bean(name = "pubTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }


}
