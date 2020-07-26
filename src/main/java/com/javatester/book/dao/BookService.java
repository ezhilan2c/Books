package com.javatester.book.dao;

import java.util.List;

import com.javatester.book.pojo2.Book;

public interface BookService {
	
	/** Return all books. */
	public List<Book> get();
	
	/** Return book with the given ISBN (or null if none). */
	Book get(long isbn);
	
	/** Delete book with the given ISBN - return number of rows deleted. */
	public int delete(long isbn);
}