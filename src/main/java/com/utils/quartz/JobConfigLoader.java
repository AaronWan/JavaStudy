package com.utils.quartz;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.utils.quartz.exceptions.ConfigTypeError;

public class JobConfigLoader {
	public final  static int CONFIG_TYPE_JSON=1;
	public final  static int CONFIG_TYPE_XML=2;
	@SerializedName("jobs")
	private List<JobConfig> jobs;

	public List<JobConfig> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobConfig> jobs) {
		this.jobs = jobs;
	}
	/**
	 * 
	 * @param configPath 配置文件的路径
	 * @param configType JobConfigLoader.CONFIG_TYPE_JSON 和 JobConfigLoader.CONFIG_TYPE_XML 两种类型
	 * @return
	 * @throws ConfigTypeError 
	 */
	public static List<JobConfig> loadConfig(String configPath,int configType) throws ConfigTypeError {
		List<JobConfig> jobs=null;
		switch(configType){
		case JobConfigLoader.CONFIG_TYPE_JSON:jobs=JobConfigFromJson.loadConfig(configPath);break;
		case JobConfigLoader.CONFIG_TYPE_XML:jobs=JobConfigFromXml.loadConfig(configPath);break;
		default:throw new ConfigTypeError("配置文件类型错误,请选用:\n\tJobConfigLoader.CONFIG_TYPE_JSON\n\t或\n \tJobConfigLoader.CONFIG_TYPE_XML");
		}
		return jobs;
	}

	public static void main(String[] args) throws ConfigTypeError {
		List<JobConfig> xx = loadConfig("C:\\Users\\lenovo\\study\\javastudy\\JavaStudy\\src\\main\\resources\\job_config.dat",JobConfigLoader.CONFIG_TYPE_JSON);
		System.out.println(xx);
	}
}
