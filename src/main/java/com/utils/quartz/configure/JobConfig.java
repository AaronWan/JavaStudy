package com.utils.quartz.configure;

import com.google.gson.annotations.SerializedName;

/**
 * 定时任务配置
 * 
 * @author suli
 * @version 1.0.0
 * @since 2012-3-27
 */
public class JobConfig {

	// 名称
	private String name;

	// 启用
	private boolean enabled = true;
	//触发器配置
	@SerializedName(value="trigger")
	private CustomTrigger trigger;

	public CustomTrigger getTrigger() {
		return trigger;
	}

	public void setTrigger(CustomTrigger trigger) {
		this.trigger = trigger;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "JobConfig [name=" + name + ", enabled=" + enabled
				+ ", trigger=" + trigger + "]";
	}

}
