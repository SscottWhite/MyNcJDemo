package com.example.ThreadHard.service.Impl;

import com.example.ThreadHard.service.Sub;

public class MyThreadA extends Thread{
	
	private Sub sub;
	
	public MyThreadA(Sub sub) {
		this.sub = sub;
	}
	
/*	@Override
	public void run() {	
		super.run();
		sub.tstMainex();
	}
	*/
	@Override
	public void run() {	
		super.run();
		sub.tstMainOne();
	}
}
