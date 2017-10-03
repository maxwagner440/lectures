package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Morning {

	public static void main(String[] args) {
		
		Map<Integer, String> rooms = new HashMap <Integer, String>();
		
		rooms.put(101, "Joe");
		rooms.put(102, "Anna");
		rooms.put(103, "Troy");
		
		
		System.out.println(rooms.get(103));
		//deletes past definition of "103" and puts in Bobby.
		rooms.put(103, "Bobby");
		//removing that value and key
		//rooms.remove(103);
		//will replace value with null but keep the key
		//rooms.put(103, null);
		
		System.out.println(rooms.get(105));
		//will return NULL because there is no key available.
		//for each loop that gets the "key" value (.keySet())
		for(Integer key : rooms.keySet()){
			System.out.println(key);
			//This prints the value of each key.
			System.out.println(rooms.get(key));
		}
		
		//getting key value pairs:
		//Entry is an object with name entry
		for(Entry<Integer, String> entry : rooms.entrySet()){
			if(entry.getValue().equals("Bobby")){
				System.out.println("Bobby is in room " + entry.getKey());
				break;
			}
		}
		Map<String, List<Integer>> students = new HashMap<String, List<Integer>>();
		
		List<Integer> heathers = new ArrayList<>();
		
		heathers.add(22);
		heathers.add(66);
		
		students.put("Heather", heathers);
		
		System.out.println(students.get("Heather").get(1));
		
		heathers.add(235);
		
		System.out.println(students.get("Heather").get(2));
	}
	

		

}
