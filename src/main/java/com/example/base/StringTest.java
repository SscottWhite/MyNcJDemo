package com.example.base;

import java.util.StringJoiner;

import lombok.experimental.var;

public class StringTest {
	public static void main(String[] args) {
//		String[] str = {"we","er","rt"};
//		StringJoiner js = new StringJoiner(" ,","hello "," !");
//		for (String name: str) {
//			js.add(name);
//		}
//		System.out.println(js.toString());
		
		System.out.println((int)"A".charAt(0)); //65 强转
		System.out.println((char)65); //A 强转
		char ch = "A".charAt(0);
		System.out.println(Integer.parseInt(Integer.toHexString(ch),16));//65 16进制转10进制
		
		char ch2 = "A".charAt(0);
		System.out.println(Integer.parseInt(Integer.toBinaryString(ch2),2));//65 2进制转10进制
		
		System.out.println(AZ(26));
	}
	//数字转字母
	public static String AZ(int num) {
		if(num < 1  || num > 27) {
			return "";
		}
		return String.valueOf((char)(num+64))+";"+String.valueOf((char)(num+96));	
	}
}
