package com.utils.quartz.bean;

public class Trigger {
	/*
	 * 触发器类型
	 */
	public static final String TRIGGER_TYPE_DAILY = "daily";
	
	public static final String TRIGGER_TYPE_HOURLY = "hourly";
	
	public static final String TRIGGER_TYPE_MINUTELY = "minutely";
	// 触发器类型（daily，hourly）
	public String triggerType = TRIGGER_TYPE_DAILY;
	
	// 开始小时
	public int startHour = 0;
	
	// 开始分钟
	public int startMinute = 0;
	
	// 间隔值
	public int interval = 1;
	
	// 延迟执行时间（分钟）
	public int delayMinute = 0;

	public String getTriggerType() {
		return triggerType;
	}

	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}

	public int getStartHour() {
		return startHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

	public int getStartMinute() {
		return startMinute;
	}

	public void setStartMinute(int startMinute) {
		this.startMinute = startMinute;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public int getDelayMinute() {
		return delayMinute;
	}

	public void setDelayMinute(int delayMinute) {
		this.delayMinute = delayMinute;
	}

	@Override
	public String toString() {
		return "Trigger [triggerType=" + triggerType + ", startHour="
				+ startHour + ", startMinute=" + startMinute + ", interval="
				+ interval + ", delayMinute=" + delayMinute + "]";
	}
}
