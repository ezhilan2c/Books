package com.javatester.book.pojo2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import com.javatester.book.pojo1.Person;
import com.javatester.book.test.AbstractTest;

/* DO NOT MODIFY THIS CLASS! */
public class PersonTest extends AbstractTest {

	@Test void testNoArgConstructor() {
		newPerson();
	}
	
	@Test void testFirstName() {
		Person person = newPerson();
		assertEquals(person.getFirstName(), null);
		String firstName = randomFirstName();
		person.setFirstName(firstName);
		assertEquals(person.getFirstName(), firstName);
	}
	
	@Test void testLastName() {
		Person person = newPerson();
		assertEquals(person.getLastName(), null);
		String lastName = randomLastName();
		person.setLastName(lastName);
		assertEquals(person.getLastName(), lastName);
	}
	
	@Test void testBirthDate() {
		Person person = newPerson();
		LocalDate date = randomDate(1950, 2010);
		assertEquals(person.getBirthDate(), null);
		person.setBirthDate(date);
		assertEquals(person.getBirthDate(), date);
	}
	
	@Test void testValidEquals() {
		Person p1 = newPerson("John", "Doe", LocalDate.parse("1974-11-23"));
		Person p2 = newPerson("John", "Doe", LocalDate.parse("1974-11-23"));
		assertEquals(p1, p2);
	}
	
	@Test void testInvalidEqualsFirstName() {
		Person p1 = newPerson("John", "Doe", LocalDate.parse("1974-11-23"));
		Person p2 = newPerson("Jon", "Doe", LocalDate.parse("1974-11-23"));
		assertNotEquals(p1, p2);
	}
	
	@Test void testInvalidEqualsLastName() {
		Person p1 = newPerson("John", "Doe", LocalDate.parse("1974-11-23"));
		Person p2 = newPerson("John", "Doh", LocalDate.parse("1974-11-23"));
		assertNotEquals(p1, p2);
	}
	
	@Test void testInvalidEqualsBirthDate() {
		Person p1 = newPerson("John", "Doe", LocalDate.parse("1974-11-23"));
		Person p2 = newPerson("John", "Doe", LocalDate.parse("1974-11-22"));
		assertNotEquals(p1, p2);
	}
	
	@Test void testNullEquals() {
		assertNotEquals(randomPerson(), null);
	}
	
	@Test void testObjectEquals() {
		assertNotEquals(randomPerson(), new Object());
	}
}
