package com.example.JobTrigger;

import org.quartz.DateBuilder;
import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.example.JobTrigger.Impl.MyJob;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyTraigger {
	
	//private static Logger logger = Logger.getLogger(MyTraigger.class);

	public static void main(String[] args) {
		
		 //触发器和明细都分在一个组里面group1 
		//任务明细,把储值分给
		JobDetail jobDetail = JobBuilder
								.newJob(MyJob.class)  //任务明细
								.withIdentity("job1", "group1")
								.usingJobData("name", "jake")  //要的数据
								.build();
		//触发器明细
		Trigger trigger = TriggerBuilder
							.newTrigger()
							.withIdentity("trigger1", "group1")
							//.startAt(DateBuilder.futureDate(1, IntervalUnit.SECOND))
							.startNow()
							.withSchedule(SimpleScheduleBuilder
											.simpleSchedule()
											.withIntervalInSeconds(5)
											.withRepeatCount(5))
							.build();
		
		try {
			//调度分配
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.scheduleJob(jobDetail, trigger);
			scheduler.start();
			log.info("--任务开始 --");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			scheduler.shutdown();
			log.info("--任务结束--");
		} catch (SchedulerException e) {
			e.printStackTrace();
		}	
	}
}
