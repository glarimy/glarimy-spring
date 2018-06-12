package com.glarimy.library.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.glarimy.library.api.Book;

public class LibraryStore extends JdbcDaoSupport implements Store {
	public void create(Book book) {
		getJdbcTemplate().update("INSERT INTO library VALUES(?, ?)", new Object[] { book.getIsbn(), book.getTitle() });
	}

	public Book read(int isbn) {
		List<Book> list = getJdbcTemplate().query("SELECT * FROM library where isbn=?", new Object[] { isbn },
				new RowMapper<Book>() {
					public Book mapRow(ResultSet rs, int rowNo) throws SQLException {
						Book book = new Book();
						book.setIsbn(rs.getInt("isbn"));
						book.setTitle(rs.getString("title"));
						return book;
					}
				});
		if (list.size() != 0)
			return list.get(0);
		return null;
	}
}
