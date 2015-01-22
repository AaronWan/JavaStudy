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
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;
/**
 * 
 * @author wansong
 * name,xx月xx日,tel
 */
public class FamilyUtils {
	public static void main(String[] args) throws FileNotFoundException,
			IOException, ParseException {
		printHelp();
		Scanner scanner=new Scanner(System.in);
		String familymemberfile = "C:\\Users\\lenovo\\study\\javastudy\\JavaStudy\\src\\test\\resources\\family.properties";
		List<FamilyMember> members = loadFamily(familymemberfile);
//		printFamily(members);
		String line=null;
		while((line=scanner.nextLine())!=null){
			if(line.equals("bye")){
				System.exit(0);
			}else if(line.equals("all")){
				printFamily(members);
			}else{
				try {
					Integer month=new Integer(line);
					List<FamilyMember> current = printFamily(getCurrentMonthMember(members,month));
				} catch (NumberFormatException e) {
					printHelp();
				}
				
			}
		}
	}
	private static void printHelp() {
		System.out.println("bye:exit the command line\n a month number\n all ");
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
	private static List<FamilyMember> printFamily(List<FamilyMember> members) {
		Collections.sort(members);
		List<FamilyMember> monthMembers=new ArrayList<FamilyMember>();
		int month=1;
		for(FamilyMember member:members){
			int current=member.getBirthday().getMonth()+1;
			if(current!=month){
				month=current;
				System.out.println("\n---------"+month+"月生日的家人-------------");
			}
			monthMembers.add(member);
			System.out.println(member);
		}
		return monthMembers;
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
