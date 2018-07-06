package com.glarimy.spring.eureka;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@RequestMapping(value = "/book/{isbn}", method = RequestMethod.GET)
	public Book find(@PathVariable int isbn) {
		return new Book(isbn, "Some Title");
	}
}
