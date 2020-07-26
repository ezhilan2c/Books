package com.javatester.book.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.javatester.book.pojo2.Book;

public interface BookController {

	/**
	 * Return all books (Status: 200).
	 * 
	 * Map to the GET HTTP method and the URL /books
	 */
	public List<Book> get();

	/**
	 * Return the book for the given ISBN (Status: 200 if found, 404 if not).
	 * 
	 * Map to the GET method and the URL /books/{isbn}
	 */
	public ResponseEntity<Book> get(Long isbn);
	
	/** 
	 * Delete the book for the given ISBN (Status: 200 if deleted, 404 if not).
	 * 
	 * Map to the DELETE method and the URL /books/{isbn}
	 */
	public ResponseEntity<?> delete(Long isbn);
}