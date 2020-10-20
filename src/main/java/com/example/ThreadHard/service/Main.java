package com.example.ThreadHard.service;

public class Main {
	public int i = 10;
    synchronized public void tstMain() {
		try {
			i--;
			Thread.sleep(100);
			System.out.println("main:"+i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
    
    synchronized public void tstMainex() {
		System.out.println("main begin "+ Thread.currentThread().getName() +"---" + System.currentTimeMillis());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main end "+ Thread.currentThread().getName() +"---" + System.currentTimeMillis());
	}
    
 
}



