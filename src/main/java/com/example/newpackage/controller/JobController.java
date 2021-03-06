package com.example.newpackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newpackage.service.QuartzService;
import com.example.newpackage.service.TestJob1;

@RestController
@RequestMapping("/job")
public class JobController {

	@Autowired
    private QuartzService quartzService;
	
    @RequestMapping("/addjob")
    public void startJob(String type) {
          quartzService.addJob(TestJob1.class, "job1", "test", "0/5 * * * * ?");

    }
    
    @RequestMapping("/updatejob")
    public void updatejob() {
            quartzService.modifyJobTime("job1", "test", "0/10 * * * * ?");
    }
    
    @RequestMapping("/deletejob")
    public void deletejob() {
            quartzService.removeJob("job1", "test","job1", "test");
    }
    
    @RequestMapping("/pauseJob")
    public void pauseJob() {
            quartzService.pauseJob("job1", "test");
    }
    
    @RequestMapping("/resumeJob")
    public void resumeJob() {
            quartzService.resumeJob("job1", "test");
    }
    
    @RequestMapping("/queryAllJob")
    public Object queryAllJob() {
            return quartzService.queryAllJob();
    }
    

    @RequestMapping("/queryRunJob")
    public Object queryRunJob() {
            return quartzService.queryRunJob();
    }
}
