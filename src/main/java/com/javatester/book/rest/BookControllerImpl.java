package com.javatester.book.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatester.book.dao.BookService;
import com.javatester.book.pojo2.Book;

@RestController
@RequestMapping("/books")
public class BookControllerImpl implements BookController {

	@Autowired
	private BookService bookService;

	/**
	 * Return all books. 
	 */
	@GetMapping
	@Override
	public List<Book> get() {
		return bookService.get();
	}

	/**
	 * Return the book for the given ISBN.
	 */
	@GetMapping("{isbn}")
	@Override
	public ResponseEntity<Book> get(@PathVariable Long isbn) {
		return new ResponseEntity<>(bookService.get(isbn), HttpStatus.OK);
	}

	/**
	 * Delete the book for the given ISBN.
	 */
	@DeleteMapping("{isbn}")
	@Override
	public ResponseEntity<?> delete(@PathVariable Long isbn) {
		int result = bookService.delete(isbn);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
