package com.example.serviceImpl;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
	
	
	public MyThreadFactory() {
		super();
		
	}

	@Override
	public Thread newThread(Runnable r) {
		return null;
	}

}
