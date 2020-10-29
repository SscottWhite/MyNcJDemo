package com.example.JobTrigger;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.example.JobTrigger.Impl.MyJob;

public class MyTraigger {
	public static void main(String[] args) {
		//任务明细,把储值分给
		JobDetail jobDetail = JobBuilder
								.newJob(MyJob.class)
								.withIdentity("job1", "group1")
								.usingJobData("name", "jake")
								.build();
		//触发器明细
		Trigger trigger = TriggerBuilder
							.newTrigger()
							.withIdentity("trigger1", "group1")
							.startNow()
							.withSchedule(SimpleScheduleBuilder
											.simpleSchedule()
											.withIntervalInSeconds(1)
											.repeatForever())
							.build();
		
		try {
			//调度分配
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.scheduleJob(jobDetail, trigger);
			scheduler.start();
			
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			scheduler.shutdown();
			
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
	}
}
