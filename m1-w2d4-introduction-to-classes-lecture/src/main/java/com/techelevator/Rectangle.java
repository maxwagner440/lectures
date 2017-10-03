package com.techelevator;

public class Rectangle {
	
	//instance variable definitions
	private int length = 1;
	private int height = 1;
	
	//Explicitly defining the default constructor. If you did not define, the default would not be there because you DEFINED A CONSTRUCTOR RIGHT UNDER HERE>
	public Rectangle () {
		
	}
	//Constructor: Creating constructor
	public Rectangle(int length, int height){
		this.length = length;
		this.height = height;
		
	}
	
//Creating methods: Area
	public int getArea(){
		return length * height;
		//dont have to put "this.length" or height beause this is the only length or height 		within this method.
	}
		
//Creating comparison of rectangles (boolean):
		
	public boolean isLargerThan(Rectangle other){
		return this.getArea() > other.getArea();
	
	}
	
	
//Creating comparison of rectangles by height and length NOT AREA (boolean):
	
	public boolean isLargerThan(int length, int height){
		return this.getArea() > (length * height);
	}
	//access modifier, getLength - getter. It returns length.
	public int getLength(){
		return length;
	}
	//getter. doesnt return anything so void
	public void setLength(int length){
		if(length > 0){
			this.length = length; //this.length is the length were in right now. and = length is the length the object is given
		}
		
		
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		if(height > 0){
			this.height = height;
		}
	
	}
	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", height=" + height + "]";
	}

}
