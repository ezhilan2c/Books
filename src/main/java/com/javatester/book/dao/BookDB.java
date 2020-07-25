package com.javatester.book.dao;

import com.javatester.db.Database;

/**
 * Represents an embedded in-memory database. To create and connect to this
 * database, just call:
 * 
 * 					BookDB.getInstance().getConnection();
 * 
 * There are three tables in this database:
 *                                                +------------------------+
 *                                                | PERSON                 |
 *  +-------------------------+                   +------------------------+
 *  | BOOK                    |                   | firstName  varchar(25) |
 *  +-------------------------+                   | lastName   varchar(25) |
 *  |                         |                   | born       date        |
 *  | author    int    (FK) +-------------------> | id         int    (PK) |
 *  | title     varchar(50)   |                   +------------------------+
 *  | isbn      bigint (PK)   |                
 *  | born      date          |          +-------------------+
 *  | pages     int           |          | GENRE             |
 *  | published date          |          +-------------------+
 *  | genre     int    (FK) +----------> | id    int    (PK) |
 *  |                         |          | name  varchar(25) |
 *  +-------------------------+          +-------------------+
 *  
 */
public class BookDB extends Database {
	
	private static final BookDB DB = new BookDB("BookDB");
	
	/** Do not instantiate directly - use getInstant(). */
	private BookDB(String name) {
		super("BooksDB");
	}

	/** Returns a singleton instance of this Database. */
	public static final BookDB getInstance() { return DB; }
}