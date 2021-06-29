package com.example.lambda;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierTest {
	public static void main(String[] args) {
		Stream.generate(new getsup())
			 .limit(31)
			 .filter(day -> day.getDayOfWeek() == DayOfWeek.SATURDAY || day.getDayOfWeek() == DayOfWeek.SUNDAY)
			 .forEach(System.out::println);
		
		
	   List.of("1","2").stream().toArray(String[]::new);
	   
	}
}

//这个是用于累加的stream方法, 记住一定要控制, 不然会一直计算到上限
class getsup implements Supplier<LocalDate>{
	LocalDate date= LocalDate.of(2021, 1, 1);
	int n = -1;	
	@Override
	public LocalDate get() {
		n++;
		return date.plusDays(n);
	}	
}
