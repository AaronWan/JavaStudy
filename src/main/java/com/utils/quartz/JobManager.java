/**
 * 
 */
package com.utils.quartz;

import java.util.List;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.utils.system.SystemConstants;

/**
 * 定时任务管理器
 */
public class JobManager {
	
	private static Logger logger = LoggerFactory.getLogger(JobManager.class);
	
	/*
	 * 静态实例
	 */
	private static final JobManager instance = new JobManager();
	
	/*
	 * 任务调度器
	 */
	private Scheduler scheduler = null;
	
	private JobManager() {
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
		} catch (SchedulerException e) {
			logger.error("job manager init failed!", e);
		}
	}
	
	public static JobManager getInstance() {
		return instance;
	}
	
	/**
	 * 启动任务管理器
	 */
	public void start() {
		try {
			scheduler.start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			logger.error("job manager start failed!", e);
		}
	}
	
	/**
	 * 停止调度器
	 * @throws SchedulerException
	 */
	public void shutdown() {
		try {
			if (scheduler.isStarted()) {
				scheduler.shutdown();
			}
		} catch (SchedulerException e) {
			logger.error("job manager shutdown error", e);
		}
	}
	
	/**
	 * 注册定时任务
	 * @param orderJob
	 */
	public void registerJob(IJob job) {
		try {
			scheduler.scheduleJob(job.getJobDetail(), job.getTrigger());
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			logger.error("job manager schedule job error! class=" + job.getClass().getName(), e);
		}
	}
	
	/**
	 * 注册并启动所有任务
	 * 
	 * @author xiezy
	 */
	public void regAndStartAllJobs() {
		
		// 解析配置文件
		JobConfigFromXml jobConfigXml = new JobConfigFromXml(SystemConstants.JOB_CONFIG_FILE_PATH);
		
		// 获取所有配置任务
		List<JobConfig> jobConfigs = jobConfigXml.getConfigList();
		
		/*
		 * 注册所有任务
		 */
		for (JobConfig jobConfig : jobConfigs) {
			// 是否启用
			if (jobConfig.isEnabled()) {
				IJob collectJob = JobFactory.create(jobConfig);
				// 注册到任务管理器
				collectJob.register(this);
			}
		}
		
		// 启动任务管理器
		start();
		logger.info("任务管理器启动成功！");
	}
	
	public static void main(String[] args) {
		JobManager.getInstance().regAndStartAllJobs();
	}

}
