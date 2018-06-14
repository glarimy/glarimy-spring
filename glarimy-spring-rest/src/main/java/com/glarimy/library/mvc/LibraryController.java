package com.glarimy.library.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.glarimy.library.api.Book;
import com.glarimy.library.api.Library;
import com.glarimy.library.api.LibraryException;

@RestController
public class LibraryController {
	@Autowired
	Library library;

	@RequestMapping(value = "/book", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Integer> add(@RequestBody Book book) {
		library.add(book);
		return new ResponseEntity<Integer>(book.getIsbn(), HttpStatus.OK);
	}

	@RequestMapping(value = "/book/{isbn}", method = RequestMethod.GET)
	public @ResponseBody Book find(@PathVariable("isbn") int isbn) {
		Book book;
		try {
			book = library.find(isbn);
			return book;
		} catch (LibraryException e) {
			return null;
		}
	}
}
