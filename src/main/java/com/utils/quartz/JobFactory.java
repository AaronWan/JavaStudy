package com.utils.quartz;

import org.apache.commons.lang.StringUtils;

import com.utils.quartz.bean.IJob;
import com.utils.quartz.configure.JobConfig;
import com.utils.quartz.exceptions.NoSuchJobInstanceException;
import com.utils.quartz.job.TestJob;



/**
 * 任务工厂
 * 
 * @author xiezy
 * @version 1.0.0
 * @since 2012-3-28
 */
public class JobFactory {

	public static IJob create(JobConfig jobConfig) throws NoSuchJobInstanceException {
		String job_name=jobConfig.getName();
		if(StringUtils.isNotEmpty(job_name)){
			if(job_name.equals(ScheduledJobConstants.JOB_NAME_SHOW_NOW)){
				return new TestJob(jobConfig);
			}
		}else{
			throw new NoSuchJobInstanceException("没有此实现");
		}
		
		return null;
	}

}
