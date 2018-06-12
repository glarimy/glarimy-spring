package com.glarimy.library.data;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.glarimy.library.api.Book;
import com.glarimy.library.api.LibraryException;

public class LibraryJDBCDataSource implements Store {
	public LibraryJDBCDataSource() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
	}

	@Override
	public void create(Book book) {
		try {
			PreparedStatement sql = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/spring?username=root&password=admin")
					.prepareStatement("INSERT INTO library (isbn, title) VALUES(?,?)");
			sql.setInt(1, book.getIsbn());
			sql.setString(2, book.getTitle());
			sql.executeUpdate();
		} catch (Exception e) {
			throw new LibraryException(e);
		}
	}

	@Override
	public Book read(int isbn) {
		try {
			PreparedStatement sql = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/spring?username=root&password=admin")
					.prepareStatement("SELECT * FROM library WHERE isbn=?");
			sql.setInt(1, isbn);
			ResultSet rs = sql.executeQuery();
			rs.next();
			Book book = new Book();
			book.setIsbn(rs.getInt("isbn"));
			book.setTitle(rs.getString("title"));
			return book;
		} catch (Exception e) {
			throw new LibraryException(e);
		}
	}
}
