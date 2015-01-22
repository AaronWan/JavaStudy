package com.utils.family;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

public class FamilyMember implements Comparable<FamilyMember> {
	DateFormat dataFormat = new SimpleDateFormat("MM月dd日", Locale.CHINA);
	private String name;
	private Date birthday;
	private String phoneNo;

	public FamilyMember(String name, Date birthday, String phoneNo) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public int compareTo(FamilyMember o) {
		return -o.birthday.compareTo(this.birthday);
	}

	@Override
	public String toString() {
		return  name + "\t" + dataFormat.format(birthday)
				+ "\t" + StringUtils.trim(phoneNo) ;
	}

}