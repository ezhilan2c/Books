package com.javatester.book.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.javatester.book.pojo2.Book;

@Service
public class BookServiceImpl implements BookService {

	private JdbcTemplate jdbcTemplate;

	private final String GET_BOOK = "SELECT b.title, b.isbn, b.pages, b.published, p.id, p.firstName, p.lastName, p.born,"
			+ " g.id, g.name FROM book b, genre g, person p where b.author=p.id and b.genre=g.id";

	private final String GET_BOOK_BY_ISBN = GET_BOOK + " AND b.isbn=?";

	private final String DELETE_BOOK_BY_ISBN = "DELETE FROM book b where b.isbn=?";

	/**
	 * Return all books.
	 */
	@Override
	public List<Book> get() {
		return getJDBCTemplate().query(GET_BOOK, new BooksRowMapper());
	}

	/**
	 * Return book with the given ISBN
	 */
	@Override
	public Book get(long isbn) {
		try {
			return getJDBCTemplate().queryForObject(GET_BOOK_BY_ISBN, new Object[] { isbn }, new BooksRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	/**
	 * Delete book with the given ISBN
	 */
	@Override
	public int delete(long isbn) {
		return getJDBCTemplate().update(DELETE_BOOK_BY_ISBN, new Object[] { isbn });
	}

	/**
	 * Returns single instance of JDBC Template.
	 * 
	 * @return
	 */
	private JdbcTemplate getJDBCTemplate() {

		if (this.jdbcTemplate == null) {
			this.jdbcTemplate = new JdbcTemplate(BookDB.getInstance().getDataSource());
		}

		return this.jdbcTemplate;
	}
}
