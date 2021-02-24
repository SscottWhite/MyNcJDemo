package com.example.base;

public class BasicsMath {
	public static void main(String[] args) {
		int i = 12,j = 11;
		int x = -12;
		System.out.println(i | j);//  1100 | 1011 = 1111 =15 
		System.out.println(i ^ j);//  1100 ^ 1011 = 0111 =7
		System.out.println(i & j);//  1100 | 1011 = 1000 =8 
		System.out.println(~i);// -1011 
//		System.out.println(Integer.toBinaryString(i) +"+"+ Integer.toBinaryString(j));
//		System.out.println(i >>>= 1);//6
//		System.out.println(x >>>= 1);//7
//		System.out.println(j >>>= 1);//5
		System.out.println( -1 << 30);
	}
}
