package com.javatester.book.person;

import java.time.LocalDate;

public class PersonImpl implements Person {
	
	private String firstName, lastName;
	private LocalDate birthDate;

	@Override public String getFirstName() { return this.firstName; }
	@Override public void setFirstName(String s) { this.firstName = s; }

	@Override public String getLastName() { return this.lastName; }
	@Override public void setLastName(String s) { this.lastName = s; }

	@Override public LocalDate getBirthDate() { return this.birthDate; }
	@Override public void setBirthDate(LocalDate d) { this.birthDate = d; }
	
	@Override public String toString() {
		return this.firstName + " " + this.lastName + " (" + this.birthDate + ")";
	}

	@Override public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null) return false;
		if (getClass() != object.getClass()) return false;
		
		Person that = (PersonImpl) object;
		if (birthDate == null) {
			if (that.getBirthDate() != null)
				return false;
		} else if (!birthDate.equals(that.getBirthDate()))
			return false;
		if (firstName == null) {
			if (that.getFirstName() != null)
				return false;
		} else if (!firstName.equals(that.getFirstName()))
			return false;
		if (lastName == null) {
			if (that.getLastName() != null)
				return false;
		} else if (!lastName.equals(that.getLastName()))
			return false;
		return true;
	}
}