package com.example.designmode.builder;

public class PersonGet implements Builder{

	Person person;
	
	public PersonGet() {
		person = new Person();
	}
	
	@Override
	public void buildName() {
		person.setAge("12");
	}

	@Override
	public void buildAge() {
		person.setName("Jack");
	}

	@Override
	public Person getPerson() {	
		return person;
	}

}
