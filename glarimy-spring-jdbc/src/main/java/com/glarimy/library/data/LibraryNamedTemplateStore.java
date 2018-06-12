package com.glarimy.library.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.glarimy.library.api.Book;

@SuppressWarnings("deprecation")
public class LibraryNamedTemplateStore  implements Store {
	private SimpleJdbcTemplate template;

	public SimpleJdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(SimpleJdbcTemplate template) {
		this.template = template;
	}

	@Override
	public void create(Book book) {
		Map<String, Object> params = new HashMap<>();
		params.put("isbn", book.getIsbn());
		params.put("title", book.getTitle());
		template.update("INSERT INTO library VALUES(:isbn, :title)", params);
	}

	@Override
	public Book read(int isbn) {
		Map<String, Object> params = new HashMap<>();
		params.put("isbn", isbn);

		List<Book> list = template.query("SELECT * FROM library where isbn=:isbn", new RowMapper<Book>() {
			public Book mapRow(ResultSet rs, int rowNo) throws SQLException {
				Book book = new Book();
				book.setIsbn(rs.getInt("isbn"));
				book.setTitle(rs.getString("title"));
				return book;
			}
		}, params);
		if (list.size() != 0)
			return list.get(0);
		return null;
	}
}
