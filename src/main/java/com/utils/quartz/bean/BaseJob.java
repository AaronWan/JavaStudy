/**
 * 
 */
package com.utils.quartz.bean;
import org.joda.time.DateTime;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.utils.quartz.JobManager;
import com.utils.quartz.configure.CustomTrigger;
import com.utils.quartz.configure.JobConfig;

/**
 * 定时任务基类
 * @version 1.0.0
 * @since 2012-3-26
 */
public abstract class BaseJob implements IJob {
	
	private static Logger logger = LoggerFactory.getLogger(BaseJob.class);
	
	// 任务细节
	protected JobDetail jobDetail;
	
	// 触发器
	protected Trigger trigger;
	
	public BaseJob(JobConfig jobConfig) {
		String triggerType = jobConfig.getTrigger().getTriggerType();
		if (CustomTrigger.TRIGGER_TYPE_DAILY.equalsIgnoreCase(triggerType)) {
			// 每日指定时间触发
			this.trigger = TriggerUtils.makeDailyTrigger(
					jobConfig.getTrigger().getStartHour(), jobConfig.getTrigger().getStartMinute());
		} else if (CustomTrigger.TRIGGER_TYPE_HOURLY.equalsIgnoreCase(triggerType)) {
			// 每n小时触发
			this.trigger = TriggerUtils.makeHourlyTrigger(jobConfig.getTrigger().getInterval());
			if (jobConfig.getTrigger().getDelayMinute() > 0) {
				this.trigger.setStartTime(DateTime.now().plusMinutes(jobConfig.getTrigger().getDelayMinute()).toDate());
			}
		} else if (CustomTrigger.TRIGGER_TYPE_MINUTELY.equalsIgnoreCase(triggerType)) {
			// 每n分钟触发
			this.trigger = TriggerUtils.makeMinutelyTrigger(jobConfig.getTrigger().getInterval());
			if (jobConfig.getTrigger().getDelayMinute() > 0) {
				this.trigger.setStartTime(DateTime.now().plusMinutes(jobConfig.getTrigger().getDelayMinute()).toDate());
			}
		}
	}

	public JobDetail getJobDetail() {
		return jobDetail;
	}

	public Trigger getTrigger() {
		return trigger;
	}	
	
	public void setJobDetail(JobDetail jobDetail) {
		this.jobDetail = jobDetail;
	}

	public void setTrigger(Trigger trigger) {
		this.trigger = trigger;
	}
	
	/**
	 * 注册到任务管理器
	 * 
	 * @param jobManager
	 */
	public void register(JobManager jobManager) {
		jobManager.registerJob(this);
		
	}
}
