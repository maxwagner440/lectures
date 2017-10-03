package com.techelevator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Morning {

	public static void main(String[] args) {
		
//		/*Integer i = new Integer(45);
//		
//		System.out.println(i);
//		
//		int n = i;
//		
//		i = n;*/
		
		int[] ports = new int[3];
		ports[0] = 80;
		ports[1] = 8080;
		ports[2] = 445;
		
		int[] newPorts = new int[4];
		
		for(int i = 0; i < ports.length; i++){
			newPorts[i] = ports[i];
		}
		
		newPorts[newPorts.length - 1] = 23;
				//Changed from ArrayList to LinkedList. Can change this because it is an Object.
		List<Integer> goodPorts = new LinkedList<Integer>();
		
		goodPorts.add(80);
		goodPorts.add(8080);
		goodPorts.add(443);
		System.out.println(goodPorts);
		goodPorts.add(23);
		goodPorts.add(0, 432);
		System.out.println(goodPorts);
		goodPorts.remove(1);
		
		System.out.println(goodPorts);
		//Changing ListArray to Int Array. Its the size of the goodPorts.
		Integer[] allPorts = goodPorts.toArray(new Integer[goodPorts.size()]);
			//The ".get" method will get whatever value you put in the (). With this, were looping thru to get each value of goodPorts. Need this method because goodPorts is an Object
		for(int i = 0; i < goodPorts.size(); i++){
			System.out.println("Port " + goodPorts.get(i));
		}
		//"for each" loop:
		for(Integer element : goodPorts){
			System.out.println("For each Port " + element);
		}	
		//"Set" collection. Will not duplicate value. The order will not be guaranteed (but not random every time).
		Set<Integer> addresses = new HashSet<Integer>();
		addresses.add(2200);
		addresses.add(1700);
		addresses.add(2200);
		
		System.out.println(addresses);
	
		//Created a List to put my "Set" into. Purpose is to keep the list in order. Can go from List, to Set, back to List to de-duplicate values.
		List<Integer> orderedAddresses = new ArrayList<Integer>(addresses);
		
		System.out.println(orderedAddresses);
		
		Queue<Integer> theQueue = new LinkedList<Integer>();
		
		theQueue.add(5);
		theQueue.add(23);
		theQueue.add(40);
		//while loop. Retrieves but does not remove. It just "looks" at it
		while(theQueue.peek() != null){
				//.poll will remove the first element off of the queue and then returns it.
			System.out.println(theQueue.poll());
		}
		
		;
		
		theStack.push(5);
		theStack.push(23);
		theStack.push(40);
		
		while(! theStack.isEmpty()){
			System.out.println(theStack.pop());
		}
	
	}
	
	
}
	
	
	


