package org.impelsys.SpringBootDemo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration    //<bean>
@EnableTransactionManagement
public class DbConfig {
	
	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.jpa.properties.hibernate.dialect}")
	private String dialect;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddlAuto;
/*	
	@Value("${app.profile}")
	private static String profile;
	
	@Value("${spring.profiles.active}")
	private static String activeProfile;
*/	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
		
	}
	@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory(){
		//System.out.println("Active profile:" +profile);
		//System.out.println("Profile: " +profile);
		//System.out.println("Selected Profile:" +activeProfile);
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("org.impelsys.SpringBootDemo.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	@Bean 
	public HibernateTransactionManager hibernateTransactionManager(){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	
	private final Properties hibernateProperties(){
		 Properties hibernateProperties = new Properties();
		 hibernateProperties.setProperty("hibernate.hbm2ddl.auto", ddlAuto);
		 hibernateProperties.setProperty("hibernate.dialect", dialect);
		 hibernateProperties.setProperty("hibernate.show_sql", "true");
		 return hibernateProperties;
	}
}
