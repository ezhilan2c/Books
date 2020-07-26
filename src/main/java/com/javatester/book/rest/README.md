# Exercise 5: Implementing `BookController`

For this exercise you must implement a Spring Web REST web service based on the
`BookController` interface, which defines methods for retreiving and deleting
books.

## What Is Provided:
1. This README.md file.
2. The BookController interface - DO NOT MODIFY!
3. The BookControllerTest JUnit - DO NOT MODIFY!

## What You Must Do:
1. Create a class named BookControllerImpl that implements the
   BookController interface.
2. Make sure there is a no-arg constructor for BookControllerImpl.
3. Add the correct Spring Web annotations to make BookControllerImpl a
   RESTful web service.
4. The Java methods should map the following HTTP methods, HTTP URLs, and
   the BookController methods to get/delete the data from the database.
	
   +-------------------------------------------------------+
   |  BookController     HTTP Method     HTTP URL          |
   +-------------------------------------------------------+
   |  get()              GET             /books            |
   |  get(isbn)          GET             /books/{isbn}     |
   |  delete(isbn)       DELETE          /books/{isbn}     |
   +-------------------------------------------------------+
   
## Dependencies
`PersonImpl`
`BookImpl`
`BookServiceImpl`