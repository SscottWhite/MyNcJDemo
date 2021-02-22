package com.example.collection;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

public class MapTest {
   public static void main(String[] args) {
	   Map<String, Integer> map = new HashedMap<String, Integer>();
	   map.put("1", 1);
	   map.put("2", 2);
	   map.put("3", 3);
	   
	   //换key或者value都行
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
	   }
   }
}
