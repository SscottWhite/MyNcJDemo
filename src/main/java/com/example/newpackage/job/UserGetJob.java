package com.example.newpackage.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserGetJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		this.getUSer();
	}
	
	public void getUSer() {
		log.info("getUser");
	}

}
