# JAVA CODING TEST

## Description
This *coding test* is designed to test your proficiency in the following areas:

	- Ability to use an IDE, Git, and Gradle.
	- Java programming and running and debugging from JUnit tests.
	- Java 8 functional programming, including lambdas and streams.
	- SQL and JDBC (or Spring JDBC) against a relational database.
	- Implementing Spring RESTful web services.
	- Ability to read, understand, and follow instructions.
	
## General Instructions

	1. Carefully read and understand these instructions and the instructions for
	   each of the five exercises given in the README.md files that are to be
	   found in the five packages under src/main/java.
	   
	2. Most of the exercises build upon the work done in previous exercises, so
	   you should complete them in order:
	   
	   		(1)  Package ~.pojo1
			(2)  Package ~.pojo2      (depends on pojo2)
			(3)  Package ~.parse      (depends in pojo1 and pojo2)
			(4)  Package ~.dao        (depends in pojo1 and pojo2)
			(5)  Package ~.rest       (depends in pojo1, pojo2, and dao)
			
	   As you can see, "parse" is not used by "dao" or "rest", so it can be
	   completed last.
			
	3. For each exercise, you will have an interface to implement and a JUnit
	   test (located in src/test/java). All of your implementation classes
	   MUST be in the same package as the interface and MUST be named after the
	   interface + "Impl". For example, given an interface called "Parser.java"
	   your implementation should named "ParserImpl.java".
	   
	4. You MUST NOT modify any of the interfaces that you will be
	   implementing - doing so will change the API and invalidate your solution.
	   
	5. You also MUST NOT modify any of the JUnit test - doing so will change
	   the conditions of the test and invalidate your solution.
	   
	6. Each of the five exercises will require you to write an ~"Impl" class,
       and this is all that is required to complete the exercises. You may write
       any additional classes you may need for your solution.
	   
## What You Will Need
	
	1. You will need Java version 8 or higher.
	
	2. You will need Gradle version 6 or higher.
	
	3. You may use an IDE of your choice: e.g. Eclipse, IntelliJ, or NetBeans.
	
	4. Dependencies for Spring, Spring Boot, Spring Web, and Spring JDBC are
	   included in the build.gradle because they are required for the solutions.
	   
	5. If you want to include other packages to complete your solutions, you
	   are free to modify build.gradle file to include them, although this
	   should not be required to complete any of the exercises.

## How to Submit the Code

	1. Clone this repo from GitHub.
	
	2. Create a branch (name it "develop-" + your last name).
	
	3. Complete the exercise as completely as you can.
	
	3. Commit your solution to GitHub.
	
	4. Create a pull request when you are ready to submit your final solutions.
	
	5. You have 8 hours to complete these exercises, from the time you accept
       the GitHub invitation until the time you submit your pull request.