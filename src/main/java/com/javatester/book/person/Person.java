package com.javatester.book.person;

import java.time.LocalDate;

public interface Person {
	
	public String getFirstName();
	public void setFirstName(String s);

	public String getLastName();
	public void setLastName(String s);
	
	public LocalDate getBirthDate();
	public void setBirthDate(LocalDate d);
}