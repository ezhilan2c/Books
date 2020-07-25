package com.javatester.book;

import java.time.LocalDate;

import com.javatester.book.person.Person;

public class BookImpl implements Book {
	
	private String title;
	private long isbn;
	private Person author;
	private int pages;
	private LocalDate publishedDate;
	private Genre genre;

	@Override public String getTitle() { return this.title; }
	@Override public void setTitle(String title) { this.title = title; }

	@Override public long getISBN() { return this.isbn; }
	@Override public void setISBN(long isbn) { this.isbn = isbn; }

	@Override public Person getAuthor() { return this.author; }
	@Override public void setAuthor(Person author) { this.author = author; }

	@Override public Genre getGenre() { return this.genre; }
	@Override public void setGenre(Genre genre) { this.genre = genre; }

	@Override public int getPages() { return this.pages; }
	@Override public void setPages(int pages) { this.pages = pages; }

	@Override public LocalDate getPublishedDate() { return this.publishedDate; }
	@Override public void setPublishedDate(LocalDate publishedDate) { this.publishedDate = publishedDate; }
	
	@Override public String toString() {
		return "\"" + this.title + "\" by " + this.author;
	}

	@Override public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null) return false;
		if (getClass() != object.getClass()) return false;
		Book that = (Book)object;
		if (this.isbn != that.getISBN()) return false;
		return true;
	}
	
	
}