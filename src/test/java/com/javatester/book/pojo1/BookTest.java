package com.javatester.book.pojo1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import com.javatester.book.pojo2.Book;
import com.javatester.book.test.AbstractTest;

/* DO NOT MODIFY THIS CLASS! */
public class BookTest extends AbstractTest {
	
	@Test void testNoArgConstructor() {
		newBook();
	}
	
	@Test void testTitle() {
		Book book = newBook();
		String title = randomTitle();
		assertEquals(book.getTitle(), null);
		book.setTitle(title);
		assertEquals(book.getTitle(), title);
	}
	
	@Test void testISBN() {
		Book book = newBook();
		assertEquals(book.getISBN(), 0L);
		book.setISBN(1234567890123L);
		assertEquals(book.getISBN(), 1234567890123L);
	}
	
	@Test void testAuthor() {
		Book book = newBook();
		Person author = randomPerson();
		assertEquals(book.getAuthor(), null);
		book.setAuthor(author);
		assertEquals(book.getAuthor(), author);
	}
	
	@Test void testGenre() {
		Book book = newBook();
		Book.Genre genre = randomGenre();
		assertEquals(book.getGenre(), null);
		book.setGenre(genre);
		assertEquals(book.getGenre(), genre);
	}
	
	@Test void testPages() {
		Book book = newBook();
		int pages = randomInt(100, 900);
		assertEquals(book.getPages(), 0);
		book.setPages(pages);
		assertEquals(book.getPages(), pages);
	}
	
	@Test void testPublishedDate() {
		Book book = newBook();
		LocalDate date = randomDate(1950, 2010);
		assertEquals(book.getPublishedDate(), null);
		book.setPublishedDate(date);
		assertEquals(book.getPublishedDate(), date);
	}
	
	@Test void validEqualsTest() {
		Person author = randomPerson();
		String title = randomTitle();
		long isbn = randomLong(1000000000000L, 9999999999999L);
		int pages = randomInt(100, 999);
		Book.Genre genre = randomGenre();
		LocalDate publishedDate = randomDate(1950, 2010);
		Book b1 = newBook(title, isbn, author, pages, genre,publishedDate);
		Book b2 = newBook(title, isbn, author, pages, genre,publishedDate);
		assertEquals(b1, b2);
	}
	
	@Test void invalidEqualsTest() {
		Person author = randomPerson();
		String title = randomTitle();
		long isbn = randomLong(1000000000000L, 9999999999999L);
		int pages = randomInt(100, 999);
		Book.Genre genre = randomGenre();
		LocalDate publishedDate = randomDate(1950, 2010);
		Book b1 = newBook(title, isbn, author, pages, genre,publishedDate);
		Book b2 = newBook(title, 100L, author, pages, genre,publishedDate);
		assertNotEquals(b1, b2);
	}
	
	@Test void nullEqualsTest() {
		assertNotEquals(randomBook(), null);
	}
	
	@Test void objectEqualsTest() {
		assertNotEquals(randomBook(), new Object());
	}
}