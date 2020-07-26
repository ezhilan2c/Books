package com.javatester.book.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.javatester.book.pojo1.Person;
import com.javatester.book.pojo2.Book;
import com.javatester.book.pojo2.PersonTest;
import com.javatester.book.test.AbstractTest;

/* DO NOT MODIFY THIS CLASS! */
public class BookServiceTest extends AbstractTest {
	
	@Test @Order(1) void testNoArgConstructor() {
		newBookService();
	}

	@Test @Order(2) void testGetAllSize() {
		BookService bookService = newBookService();
		List<Book> list = bookService.get();
		assertTrue(list.size() > 990);
	}
	
	@Test @Order(3) void testGetAllTitleNotNull() {
		BookService bookService = newBookService();
		List<Book> list = bookService.get();
		for( Book book : list ) {
			assertNotNull(book.getTitle());
		}
	}
	
	@Test @Order(4) void testGetAllISBNNotNull() {
		BookService bookService = newBookService();
		List<Book> list = bookService.get();
		for( Book book : list ) {
			assertNotEquals(book.getISBN(), 0L);
		}
	}
	
	@Test @Order(5) void testGetAllAuthorNotNull() {
		BookService bookService = newBookService();
		List<Book> list = bookService.get();
		for( Book book : list ) {
			assertNotNull(book.getAuthor());
		}
	}
	
	@Test @Order(6) void testGetAllPublishedDateNotNull() {
		BookService bookService = newBookService();
		List<Book> list = bookService.get();
		for( Book book : list ) {
			assertNotNull(book.getPublishedDate());
		}
	}
	
	@Test @Order(7) void testGetAllPagesNotNull() {
		BookService bookService = newBookService();
		List<Book> list = bookService.get();
		for( Book book : list ) {
			assertNotEquals(book.getPages(), 0L);
		}
	}
	
	@Test @Order(8) void testGetAllGenreNotNull() {
		BookService bookService = newBookService();
		List<Book> list = bookService.get();
		for( Book book : list ) {
			assertNotNull(book.getGenre());
		}
	}
	
	@Test @Order(9) void testGetByISBN() {
		BookService bookService = newBookService();
		long isbn = 9998575322677L;
		Book book = bookService.get(isbn);
		Person author = PersonTest.newPerson(
				"Graham", "Donovan", LocalDate.parse("1976-06-03"));
		assertEquals(book.getISBN(), isbn);
		assertEquals(book.getTitle(), "The Revenue of the Team");
		assertEquals(book.getPages(), 281);
		assertEquals(book.getPublishedDate(), LocalDate.parse("2017-01-08"));
		assertEquals(book.getAuthor(), author);
		assertEquals(book.getGenre(), Book.Genre.Science);
	}
	
	@Test @Order(10) void testInvalidGetByISBN() {
		BookService bookService = newBookService();
		long isbn = 8888575321145L;
		Book book = bookService.get(isbn);
		assertNull( book );
	}
	
	@Test @Order(11) void testDelete() {
		BookService bookService = newBookService();
		long isbn = 9998575321089L;
		int count = bookService.delete(isbn);
		assertNull(bookService.get(isbn));
		assertEquals(count, 1);
		count = bookService.delete(isbn);
		assertNull(bookService.get(isbn));
		assertEquals(count, 0);
	}
	
	@Test @Order(12) void testDeleteNoMatch() {
		BookService bookService = newBookService();
		int count = bookService.delete(8888575321089L);
		assertEquals(count, 0);
	}
}