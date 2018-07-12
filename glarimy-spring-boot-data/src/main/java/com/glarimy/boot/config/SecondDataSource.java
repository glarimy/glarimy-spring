package com.glarimy.boot.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = {
		"com.glarimy.boot.second" }, entityManagerFactoryRef = "secondEntityManager", transactionManagerRef = "secondTransactionManager")
public class SecondDataSource {
	@Bean
	public LocalContainerEntityManagerFactoryBean secondEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(secondDatasource());
		em.setPackagesToScan(new String[] { "com.glarimy.boot" });
		em.setPersistenceUnitName("secondEntityManager");
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		em.setJpaPropertyMap(properties);
		return em;
	}

	@Bean
	public DataSource secondDatasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/second");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager secondTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(secondEntityManager().getObject());
		return transactionManager;
	}
}
