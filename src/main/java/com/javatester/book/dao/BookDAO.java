package com.javatester.book.dao;

import java.util.List;

import com.javatester.book.Book;

public interface BookDAO {
	
	/** Return all books. */
	public List<Book> get();
	
	/** Return the book with the given isbn (or null if none). */
	Book get(long isbn);
	
	/** Delete the book with the given isbn - return number of rows deleted. */
	public int delete(long isbn);
}