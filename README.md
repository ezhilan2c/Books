# The BOOKS Coding Test

## Description
This *coding test* is designed to test your ability in the following areas:

	- Basic ability to use a Java IDE, Git, and Gradle
	- Programming ability in Java and ability to run and debug JUnit
	- Interface implementation, class creation, and use of enums
	- Java 8 functional programming, lambdas, and streams
	- SQL and basic JDBC programming
	- Spring RESTful web services
	- Ability to read, understand, and follow instructions
	
## General Instructions

	1. Carefully read and understand these instructions and the instructions for
	   the individual exercises below before starting to code.
	2. Each exercise builds upon the previous exercises so complete them in order.
	3. You will need a Java IDE (Eclipse, NetBeans, IntelliJ) and Java 8+.
	4. For each exercise, you will be given an interface to implement and a JUnit
	   test. All of your implementation classes must be named after the interface
	   + Impl. For example, in the first exercise you must implement the Book
	   interface, so your implementation should be called BookImpl.
	5. The provided JUnit tests will test your implementations, so to start off
	   all these JUnits will fail. You MUST NOT edit any of the JUnit classes.
	6. You also MUST NOT modify any of the interfaces that you will be
	   implementing. The only code you should be writing is in the ---Impl classes.

## How to Submit the Code

	1. In your IDE, clone this repo from GitHub.
	2. Create a branch (name it "develop-" + your last name).
	3. Complete the exercise as completely as you can.
	3. Commit your solution to GitHub.
	4. Create a pull request in GitHub when you are ready to submit.



## Exercise 1: Implementing `Person`
### Package: `com.javatester.book`

For this exercise you must implement a simple interface called `Person`, which
only has three fields. In addition you must ensure there is a no argument
constructor and also override the `equals()` method from the `Object` class.

### Exercise 1: Detailed Instructions

	1. Create a class named PersonImpl that implements the Person interface.
	2. Make sure there is a no-arg constructor for PersonImpl.
	3. Override the equals method to test for equality. Two Person instances
	   are only equal if they have exactly the same name (first and last) and
	   birth date.



## Exercise 2: Implementing `Book`
### Package: `com.javatester.book`

For this exercise you must implement the `Book` interface. In addition you must
ensure that there is a no argument constructor and also override the `equals()`
method from the `Object` class.

### Exercise 2: Detailed Instructions

	1. Create a class named BookImpl that implements the Book interface.
	2. Make sure there is a no-arg constructor for BookImpl.
	3. Override the equals() method to test for equality. Two Book instances
	   are only equal if they have exactly the same name ISBN.



## Exercise 3: Implementing `Parser`
### Package: `com.javatester.book.parse`

For this exercise you must implement the `Parser` interface, which provides
three methods for manipulating a list of `Books`. A detailed description, with
examples, are given in the comments for each of these methods defined in the
`Parser` interface.

### Exercise 3: Detailed Instructions

	1. Create a class named ParserImpl that implements the Parser interface.
	2. Make sure there is a no-arg constructor for ParserImpl.
	3. Detailed instructions are provided in the comments for all three method
	   defined in the Parser interface. Use these instructions to correctly
	   implement the parsing methods.



## Exercise 4: Implementing `BookDAO`
### Package: `com.javatester.book.dao`

For this exercise you must implement the `BookDAO` interface, which provides
methods for getting and deleting books from a relational database. A detailed
description of the structure of the tables in this relational database is given
in the `BookDB` class, which you MUST NOT modify.

### Exercise 4: Detailed Instructions

	1. Create a class named BookDAOImpl that implements the BookDAO interface.
	2. Make sure there is a no-arg constructor for BookDAOImpl.
	3. The tables of the relational database are described in the comments of
	   the BookDB and the SQL for creating these tables is in the BookDB.txt
	   file (found in the src/main/resources folder).



## Exercise 5: Implementing `BookController`
### Package: `com.javatester.book.rest`

For this exercise you must implement a Spring Web REST web service based on the
`BookController` interface, which defines methods for retreiving and deleting
books.

### Exercise 5: Detailed Instructions

	1. Create a class named BookControllerImpl that implements the
	   BookController interface.
	2. Make sure there is a no-arg constructor for BookControllerImpl.
	3. Add the correct Spring Web annotations to make BookControllerImpl a
	   RESTful web service.
	4. The Java methods should map the following HTTP methods, HTTP URLs, and
	   the BookDAO methods to get/delete the data from the database.
	
     +-----------------------------------------------------------------------+
     |  REST Method      HTTP Method     HTTP URL            BookDAO Method  |
     +-----------------------------------------------------------------------+
     |  get()            GET             /books               get()          |
     |  get(isbn)        GET             /books/{isbn}        get(isbn)      |
     |  delete(isbn)     DELETE          /books/{isbn}        delete(isbn)   |
     +-----------------------------------------------------------------------+
