package com.glarimy.spring.hysterix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolServiceController {
	@Autowired
	RetailService retailService;

	@RequestMapping(value = "/book/{isbn}", method = RequestMethod.GET)
	public Book find(@PathVariable int isbn) {
		return retailService.find(isbn);
	}
}
