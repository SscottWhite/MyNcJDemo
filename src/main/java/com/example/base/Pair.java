package com.example.base;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 泛型
 * @author KJS_352
 *
 * @param <T>
 * @param <K>
 */
public class Pair<T,K> {
	private T first;
	private K second;
	
	public Pair(T string, K i) {
		
	}
	public Pair() {
		
	}
	public T getFirst() {
		return first;
	}
	public K getSecond() {
		return second;
	}
	public void setFirst(T first) {
		this.first = first;
	}
	public void setSecond(K second) {
		this.second = second;
	}
}

class PairDTO{
	
	static void add(Pair<? extends String, ? extends Number> p) {
		String str = p.getFirst();
		Number str2 = p.getSecond();
	}
	 // 把src的每个元素复制到dest中:
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        for (int i=0; i<src.size(); i++) {
            T t = src.get(i);
            dest.add(t);
        }
        
        Collections.copy(dest, src);
    }
	
	public static void main(String[] args) {
		Pair<String,Integer> pair = new Pair<String, Integer>();
		pair.setFirst("ee");
		pair.setSecond(123);
		System.out.print(pair);
	}
}