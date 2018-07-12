package com.glarimy.boot.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glarimy.boot.first.FirstRepository;
import com.glarimy.boot.model.Book;
import com.glarimy.boot.second.SecondRepository;

@Service
public class BookService {
	@Autowired
	private FirstRepository first;

	@Autowired
	private SecondRepository second;

	@Transactional
	public void add(Book book) {
		first.save(book);
	}

	@Transactional
	public void copy(int isbn) {
		Book book = first.findOne(isbn);
		second.save(book);
	}
}
