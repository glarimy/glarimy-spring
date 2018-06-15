package com.glarimy.library.service;

import com.glarimy.library.api.Book;
import com.glarimy.library.api.BookNotFoundExcetion;
import com.glarimy.library.api.DuplicateBookException;
import com.glarimy.library.api.InvalidBookException;
import com.glarimy.library.api.Library;
import com.glarimy.library.api.LibraryException;
import com.glarimy.library.data.Store;

public class LibraryImpl implements Library {
	private Store store;

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Override
	public void add(Book book) throws InvalidBookException, DuplicateBookException, LibraryException {
		if (book == null || book.getIsbn() < 1 || book.getTitle() == null || book.getTitle().trim().length() == 0)
			throw new InvalidBookException();
		if (store.read(book.getIsbn()) != null)
			throw new DuplicateBookException();
		store.create(book);
	}

	@Override
	public Book find(int isbn) throws BookNotFoundExcetion, LibraryException {
		Book book = store.read(isbn);
		if (book == null)
			throw new BookNotFoundExcetion();
		return book;
	}

}
