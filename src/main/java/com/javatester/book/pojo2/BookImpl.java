package com.javatester.book.pojo2;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.javatester.book.pojo1.Person;

@Component
public class BookImpl implements Book {

	private String title;
	private long isbn;
	private Person author;
	private Genre genre;
	private int pages;
	private LocalDate publishedDate;

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public long getISBN() {
		return isbn;
	}

	@Override
	public void setISBN(long isbn) {
		this.isbn = isbn;
	}

	@Override
	public Person getAuthor() {
		return this.author;
	}

	@Override
	public void setAuthor(Person author) {
		this.author = author;
	}

	@Override
	public Genre getGenre() {
		return this.genre;
	}

	@Override
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public int getPages() {
		return this.pages;
	}

	@Override
	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public LocalDate getPublishedDate() {
		return this.publishedDate;
	}

	@Override
	public void setPublishedDate(LocalDate published) {
		this.publishedDate = published;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Book book = (Book) obj;
		if (this.title == null ? book.getTitle() != null : !this.title.equals(book.getTitle())) {
			return false;
		}
		if (this.isbn != book.getISBN()) {
			return false;
		}
		if (this.author == null ? book.getAuthor() != null : !this.author.equals(book.getAuthor())) {
			return false;
		}
		if (this.genre == null ? book.getGenre() != null : !this.genre.equals(book.getGenre())) {
			return false;
		}
		if (this.pages != book.getPages()) {
			return false;
		}
		if (this.publishedDate == null ? book.getPublishedDate() != null
				: !this.publishedDate.equals(book.getPublishedDate())) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return title.hashCode() + Long.valueOf(isbn).hashCode() + author.hashCode() + genre.hashCode() + pages
				+ publishedDate.hashCode();
	}

}
