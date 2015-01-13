package com.utils.quartz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.annotations.SerializedName;
import com.utils.json.GsonUtil;

public class JobConfigFromJson {
	@SerializedName("jobs")
	private List<JobConfig> jobs;

	public List<JobConfig> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobConfig> jobs) {
		this.jobs = jobs;
	}

	public static List<JobConfig> loadConfig(String jsonfilepath) {
		String json = null;
		try {
			json = IOUtils.toString(new FileInputStream(jsonfilepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (json != null) {
			return GsonUtil.fromJson(json, JobConfigFromJson.class).jobs;
		} else {
			return new ArrayList<JobConfig>();
		}
	}

	public static void main(String[] args) {
		List<JobConfig> xx = loadConfig("C:\\Users\\lenovo\\study\\javastudy\\JavaStudy\\src\\main\\resources\\job_config.dat");
		System.out.println(xx.toString());

	}
}
