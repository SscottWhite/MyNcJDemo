package com.example.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *  一边遍历, 一边删除
 * @author KJS_352
 *
 */
public class ListTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();		
		
		int i = 0;
		while(i <= 5) {
			list.add(i);
			i++;
		}
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			int x = it.next();
			if(x == 3) {
				it.remove();
			}
		}
		//1.8  和上面的一样
		list.removeIf(filter -> 2 == filter);
		
		/* java.util.ConcurrentModificationException    报错
		for(Integer x:list) {
			if(x == 3) list.remove(x);
		}*/
		
		System.out.print(list);
	}
}
