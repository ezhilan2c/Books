package com.javatester.book.parse;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.javatester.book.Book;
import com.javatester.book.Book.Size;
import com.javatester.book.person.Person;

public class ParserImpl implements Parser {

	@Override public Map<Book.Genre,List<Book>> booksByGenre(List<Book> data, Person author) {
		return data.stream()
				   .filter(b -> author == null ? true : b.getAuthor().equals(author))
				   .collect(Collectors.groupingBy(Book::getGenre));
	}

	@Override public Map<Size,Long> countOfBooksBySize(List<Book> data) {
		return data.stream()
				   .collect(Collectors.groupingBy(b -> size(b.getPages()), Collectors.counting()));
	}

	@Override public List<Book> dateError(List<Book> data) {
		return data.stream()
				   .filter(b -> b.getPublishedDate().isBefore(
						   b.getAuthor().getBirthDate()))
				   .collect(Collectors.toList());
	}
	
	private static final Book.Size size(int s) {
		if ( s < 100 ) {
			return Book.Size.Small;
		}
		else if ( s < 300 ) {
			return Book.Size.Medium;
		}
		return Book.Size.Large;
	}
}