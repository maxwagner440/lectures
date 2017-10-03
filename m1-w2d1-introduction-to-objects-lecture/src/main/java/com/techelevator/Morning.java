package com.techelevator;

import java.time.LocalDate;
import java.util.Date;

public class Morning {
	
	public static void main(String[] args){
		
		char[] name = new char[] {'M', 'a', 'x'};
		char[] space = new char[] {' '};
		char[] lastName = new char[] {'W', 'a', 'g', 'n', 'e', 'r'};
		
		char[] fullName = new char[name.length + space.length + lastName.length];
		
		for(int i = 0; i < name.length; i++){
			fullName[i] = name[i];
		}
		for(int i = 0; i < space.length; i++){
			fullName[i + name.length] = space[i];
		}
		for(int i = 0; i < lastName.length; i++){
			fullName[i + name.length + space.length ] = lastName[i];
		}
		System.out.println(fullName);
			//declaring String Object
		String fullNameString = "Max Wagner";
			//upperCaseName is now all in upper case.
		String upperCaseName = fullNameString.toUpperCase();
		
		System.out.println(fullNameString.equalsIgnoreCase(upperCaseName));
		
		System.out.println(fullNameString.startsWith("Ma"));
			//chops off first and last character (or what ever you want)//
		System.out.println(fullNameString.substring(1, fullNameString.length() - 1));
		
		System.out.println(fullNameString.length());
			//the date
		LocalDate today = LocalDate.now();
		
		System.out.println(today);
			//the date from last week (-7).
		LocalDate lastWeek = today.minusDays(7);
		
		System.out.println(lastWeek);
		
		
}
}
