package com.javatester.book.parse;

import java.util.List;
import java.util.Map;

import com.javatester.book.pojo1.Person;
import com.javatester.book.pojo2.Book;

public interface Parser {

	/**
	 * Group books by genre for the given author, or for all authors if the
	 * author is null. For example, given these books:
	 * 
	 * 		"Book A"  by Author1  (Literature)
	 *      "Book B"  by Author1  (Literature)
	 *      "Book C"  by Author1  (Science)
	 *      "Book D"  by Author1  (Arts)
	 *
	 *		"Book E"  by Author2  (Science)
	 *      "Book F"  by Author2  (Literature)
	 *      "Book G"  by Author3  (Science)
	 *      "Book H"  by Author3  (Arts)
	 * 		
	 * 		"Book I"  by Author3  (Arts)
	 *      "Book J"  by Author3  (Science)
	 *      "Book K"  by Author3  (Science)
	 *      "Book L"  by Author3  (Arts)
	 *      
	 * If this method were called with author = null it would return:
	 * 
	 * 		Literature = [Book A, Book B, Book F]
	 *      Science    = [Book C, Book E, Book G, Book J, Book K]
	 *      Arts       = [Book D, Book H, Book I, Book L]
	 *      
	 * 	If this method were called with author = Author1 it would return:
	 *  
	 * 		Literature = [Book A, Book B]
	 *      Science    = [Book C]
	 *      Arts       = [Book D]
	 *      
	 * If this method were called with author = Author3 it would return:
	 *  
	 *      Science    = [Book J, Book K]
	 *      Arts       = [Book I, Book L]
	 */
	public Map<Book.Genre,List<Book>> booksByGenre(List<Book> data, Person author);
	
	/**
	 * Group books by Book.Size with the total number of books of that size.
	 * For example, given these books:
	 * 
	 * 		"Book A"  with 36 pages
	 *      "Book B"  with 63 pages
	 *      "Book C"  with 99 pages
	 *      "Book D"  with 100 pages
	 *		"Book E"  with 220 pages
	 *      "Book F"  with 178 pages
	 *      "Book G"  with 299 pages
	 *      "Book H"  with 300 pages
	 * 		"Book I"  with 369 pages
	 *      "Book J"  with 431 pages
	 *      "Book K"  with 576 pages
	 *      "Book L"  with 800 pages
	 *  
	 * Then this method would return:
	 * 
	 * 		Small  = 3
	 * 		Medium = 4
	 * 		Large  = 5
	 */
	public Map<Book.Size,Long> countOfBooksBySize(List<Book> data);
	
	/**
	 * Find all books with a publicationDate before the author was born. For
	 * example, given these books:
	 * 
	 * 		"Book A"  published in 1962, written by Author1 born in 1999
	 *      "Book B"  published in 2010, written by Author2 born in 1979
	 *      "Book C"  published in 1979, written by Author3 born in 1965
	 *      "Book D"  published in 2019, written by Author4 born in 1961
	 *      "Book E"  published in 1971, written by Author5 born in 1978
	 *      
	 * Then this method would return: Book A and Book E.
	 */
	public List<Book> dateError(List<Book> data);
}