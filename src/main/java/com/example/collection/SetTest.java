package com.example.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
	public static void main(String[] args) {
		Set<Integer> hs = new HashSet();
		Set<Integer> lhs = new LinkedHashSet();
		for(int i = 1; i <= 5; i++) {
			int s = (int) (Math.random()*100);
			hs.add(new Integer(s));
			lhs.add(new Integer(s));
			System.out.println("第"+i+"个:"+s);
		}
		
		Set<Integer> ts = new TreeSet(hs);
		
		System.out.println(hs.toString());
		System.out.println(lhs.toString());
		System.out.println(ts.toString());
	}
}
