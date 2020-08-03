package com.javatester.book.pojo1;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class PersonImpl implements Person {

	private String firstName;
	private String lastName;
	private LocalDate birthDate;

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public LocalDate getBirthDate() {
		return this.birthDate;
	}

	@Override
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate=birthDate;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Person person = (Person) obj;
		if (this.firstName == null ? person.getFirstName() != null : !this.firstName.equals(person.getFirstName())) {
			return false;
		}
		if (this.lastName == null ? person.getLastName() != null : !this.lastName.equals(person.getLastName())) {
			return false;
		}
		if (this.birthDate == null ? person.getBirthDate() != null : !this.birthDate.equals(person.getBirthDate())) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return firstName.hashCode() + lastName.hashCode()+birthDate.hashCode();
	}

}
