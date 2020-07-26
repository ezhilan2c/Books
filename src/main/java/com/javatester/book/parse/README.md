# Exercise 3: Implementing `Parser`

For this exercise you must implement the `Parser` interface, which provides
three methods for manipulating a list of `Books`. A detailed description, with
examples, are given in the comments for each of these methods defined in the
`Parser` interface, as well as below (see Additional Information and Example
Input and Output).

## What Is Provided:
1. This README.md file.
2. The Parser interface - DO NOT MODIFY!
3. The ParserTest JUnit - DO NOT MODIFY!

## What You Must Do:
1. Create a class named ParserImpl that implements the Parser interface.
2. Make sure there is a no-arg constructor for ParserImpl.
3. Detailed instructions are provided in the comments for all three method
   defined in the Parser interface. If you follow these instructions and
   implement the methods correctly, then the ParserTest should pass.

## Dependencies
`PersonImpl`
`BookImpl`

## Additional Information

### booksByGenre
The `booksByGenre()` method takes a list of `Book` objects and returns a map
where the keys are `Book.Genre` instances and the values are a list of all the
books that belong to that genre. This method takes an author parameter: if the
author is null, then the method will operate on all books in the list, but if
the author is not null then this method will only operate over the books
for that author.

### countOfBooksBySize
The `countOfBooksBySize()` method takes a list of `Book` objects and returns a
map where the keys are `Book.Size` instances and the values are the number of
books that match that size. For this method, the sizes are defined to be:

		Book.Size.Small		under 100 pages
   		Book.Size.Medium	under 300 pages
   		Book.Size.Large		300 or more pages
   		
### dateError
The `dateError()` method takes a list of `Book` objects and returns a filtered
list of books that have a publication date before the birth date of the author.

## Example Input and Output

### booksByGenre

	  Given these books:

           "Book A"  by Author1  (Literature)
           "Book B"  by Author1  (Literature)
           "Book C"  by Author1  (Science)
           "Book D"  by Author1  (Arts)
	 
           "Book E"  by Author2  (Science)
           "Book F"  by Author2  (Literature)
           "Book G"  by Author3  (Science)
           "Book H"  by Author3  (Arts)
	  		
           "Book I"  by Author3  (Arts)
           "Book J"  by Author3  (Science)
           "Book K"  by Author3  (Science)
           "Book L"  by Author3  (Arts)
           
	  If this method were called with author = null it would return:
	  
           Literature = [Book A, Book B, Book F]
           Science    = [Book C, Book E, Book G, Book J, Book K]
           Arts       = [Book D, Book H, Book I, Book L]
           
	  If this method were called with author = Author1 it would return:
	   
           Literature = [Book A, Book B]
           Science    = [Book C]
           Arts       = [Book D]
           
	  If this method were called with author = Author3 it would return:
	   
           Science    = [Book J, Book K]
           Arts       = [Book I, Book L]

### countOfBooksBySize

	  Given these books:
	  
           "Book A"  with 36 pages
           "Book B"  with 63 pages
           "Book C"  with 99 pages
           "Book D"  with 100 pages
           "Book E"  with 220 pages
           "Book F"  with 178 pages
           "Book G"  with 299 pages
           "Book H"  with 300 pages
           "Book I"  with 369 pages
           "Book J"  with 431 pages
           "Book K"  with 576 pages
           "Book L"  with 800 pages
	   
	  This method would return:
	  
            Small  = 3
            Medium = 4
            Large  = 5
   		
### dateError

	  Given these books:
	  
           "Book A"  published in 1962, written by Author1 born in 1999
           "Book B"  published in 2010, written by Author2 born in 1979
           "Book C"  published in 1979, written by Author3 born in 1965
           "Book D"  published in 2019, written by Author4 born in 1961
           "Book E"  published in 1971, written by Author5 born in 1978
           
	  This method would return: Book A and Book E.