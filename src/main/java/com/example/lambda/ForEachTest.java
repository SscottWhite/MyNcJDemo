package com.example.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachTest {
	public static void main(String[] args) {
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);
		items.forEach((k,v) -> System.out.println(k+":"+v));
		
		List<String> items1 = new ArrayList<>();
		items1.add("A");
		items1.add("B");
		items1.add("C");
		items1.add("D");
		items1.add("E");
		items1.forEach(item -> System.out.println(item));
		
	}
}
