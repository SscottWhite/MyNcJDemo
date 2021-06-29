package com.example.lambda;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class Optional {
	public static void main(String[] args) {
		System.out.println(LocalDate.now().isLeapYear());
		//Stream.of("1,2,3").
	
		Stream<String> A = Stream.of(new String[]{"a","b","c"});
		Stream<String> B = List.of("e","f","g").stream();
		A.forEach(System.out::println);
		B.forEach(System.out::println);
		
	
	}
}
