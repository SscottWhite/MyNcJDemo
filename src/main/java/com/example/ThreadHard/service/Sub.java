package com.example.ThreadHard.service;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class Sub extends Main {
	//一般测试
	 public synchronized void tstSub() {
		while(i > 0) {
			try {
				i--;
				Thread.sleep(100);
				System.out.println("sub:"+i);
				this.tstMain();
			} catch (InterruptedException e) {		
				e.printStackTrace();
			}
		}
	}

	//重写
	@Override
	public synchronized void tstMainex() {	
		
		System.out.println("sub begin "+ Thread.currentThread().getName() + "---" + System.currentTimeMillis());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("sub end "+ Thread.currentThread().getName() + "---" + System.currentTimeMillis());
		
		super.tstMainex();
	}
	//代码块
	public void tstMainOne() {
		int i = 1;
		String str = new String();
		String str2 = new String();
    	try {
//    		synchronized (this) {
//    			System.out.println("sub begin "+ Thread.currentThread().getName() +"---" + System.currentTimeMillis());
//    			Thread.sleep(1000);
//    			System.out.println("sub end "+ Thread.currentThread().getName() +"---" + System.currentTimeMillis());
//			}
    		System.out.println("sub begin "+ Thread.currentThread().getName() +"---" + System.currentTimeMillis());
			Thread.sleep(1000);
			System.out.println("sub end "+ Thread.currentThread().getName() +"---" + System.currentTimeMillis());
			synchronized (this) {
				i++;
			}
			//锁非this , 可以很多个代码块争抢资源
		/*	synchronized(str) {
				i++;
			}
			synchronized(str2) {
				i++;
			}
			*/
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
	
	//onemorelist  测试
	public OneMoreList addServiceMethod(OneMoreList oml, String str) {
		
		try {
			synchronized (oml) {  //解决脏读 , list不可能是2
				if(oml.getList() < 1) {
					Thread.sleep(2000);
					oml.setList(str);
				}
			}			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return oml;
	}
}