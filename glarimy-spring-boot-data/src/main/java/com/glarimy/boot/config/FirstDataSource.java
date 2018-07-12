package com.glarimy.boot.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = {
		"com.glarimy.boot.first" }, entityManagerFactoryRef = "firstEntityManager", transactionManagerRef = "firstTransactionManager")
public class FirstDataSource {
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean firstEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(firstDatasource());
		em.setPackagesToScan(new String[] { "com.glarimy.boot" });
		em.setPersistenceUnitName("firstEntityManager");
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		em.setJpaPropertyMap(properties);
		return em;
	}

	@Primary
	@Bean
	public DataSource firstDatasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/first");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		return dataSource;
	}

	@Primary
	@Bean
	public PlatformTransactionManager firstTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(firstEntityManager().getObject());
		return transactionManager;
	}
}
