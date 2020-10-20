package com.example.ThreadHard.service.Impl;

import com.example.ThreadHard.service.Sub;

public class MyThreadB extends Thread{

	private Sub sub;
	
	public MyThreadB(Sub sub) {
		this.sub = sub;
	}
	/*@Override
	public void run() {
		super.run();
		sub.tstMainex();
	}*/
	@Override
	public void run() {
		super.run();
		sub.tstMainOne();
	}
}
