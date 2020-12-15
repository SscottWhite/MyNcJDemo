package com.example.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainInvokeTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method m = String.class.getMethod("substring", int.class);
		String s = (String) m.invoke("ABCDEFGHIJK", 6);
		System.out.print(s);
	}
}
