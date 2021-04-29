package com.sp.config;

import com.sp.dao.MerchantProductRepositoryImpl;
import com.sp.dao.MerchantRepositoryImpl;
import com.sp.dao.ProductRepositoryImpl;
import com.sp.service.MerchantProductService;
import com.sp.service.MerchantService;
import com.sp.service.ProductService;
import com.sp.webservice.MerchantProductWs;
import com.sp.webservice.MerchantWs;
import com.sp.webservice.ProductWs;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:persistence-postgresql.properties"})
public class ApplicationConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        final BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.user"));
        dataSource.setPassword(environment.getProperty("jdbc.pass"));

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.sp.entities"});
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(final SessionFactory sessionFactory) {
        final HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

    final Properties hibernateProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        return hibernateProperties;
    }

    // Spring Beans

    @Bean
    public MerchantService merchantService() {
        return new MerchantService();
    }

    @Bean
    public MerchantRepositoryImpl merchantRepository() {
        return new MerchantRepositoryImpl();
    }

    @Bean
    public ProductService productService() {
        return new ProductService();
    }

    @Bean
    public ProductRepositoryImpl productRepository() {
        return new ProductRepositoryImpl();
    }

    @Bean
    public MerchantProductRepositoryImpl merchantProductRepository() {
        return new MerchantProductRepositoryImpl();
    }

    @Bean
    public MerchantProductService merchantProductService() {
        return new MerchantProductService();
    }

    @Bean
    public ProductWs productWs() {
        return new ProductWs();
    }

    @Bean
    public MerchantWs merchantWs() {
        return new MerchantWs();
    }

    @Bean
    public MerchantProductWs merchantProductWs() {
        return new MerchantProductWs();
    }

}
