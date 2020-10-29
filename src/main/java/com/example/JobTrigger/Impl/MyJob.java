package com.example.JobTrigger.Impl;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDetail jobDetail = context.getJobDetail();
		String name = jobDetail.getJobDataMap().getString("name");
		System.out.println("Myjob:" + name + ";" + new Date());
		
	}

}
