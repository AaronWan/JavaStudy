package com.utils.quartz.bean;

import org.quartz.JobDetail;
import org.quartz.Trigger;

import com.utils.quartz.JobManager;


/**
 * 定时任务接口
 * 
 * @author xiezy
 * @version 1.0.0
 * @since 2012-3-29
 */
public interface IJob {
	
	/**
	 * 获取任务详细
	 * 
	 * @author xiezy
	 * @return
	 */
	public JobDetail getJobDetail();
	
	/**
	 * 获取触发器
	 * 
	 * @author xiezy
	 * @return
	 */
	public Trigger getTrigger();
	
	/**
	 * 注册到任务管理器
	 * 
	 * @author xiezy
	 * @param jobManager
	 */
	void register(JobManager jobManager);

}
