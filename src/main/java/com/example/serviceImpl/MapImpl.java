package com.example.serviceImpl;

import com.example.service.MapIF;

public class MapImpl<K,V> implements MapIF<K, V> {

	private K key;
	private V value;
	
	
	
	public MapImpl() {
		super();
	}

	public MapImpl(K key,V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	public String getKV() {
		return "getKV";
	}
}
