package com.example.ThreadHard.service.Impl;

import com.example.ThreadHard.service.OneMoreList;
import com.example.ThreadHard.service.Sub;

public class MyThreadOne extends Thread {

	private OneMoreList  list;
	public MyThreadOne(OneMoreList list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		Sub sub= new Sub();
		sub.addServiceMethod(list, "one");
	}

}
