package com.montrealcollege.webservicesassignment.config;

import oracle.jdbc.pool.OracleDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.montrealcollege.webservicesassignment.config"})
public class HibernateConfig {

    @Bean
    public LocalSessionFactoryBean sessionFactory() throws SQLException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSourceOracle());
        sessionFactory.setPackagesToScan("com.montrealcollege.webservicesassignment.model");
        sessionFactory.setHibernateProperties(hibernatePropertiesOracle());
         return sessionFactory;
    }
    
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }
    
    @Bean
    public DataSource dataSourceOracle() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setURL("jdbc:oracle:thin:@//localhost:1521/ORCLPDB1.localdomain");
        dataSource.setUser("hr");
        dataSource.setPassword("hr");
        return dataSource;
    }
    
    private final Properties hibernatePropertiesOracle() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
          "hibernate.dialect", "org.hibernate.dialect.Oracle8iDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        return hibernateProperties;
    }
}
