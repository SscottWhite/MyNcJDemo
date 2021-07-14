package com.example.designmode.singleinstance.model;

public class SingleModel {
//	private static SingleModel sm = new SingleModel();
//	private SingleModel() {}
//	
//	public static SingleModel getInstance() {
//		return sm;
//	}
	private int i = 1;
	private static SingleModel sm = null;
	private SingleModel() {}
	public static SingleModel getInstance() {
		if(sm == null) {
			sm = new SingleModel();
		}
		return sm;
	}
	
	public void test() {
		
		i++;
		System.out.println("测试单例"+i);
	}
}
