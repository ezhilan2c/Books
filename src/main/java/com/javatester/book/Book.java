package com.javatester.book;

import java.time.LocalDate;

import com.javatester.book.person.Person;

public interface Book {
	
	public static enum Genre { InformationScience, Philosophy, Psychology,
		                       Religion, SocialScience, Language, Science,
		                       Technology, Arts, Literature, History };
		                       
   	public static enum Size {	Small,    // under 100 pages
   								Medium,   // under 300 pages
   								Large }   // 300 or more pages
	
	public String getTitle();
	public void setTitle(String title);
	
	public long getISBN();
	public void setISBN(long isbn);
	
	public Person getAuthor();
	public void setAuthor(Person author);
	
	public Genre getGenre();
	public void setGenre(Genre genre);
	
	public int getPages();
	public void setPages(int pages);
	
	public LocalDate getPublishedDate();
	public void setPublishedDate(LocalDate published);
}