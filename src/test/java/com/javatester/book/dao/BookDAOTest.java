package com.javatester.book.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.javatester.book.Book;
import com.javatester.book.person.Person;
import com.javatester.book.person.PersonTest;
import com.javatester.book.test.AbstractTest;

/* DO NOT MODIFY THIS CLASS! */
public class BookDAOTest extends AbstractTest {
	
	@Test @Order(1) void testNoArgConstructor() {
		newBookDAO();
	}

	@Test @Order(2) void testGetAllSize() {
		BookDAO bookDAO = newBookDAO();
		List<Book> list = bookDAO.get();
		assertTrue(list.size() > 80);
	}
	
	@Test @Order(3) void testGetAllTitleNotNull() {
		BookDAO bookDAO = newBookDAO();
		List<Book> list = bookDAO.get();
		for( Book book : list ) {
			assertNotNull(book.getTitle());
		}
	}
	
	@Test @Order(4) void testGetAllISBNNotNull() {
		BookDAO bookDAO = newBookDAO();
		List<Book> list = bookDAO.get();
		for( Book book : list ) {
			assertNotEquals(book.getISBN(), 0L);
		}
	}
	
	@Test @Order(5) void testGetAllAuthorNotNull() {
		BookDAO bookDAO = newBookDAO();
		List<Book> list = bookDAO.get();
		for( Book book : list ) {
			assertNotNull(book.getAuthor());
		}
	}
	
	@Test @Order(6) void testGetAllPublishedDateNotNull() {
		BookDAO bookDAO = newBookDAO();
		List<Book> list = bookDAO.get();
		for( Book book : list ) {
			assertNotNull(book.getPublishedDate());
		}
	}
	
	@Test @Order(7) void testGetAllPagesNotNull() {
		BookDAO bookDAO = newBookDAO();
		List<Book> list = bookDAO.get();
		for( Book book : list ) {
			assertNotEquals(book.getPages(), 0L);
		}
	}
	
	@Test @Order(8) void testGetAllGenreNotNull() {
		BookDAO bookDAO = newBookDAO();
		List<Book> list = bookDAO.get();
		for( Book book : list ) {
			assertNotNull(book.getGenre());
		}
	}
	
	@Test @Order(9) void testGetByISBN() {
		BookDAO bookDAO = newBookDAO();
		long isbn = 9998575321145L;
		Book book = bookDAO.get(isbn);
		Person author = PersonTest.newPerson(
				"Jordan", "Hall", LocalDate.parse("1972-06-16"));
		assertEquals(book.getISBN(), isbn);
		assertEquals(book.getTitle(), "The Music of Tchaikovsky");
		assertEquals(book.getPages(), 351);
		assertEquals(book.getPublishedDate(), LocalDate.parse("1990-07-22"));
		assertEquals(book.getAuthor(), author);
		assertEquals(book.getGenre(), Book.Genre.Arts);
	}
	
	@Test @Order(10) void testInvalidGetByISBN() {
		BookDAO bookDAO = newBookDAO();
		long isbn = 8888575321145L;
		Book book = bookDAO.get(isbn);
		assertNull( book );
	}
	
	@Test @Order(11) void testDelete() {
		BookDAO bookDAO = newBookDAO();
		long isbn = 9998575321089L;
		int count = bookDAO.delete(isbn);
		assertNull(bookDAO.get(isbn));
		assertEquals(count, 1);
		count = bookDAO.delete(isbn);
		assertNull(bookDAO.get(isbn));
		assertEquals(count, 0);
	}
	
	@Test @Order(12) void testDeleteNoMatch() {
		BookDAO bookDAO = newBookDAO();
		int count = bookDAO.delete(8888575321089L);
		assertEquals(count, 0);
	}
}