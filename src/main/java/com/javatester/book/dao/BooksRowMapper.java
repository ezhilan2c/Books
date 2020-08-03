package com.javatester.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatester.book.pojo1.Person;
import com.javatester.book.pojo1.PersonImpl;
import com.javatester.book.pojo2.Book;
import com.javatester.book.pojo2.Book.Genre;
import com.javatester.book.pojo2.BookImpl;

public class BooksRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Book book = new BookImpl();
		book.setTitle(rs.getString(1));
		book.setISBN(rs.getLong(2));
		book.setPages(rs.getInt(3));
		book.setPublishedDate(rs.getDate(4).toLocalDate());
		Person author = new PersonImpl();
		author.setFirstName(rs.getString(6));
		author.setLastName(rs.getString(7));
		author.setBirthDate(rs.getDate(8).toLocalDate());
		book.setAuthor(author);
		book.setGenre(Genre.valueOf(rs.getString(10)));
		return book;
	}

}
