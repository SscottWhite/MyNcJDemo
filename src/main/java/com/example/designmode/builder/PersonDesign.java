package com.example.designmode.builder;

public class PersonDesign {
	public  Person getInstance(Builder builder) {
		builder.buildName();
		builder.buildAge();
		return builder.getPerson();
	}
}
