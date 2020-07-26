package com.javatester.book.pojo1;

import java.time.LocalDate;

/* DO NOT MODIFY! */
public interface Person {
	
	public String getFirstName();
	public void setFirstName(String s);

	public String getLastName();
	public void setLastName(String s);
	
	public LocalDate getBirthDate();
	public void setBirthDate(LocalDate d);
}