package com.example.collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections4.map.HashedMap;

public class MapTest {
   public static void main(String[] args) {
	   Map<String, Integer> map = new HashedMap<String, Integer>();
	   
	   Map<String, Integer> linkmap = new LinkedHashMap<String, Integer>();
	   int i = 0;
	   while(i <= 5) {
		   map.put(String.valueOf(i), i);
		   linkmap.put(String.valueOf(i), i);
		   i++;
	   }
	   
	   Map<String, Integer> trMap = new TreeMap<String, Integer>(map);
	   
	 /*  //换key或者value都行
	   for(String key:map.keySet()) {
		   System.out.println(map.get(key));
	   }
	   //推荐
	   for(Map.Entry<String, Integer> entry:map.entrySet()) {
		   System.out.println(entry.getKey()+";"+entry.getValue());
	   }
	   //复杂点
	   Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
	   while(iterator.hasNext()) {
		   Map.Entry<String, Integer> entry = iterator.next();
		   System.out.println(entry.getKey()+";"+entry.getValue());
	   }*/
	   System.out.println(map);
	   System.out.println(linkmap);
	   System.out.println(trMap);
   }
}
