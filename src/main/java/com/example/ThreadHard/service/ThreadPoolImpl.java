package com.example.ThreadHard.service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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
			
				
			ExecutorService exxcuter = new ThreadPoolExecutor(2, 
									 3, 
								     60,
									 TimeUnit.SECONDS, 
									 new SynchronousQueue<Runnable>(),
									 //factory,
									 Executors.defaultThreadFactory(),
									 new ThreadPoolExecutor.AbortPolicy());
		}
		
		
		public static void main(String[] args) throws Exception, ExecutionException {
			Runnable run = new Runnable() {			
				@Override
				 synchronized public void run() {
					System.out.println(Thread.currentThread().getName()+"--123");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			
			Callable<String> callable = new Callable<String>() {
				@Override
				public synchronized String call() throws Exception {
					return "213-"+Thread.currentThread().getName();
				}
			};
			
			ExecutorService executorService = Executors.newScheduledThreadPool(5);
			ExecutorService exe = Executors.newFixedThreadPool(2);
			
			
			int i = 0;
			while (i <= 10) {
				executorService.submit(run);
				i++;
			}
			
			while(i < 20 ) {
				Future<String> future = exe.submit(callable);
				i++;
				System.out.println(future.get());
			}
			
			System.out.println( executorService.isShutdown() );
			
			executorService.shutdown();
		}
}
