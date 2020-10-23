package com.example.ThreadHard.service.Impl;

import java.util.Optional;

import com.example.ThreadHard.service.*;

public class MyThread{
		//测试 可重入锁, 锁里面再套锁
/*	public static void main(String[] args) {
			Thread myThread = new Thread(new Runnable() {
				@Override
				public void run() {
					Sub  sub = new Sub();
					sub.tstSub();
				}
			});
			myThread.start();
		}
	
	
	//测试同步  继承的重写方法, 是否要锁? 证明 重写方法要枷锁
/*	public static void main(String[] args) {
		Sub sub = new Sub();
		MyThreadA a = new MyThreadA(sub);
		a.setName("a");
		a.start();
		MyThreadB b = new MyThreadB(sub);
		b.setName("b");
		b.start();
	}
	*/
	
    //测试锁 代码块
/*	public static void main(String[] args) {
		Sub subone = new Sub();
		MyThreadA a = new MyThreadA(subone);
		a.setName("a");
		a.start();
		MyThreadB b = new MyThreadB(subone);
		b.setName("b");
		b.start();
	}
	*/
	
	public static void main(String[] args) throws InterruptedException {
		OneMoreList olist = new OneMoreList();
		String str= null;
		MyThreadOne one = new MyThreadOne(olist);
		one.setName("oneA");
		one.start();
		MyThreadTwo two = new MyThreadTwo(olist);
		two.setName("twoB");
		two.start();
		
		Thread.sleep(6000);
		
		System.out.println(Optional.ofNullable(str));
		System.out.println("lsit size:"+olist.getList());
	}
}
