package com.glarimy.spring.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RetailController {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/book/{isbn}", method = RequestMethod.GET)
	public Book find(@PathVariable int isbn) {
		Book response = restTemplate.exchange("http://book-service/book/{isbn}", HttpMethod.GET, null,
				new ParameterizedTypeReference<Book>() {
				}, isbn).getBody();
		return response;
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
