package com.example.serviceImpl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import com.example.service.RunThread;
import com.example.service.ThreadPool;

public class RunThreadService implements RunThread {

	public static void main(String[] args) {
		RunThreadService service = new RunThreadService();
	//	service.runThread();
	//	service.runnableThread();
		service.callable();
	//	service.threadPool();
	}

//Thread - run
	public void runThread() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				super.run();
				System.out.println("thread run!");
			}
		};
		thread.start();
	}
	
//Thread - runnable
	public void runnableThread() {
		Thread runnable =new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("runnable run!");
			}
		});
		runnable.start();
	}
	
	/*
	 * //FutureTask实现了RunnableFuture接口
		public class FutureTask<V> implements RunnableFuture<V> {
		}
		
		//RunnableFuture接口，继承自Runnable和Future
		public interface RunnableFuture<V> extends Runnable, Future<V> {
		    void run();
		}
	*/
//Thread - futureTask - callable
	public void callable() {

	//	ExecutorService exe = Executors.newFixedThreadPool(2);
		
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				return Thread.currentThread().getName()+"String call";
			}
		};
		//futureTask 可以看做是future的实现类
		FutureTask<String> futureTask = new FutureTask<String>(callable);//参数放  callable或者runnable	
		
		//exe.submit(futureTask);  // 这个任务也能放进去
		
		//启动类还是thread
		Thread thread = new Thread(futureTask);
		
		Thread dthreadThread= new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"--this is a dThread");	
			}
		});
		
		
		String str;
		try {
			//dthreadThread.join();
			thread.start();
			thread.join();  //这边是等到上面的start运行完才运行  join, 所以会触发下面的isDone ,要注意
			
			//实现的也是future里的方法
			 if (futureTask.isCancelled()) {
		         System.out.println("任务被取消了");
		         return;
		     }
		     if (futureTask.isDone()) {
		         System.out.println("任务完成了");
		         System.out.println(futureTask.get());
		         return;
		     }
			str = futureTask.get();
			
			System.out.println(str);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *    不带返回值的任务在线程池中执行
	 *
	  private static void runThreadByExecutorService(Runnable runnable) {
		    ExecutorService executor = Executors.newCachedThreadPool();
		    executor.execute(runnable);
	  }
	*
	* /sumit源码
		public <T> Future<T> submit(Callable<T> task) {
		    if (task == null) throw new NullPointerException();
		    RunnableFuture<T> ftask = newTaskFor(task);
		    execute(ftask);
		    return ftask;
		}
		
		//将Callable包装为RunnableFuture
		protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
		    return new FutureTask<T>(callable);
		}
	*/
	
//加入一个线程池 pool
	public void threadPool() {
		//这种构建方式不好, 用ThreadPoolExecutor来创建
		ExecutorService executorService = Executors.newCachedThreadPool();
		//submit返回的就是接口future
		//执行
		Future<String> future = executorService.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "threadPool call!";
			}
		});
		//关闭线程池
		executorService.shutdown();
	
		try {
			String str = future.get();
			System.out.println(str);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	
}


