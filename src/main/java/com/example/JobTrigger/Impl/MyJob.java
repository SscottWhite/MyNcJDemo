package com.example.JobTrigger.Impl;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {

	
	//jobExecutionContext 提供调度上下文各种信息，运行时数据保存在jobDataMap中
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDetail jobDetail = context.getJobDetail();
		String name = jobDetail.getJobDataMap().getString("name");//从上面的jobdetail中获取
		System.out.println("Myjob:" + name + ";" + new Date());
		
	}

}
