package com.utils.quartz.job;

import org.quartz.JobDetail;
import org.quartz.Scheduler;

import com.utils.quartz.bean.BaseJob;
import com.utils.quartz.configure.JobConfig;

public class TestJob extends BaseJob {

	public TestJob(JobConfig jobConfig) {
		super(jobConfig);
		this.jobDetail = new JobDetail(jobConfig.getName(), Scheduler.DEFAULT_GROUP, TestJobHello.class);
		this.trigger.setName(jobConfig.getName());
	}

}
