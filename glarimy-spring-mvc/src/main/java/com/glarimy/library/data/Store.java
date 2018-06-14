package com.glarimy.library.data;

import com.glarimy.library.api.Book;

public interface Store {

	void create(Book book);

	Book read(int isbn);

}