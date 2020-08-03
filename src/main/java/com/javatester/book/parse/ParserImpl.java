package com.javatester.book.parse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.javatester.book.pojo1.Person;
import com.javatester.book.pojo2.Book;
import com.javatester.book.pojo2.Book.Genre;
import com.javatester.book.pojo2.Book.Size;

public class ParserImpl implements Parser {

	@Override
	public Map<Genre, List<Book>> booksByGenre(List<Book> data, Person author) {
		if (author == null) {
			return data.stream().collect(Collectors.groupingBy(Book::getGenre));
		}

		return data.stream().filter(book -> book.getAuthor().equals(author))
				.collect(Collectors.groupingBy(Book::getGenre));
	}

	@Override
	public Map<Size, Long> countOfBooksBySize(List<Book> books) {
		Map<Size, Long> map = new HashMap<Size, Long>();

		books.forEach(book -> {
			if (book.getPages() < 100) {
				populateBookSize(map, Size.Small);
			} else if (book.getPages() < 300) {
				populateBookSize(map, Size.Medium);
			} else {
				populateBookSize(map, Size.Large);
			}
		});
		return map;
	}

	private void populateBookSize(Map<Size, Long> map, Size size) {
		if (map.get(size) != null) {
			map.put(size, map.get(size) + 1);
		} else {
			map.put(size, 1L);
		}
	}

	@Override
	public List<Book> dateError(List<Book> books) {
		return books.stream().filter(book -> book.getPublishedDate().isBefore(book.getAuthor().getBirthDate()))
				.collect(Collectors.toList());
	}

}
