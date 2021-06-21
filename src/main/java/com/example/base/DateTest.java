package com.example.base;

import java.util.Calendar;
import java.util.Date;

public class DateTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Long lo = System.currentTimeMillis();
		Date  date = new Date();
		System.out.println(date.getYear() + 1900);
		System.out.println(date.getMonth()+1);
		System.out.println(date.getDate());
		System.out.println(date.toString());
		System.out.println(date.toGMTString());
		System.out.println(date.toLocaleString());
		
		System.out.println(System.currentTimeMillis() - lo);
		
		Calendar calendar = Calendar.getInstance();
		
		System.out.println(calendar.get(calendar.YEAR));
	}
}
