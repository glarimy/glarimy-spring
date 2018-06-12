package com.glarimy.library.service;

import java.util.HashMap;
import java.util.Map;

import com.glarimy.library.api.Book;
import com.glarimy.library.api.BookNotFoundExcetion;
import com.glarimy.library.api.DuplicateBookException;
import com.glarimy.library.api.InvalidBookException;
import com.glarimy.library.api.Library;
import com.glarimy.library.api.LibraryException;

public class LibraryImpl implements Library {
	private Map<Integer, Book> books;

	public LibraryImpl() {
		books = new HashMap<>();
	}

	@Override
	public void add(Book book) throws InvalidBookException, DuplicateBookException, LibraryException {
		if (book == null || book.getIsbn() < 1 || book.getTitle() == null || book.getTitle().trim().length() == 0)
			throw new InvalidBookException();
		if (books.get(book.getIsbn()) != null)
			throw new DuplicateBookException();
		books.put(book.getIsbn(), book);
	}

	@Override
	public Book find(int isbn) throws BookNotFoundExcetion, LibraryException {
		Book book = books.get(isbn);
		if (book == null)
			throw new BookNotFoundExcetion();
		return book;
	}

}
