package com.techelevator;

public class Tester {

	public static void main(String[] args) {
		Rectangle square = new Rectangle();
		square.setLength(5);
		square.setHeight(5);
				//getting length
		System.out.println(square.getLength());
		
		Rectangle wall = new Rectangle(30, 25);
				//getting area method.
		System.out.println(wall.getArea());
		
		if(square.isLargerThan(3, 3)){
			System.out.println("Square is bigger");
		}else
			System.out.println("Square is not bigger");
	}

}
