package com.utils.family;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/**
 * 
 * @author wansong
 * name,xx月xx日,tel
 */
public class FamilyUtils {
	public static void main(String[] args) throws FileNotFoundException,
			IOException, ParseException {
		String familymemberfile = "D:\\develop\\workspace\\Thread_Web\\src\\contract.properties";
		List<FamilyMember> members = loadFamily(familymemberfile);
//		printFamily(members);
		printFamily(getCurrentMonthMember(members,12));
	}
	@SuppressWarnings("deprecation")
	private static List<FamilyMember> getCurrentMonthMember(List<FamilyMember> members,int month){
		List<FamilyMember> current = new ArrayList<FamilyMember>();
		for(FamilyMember member:members){
			if(member.getBirthday().getMonth()==month-1){
				current.add(member);
			}
		}
		return current;
	}
	private static void printFamily(List<FamilyMember> members) {
		Collections.sort(members);
		int month=1;
		for(FamilyMember member:members){
			int current=member.getBirthday().getMonth()+1;
			if(current!=month){
				month=current;
				System.out.println("\n---------"+month+"月生日的家人-------------");
			}
			System.out.println(member);
		}
	}

	private static List<FamilyMember> loadFamily(String familymemberfile)
			throws FileNotFoundException, IOException, ParseException {
		List<FamilyMember> members = new ArrayList<FamilyMember>();
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								familymemberfile)));
		String line = null;
		DateFormat dataFormat = new SimpleDateFormat("MM月dd日", Locale.CHINA);
		while ((line = br.readLine()) != null) {
			String[] temps = line.split(",");
			String name = temps[0], birthday = temps[1],
			phoneNo = temps.length>2?temps[2]:"";
			Date d = dataFormat.parse(birthday);
			members.add(new FamilyMember(name, d, phoneNo));
		}
		return members;
	}

}
