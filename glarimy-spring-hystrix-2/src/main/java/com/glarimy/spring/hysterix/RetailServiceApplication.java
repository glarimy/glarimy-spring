package com.glarimy.spring.hysterix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
public class RetailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailServiceApplication.class, args);
	}
}
