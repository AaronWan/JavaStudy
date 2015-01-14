package com.utils.quartz.configure;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 定时任务配置解析器
 * 
 * @author xiezy
 * @version 1.0.0
 * @since 2012-3-28
 */
public class JobConfigFromXml {

	private static Logger logger = LoggerFactory
			.getLogger(JobConfigFromXml.class);

	public static final String E_JOB_CONFIG = "job-config";

	public static final String E_JOBS = "jobs";

	public static final String E_JOB = "job";

	public static final String E_TRIGGER = "trigger";

	public static final String E_HOUR = "hour";

	public static final String E_MINUTE = "minute";

	public static final String E_INTERVAL = "interval";

	public static final String E_DELAY_MINUTE = "delay_minute";

	public static final String A_NAME = "name";

	public static final String A_ENABLED = "enabled";

	public static final String A_TYPE = "type";

	// 定时任务配置
	private static List<JobConfig> jobs = new ArrayList<JobConfig>();

	/**
	 * 解析配置文件
	 * 
	 * @param configFile
	 */
	public JobConfigFromXml(String configFile) {
		loadConfig(configFile);
	}

	public static List<JobConfig> loadConfig(String configFile) {
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(new File(configFile));
			Element root = document.getRootElement();
			@SuppressWarnings("unchecked")
			List<Element> jobElements = root.selectNodes("//" + E_JOB);
			for (Element jobElement : jobElements) {
				JobConfig jobConfig = new JobConfig();
				jobConfig.setName(jobElement.attributeValue(A_NAME));
				jobConfig.setEnabled(Boolean.valueOf(jobElement
						.attributeValue(A_ENABLED)));
				Element trigger = jobElement.element(E_TRIGGER);
				String type = trigger.attributeValue(A_TYPE);
				CustomTrigger temp = new CustomTrigger();
				if (CustomTrigger.TRIGGER_TYPE_DAILY.equalsIgnoreCase(type)) {
					temp.setTriggerType(CustomTrigger.TRIGGER_TYPE_DAILY);
					temp.setStartHour(Integer.valueOf(trigger
							.elementText(E_HOUR)));
					temp.setStartMinute(Integer.valueOf(trigger
							.elementText(E_MINUTE)));
				} else if (CustomTrigger.TRIGGER_TYPE_HOURLY.equalsIgnoreCase(type)) {
					temp.setTriggerType(CustomTrigger.TRIGGER_TYPE_HOURLY);
					if (StringUtils.isNotBlank(trigger
							.elementText(E_DELAY_MINUTE))) {
						temp.setDelayMinute(Integer.valueOf(trigger
								.elementText(E_DELAY_MINUTE)));
					}
					temp.setInterval(Integer.valueOf(trigger
							.elementText(E_INTERVAL)));
				} else if (CustomTrigger.TRIGGER_TYPE_MINUTELY.equalsIgnoreCase(type)) {
					temp.setTriggerType(CustomTrigger.TRIGGER_TYPE_MINUTELY);
					if (StringUtils.isNotBlank(trigger
							.elementText(E_DELAY_MINUTE))) {
						temp.setDelayMinute(Integer.valueOf(trigger
								.elementText(E_DELAY_MINUTE)));
					}
					temp.setInterval(Integer.valueOf(trigger
							.elementText(E_INTERVAL)));
				}
				jobConfig.setTrigger(temp);
				jobs.add(jobConfig);
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			logger.error("解析任务配置文件错误！", e);
		}
		return jobs;
	}

	/**
	 * 获取所有任务配置
	 * 
	 * @return
	 */
	public List<JobConfig> getConfigList() {
		return jobs;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JobConfigFromXml jobConfigXml = new JobConfigFromXml(
				"C:\\Users\\lenovo\\study\\javastudy\\JavaStudy\\src\\main\\resources\\job_config.xml");
		List<JobConfig> list = jobConfigXml.getConfigList();
		System.out.println(list);
	}

}
