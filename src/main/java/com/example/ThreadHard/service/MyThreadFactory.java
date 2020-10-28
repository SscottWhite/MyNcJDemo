package com.example.ThreadHard.service;

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
