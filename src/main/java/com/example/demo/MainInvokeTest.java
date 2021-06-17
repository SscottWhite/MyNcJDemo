package com.example.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.jdt.internal.compiler.codegen.IntegerCache;

import com.example.enumtest.TencentChannelRule;

public class MainInvokeTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method m = String.class.getMethod("substring", int.class);
		String s = (String) m.invoke("ABCDEFGHIJK", 6);
		System.out.println(s);
		
		Class str1 = String.class;
		Class str2 = "hello".getClass();
		System.out.println(str1 == str2);
		
		Integer i = new Integer(123);
		System.out.println(i.getClass() == Integer.class);
		System.out.println(Integer.class.getMethods());
		System.out.println(i.getClass().getSuperclass());
		System.out.println("-----------------------------");
		Class class1 = Integer.class;
		Class[] arr = class1.getInterfaces();
		for(Class i1: arr) {
			System.out.println(i1);
		}
	}
}
