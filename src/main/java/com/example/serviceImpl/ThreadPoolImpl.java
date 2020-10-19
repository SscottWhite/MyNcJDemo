package com.example.serviceImpl;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.example.service.ThreadPool;

public class ThreadPoolImpl implements ThreadPool {
	
		public void getThreadPool() {
			  
		    ThreadFactory factory = new ThreadFactory() {  //自定义线程工厂
				
				@Override
				public Thread newThread(Runnable r) {
					return null;
				}
			};
				
			ScheduledExecutorService sser = Executors.newScheduledThreadPool(3);
			ExecutorService exer = Executors.newCachedThreadPool(new MyThreadFactory());
		//	ScheduledThreadPoolExecutor exee = nw
				
			ExecutorService exxcuter = new ThreadPoolExecutor(2, 
									 3, 
								     60,
									 TimeUnit.SECONDS, 
									 new SynchronousQueue<Runnable>(),
									 //factory,
									 Executors.defaultThreadFactory(),
									 new ThreadPoolExecutor.AbortPolicy());
		}
		
		
		public static void main(String[] args) {
			Runnable run = new Runnable() {			
				@Override
				 synchronized public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName()+"--123");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			
			ExecutorService executorService = Executors.newScheduledThreadPool(5);
			int i = 0;
			while (i <= 10) {
				executorService.submit(run);
				i++;
			}
			
			System.out.println( executorService.isShutdown() );
			
			executorService.shutdown();
		}
}
