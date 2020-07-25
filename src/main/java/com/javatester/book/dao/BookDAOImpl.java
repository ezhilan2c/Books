package com.javatester.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.javatester.book.Book;
import com.javatester.book.BookImpl;
import com.javatester.book.person.Person;
import com.javatester.book.person.PersonImpl;
import com.javatester.db.Database;

public class BookDAOImpl implements BookDAO {
	
	static final Database bookDB = BookDB.getInstance();

	@Override public List<Book> get() {
		List<Book> l = new ArrayList<Book>();
		try (
				Connection c = bookDB.getConnection();
				Statement s = c.createStatement();
				ResultSet r = s.executeQuery(
						"select b.title, b.isbn, b.pages, b.published, "
						+ "p.firstName, p.lastname, p.born, g.name from book b "
						+ "left join person p on b.author = p.id "
						+ "left join genre g on b.genre = g.id");
		    ) {
			while( r.next() ) {
			    String    title        =  r.getString("title");
			    long      isbn         =  r.getLong("isbn");
			    int       pages        =  r.getInt("pages");
			    LocalDate published    =  r.getDate("published").toLocalDate();
			    String    authorFirst  =  r.getString("firstName");
			    String    authorLast   =  r.getString("lastName");
			    LocalDate authorBorn   =  r.getDate("born").toLocalDate();
			    String    genre        =  r.getString("name");
			    l.add( newBook( title, isbn, pages, published, authorFirst,
			    		        authorLast, authorBorn, genre ) );
			}
		}
		catch(Throwable t) {
			t.printStackTrace(System.err);
		}
		return l;
	}
	
	@Override public Book get(long isbn) {
		Book book = null;
		try (
				Connection c = bookDB.getConnection();
				PreparedStatement s = c.prepareStatement(
						"select b.title, b.isbn, b.pages, b.published, "
						+ "p.firstName, p.lastname, p.born, g.name from book b "
						+ "left join person p on b.author = p.id left join "
						+ "genre g on b.genre = g.id where b.isbn = ?" );
		    ) {
			
			s.setLong( 1, isbn );
			
			try ( ResultSet r = s.executeQuery() ) {
			
				if ( r.next() ) {
				    String    title        =  r.getString("title");
				    long      isbnID       =  r.getLong("isbn");
				    int       pages        =  r.getInt("pages");
				    LocalDate published    =  r.getDate("published").toLocalDate();
				    String    authorFirst  =  r.getString("firstName");
				    String    authorLast   =  r.getString("lastName");
				    LocalDate authorBorn   =  r.getDate("born").toLocalDate();
				    String    genreName    =  r.getString("name");
				    book = newBook( title, isbnID, pages, published, authorFirst,
				    		        authorLast, authorBorn, genreName );
				}
			}
		}
		catch(Throwable t) {
			t.printStackTrace(System.err);
		}
		return book;
	}
	
	@Override public int delete(long isbn) {
		int count = 0;
		try (
				Connection c = bookDB.getConnection();
				PreparedStatement s = c.prepareStatement(
						"delete from book where isbn = ?");
		    ) {
				s.setLong( 1, isbn );
				count = s.executeUpdate();
		}
		catch(Throwable t) {
			t.printStackTrace(System.err);
		}
		return count;
	}
	
	static final Book newBook( String title, long isbn, int pages,
			                   LocalDate published, String authorFirst,
			                   String authorLast, LocalDate authorBorn,
			                   String genre) {
		Book book = new BookImpl();
		Person author = new PersonImpl();
		author.setFirstName(authorFirst);
		author.setLastName(authorLast);
		author.setBirthDate(authorBorn);
		book.setTitle(title);
		book.setISBN(isbn);
		book.setPages(pages);
		book.setPublishedDate(published);
		book.setAuthor(author);
		book.setGenre(Book.Genre.valueOf(genre));
		return book;
	}
}