package com.javatester.book.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javatester.book.Book;
import com.javatester.book.dao.BookDAO;
import com.javatester.book.dao.BookDAOImpl;

@RestController
public class BookControllerImpl implements BookController{
	
	private BookDAO bookDAO = new BookDAOImpl();
	
	@GetMapping("/books")
	public List<Book> get() {
		return this.bookDAO.get();
	}
	
	@GetMapping("/books/{isbn}")
	public ResponseEntity<Book> get(@PathVariable Long isbn) {
		return Optional.ofNullable(
				this.bookDAO.get(isbn)
			).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/books/{isbn}")
	public ResponseEntity<?> delete(@PathVariable Long isbn) {
		return this.bookDAO.delete(isbn) == 0 ? ResponseEntity.notFound().build() :
		                                     	ResponseEntity.ok().build();
	}
}