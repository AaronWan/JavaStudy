package com.utils.quartz;

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
	private Trigger trigger;

	public Trigger getTrigger() {
		return trigger;
	}

	public void setTrigger(Trigger trigger) {
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

}
