package com.niit.userconfiguration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit")
public class UserConfig {

	 @Bean
	   public LocalSessionFactoryBean sessionFactory() {
	      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	      sessionFactory.setDataSource(restDataSource());
	 
	      sessionFactory.setPackagesToScan(
	    	        new String[] { "com.niit.CRUDhibernatemodel" });
	    sessionFactory.setHibernateProperties(hibernateProperties());
	      return sessionFactory;
	   }
	 
	 @Bean
	 public DriverManagerDataSource restDataSource() {
		 DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource("jdbc:h2:tcp://localhost/~/test", "sa","");
		 driverManagerDataSource.setDriverClassName("org.h2.Driver");
	     
		 return driverManagerDataSource;
	   }
	 
	 @Bean
	   @Autowired
	   public HibernateTransactionManager transactionManager(
	     SessionFactory sessionFactory) {
	  
	      HibernateTransactionManager txManager
	       = new HibernateTransactionManager();
	      txManager.setSessionFactory(sessionFactory);
	 
	      return txManager;
	   }
	 
	 Properties hibernateProperties() {
		Properties properties=new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.globally_quoted_identifiers",
	             "true");	
		 
		return properties;
		}
		 
	 }

