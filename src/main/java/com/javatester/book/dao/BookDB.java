package com.javatester.book.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.derby.jdbc.EmbeddedDriver;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 * Represents an embedded in-memory relational database of books. To initialize
 * the database and get an instance of this class, call:
 * 
 * 					BookDB.getInstance();
 * 
 * The following information will be useful to connect to the database:
 * 
 * 	1. General JDBC connection data:
 *
 *			URL:		"jdbc:derby:memory:BookDB;create=true"
 *			Username:	"user1"
 *			Password:	"user1"
 *
 *  2. To get a javax.sql.DataSource, call BookDB.getDataSource();
 *
 *	3. To get a javax.sql.Connection, call BookDB.getConnection();
 */
public class BookDB {
	
	private static final BookDB DB = new BookDB("BookDB");
	
	private String name;
	
	/** Do not instantiate directly - use getInstance(). */
	private BookDB(String name) {
		super();
		this.name = name;
		this.initFromFile(name + ".txt");	}

	/** Returns a singleton instance of this Database. */
	public static final BookDB getInstance() { return DB; }
	
	/** Returns a connection to this database. */
	public Connection getConnection() {
		Connection c = null;
		try {
			Properties p = new Properties();
			p.put( "user", "user1" ); p.put( "password", "user1" );
			c = DriverManager.getConnection( "jdbc:derby:memory:" +
											 this.name + ";create=true", p );
		}
		catch(Throwable t) {
			t.printStackTrace(System.err);
		}
		return c;
	}
	
	/** Returns a DataSource. */
	public DataSource getDataSource() {
		return new SimpleDriverDataSource(
					new EmbeddedDriver(),
					"jdbc:derby:memory:" + this.name + ";create=true",
					"user1", "user1"
				);
	}
	
	private void initFromFile( String filename ) {
		if ( filename != null ) {
			try ( BufferedReader r = new BufferedReader(
					new FileReader(getFileFromResources(filename))) ) {
				String l;
				while( (l = r.readLine() ) != null ) {
					if ( l.trim().length() > 0 ) {
						Connection c = this.getConnection();
						try ( Statement s = c.createStatement() ) {
							s.execute(l);
						}
					}
				}
			}
			catch(Throwable t) {
				t.printStackTrace(System.err);
			}
		}
	}
	
	private File getFileFromResources( String filename ) {
        URL resource = getClass().getClassLoader().getResource(filename);
        if (resource == null) {
            throw new IllegalArgumentException("File not found: " + filename);
        }
        else {
            return new File(resource.getFile());
        }
    }
}