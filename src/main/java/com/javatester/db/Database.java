package com.javatester.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/** Represents an embedded in-memory relational database. */
public abstract class Database {
	
	private String name;
	
	/** Creates a new database instance. */
	public Database( String name ) {
		super();
		this.initFromFile(this.getClass().getSimpleName() + ".txt");
	}
	
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