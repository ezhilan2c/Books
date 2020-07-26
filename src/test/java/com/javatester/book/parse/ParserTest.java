package com.javatester.book.parse;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.javatester.book.pojo1.Person;
import com.javatester.book.pojo2.Book;
import com.javatester.book.test.AbstractTest;

/* DO NOT MODIFY THIS CLASS! */
public class ParserTest extends AbstractTest {
	
	@Test void testNoArgConstructor() {
		newParser();
	}
	
	@Test void testBooksByGenreWithoutAuthor() {
		Parser parser = newParser();
		List<Book> list = randomBookList(1000);
		Map<Book.Genre,List<Book>> map = parser.booksByGenre(list, null);
		for ( Map.Entry<Book.Genre, List<Book>> entry : map.entrySet() ) {
			for ( Book book : entry.getValue() ) {
				assertEquals( entry.getKey(), book.getGenre() );
			}
		}
	}
	
	@Test void testBooksByGenreWithAuthor() {
		Parser parser = newParser();
		Person author = randomPerson();
		List<Book> b1 = randomBookList(1000);
		List<Book> b2 = randomBookList(100);
		b1.forEach(b -> b.setAuthor(author));
		b1.addAll(b2);
		Map<Book.Genre,List<Book>> map = parser.booksByGenre(b1, author);
		for ( Map.Entry<Book.Genre, List<Book>> entry : map.entrySet() ) {
			for ( Book book : entry.getValue() ) {
				assertEquals( entry.getKey(), book.getGenre() );
				assertEquals( book.getAuthor(), author );
			}
		}
	}
	
	@Test void testCountOfBooksBySize() {
		Parser parser = newParser();
		List<Book> list = randomBookList(1000);
		long[] sizes = countSizes(list);
		Map<Book.Size,Long> map = parser.countOfBooksBySize(list);
		assertEquals(Optional.ofNullable(map.get(Book.Size.Small)).orElse(0L), sizes[0]);
		assertEquals(Optional.ofNullable(map.get(Book.Size.Medium)).orElse(0L), sizes[1]);
		assertEquals(Optional.ofNullable(map.get(Book.Size.Large)).orElse(0L), sizes[2]);
	}
	
	@Test void dateErrorTest() {
		Parser parser = newParser();
		List<Book> list = randomBookList(1000);
		List<Book> errorList = parser.dateError(list);
		int i = 0;
		for ( Book book : list ) {
			if ( book.getPublishedDate().isBefore(book.getAuthor().getBirthDate()) ) {
				i++;
				assertTrue(errorList.contains(book));
			}
		}
		assertEquals(i, errorList.size());
	}
	
	private static final long[] countSizes(List<Book> books) {
		long s = 0, m = 0, l = 0;
		for ( Book b : books ) {
			if (b.getPages() < 100 ) s++;
			else if (b.getPages() < 300 ) m++;
			else l++;
		}
		return new long[] {s, m, l};
	}
}