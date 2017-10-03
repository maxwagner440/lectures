package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.techelevator.exceptions.OverdraftException;

public class ExceptionExamples {

	public static void main(String[] args) throws OverdraftException  {
		int[] nums = null;
		try{
			nums = getArray();
		} catch(ArrayIndexOutOfBoundsException ex){
			System.out.println("The Error is Here: " + ex.getMessage());
		} 
		
		if(nums != null){
		
	//	System.out.println(nums[0] + " " + nums[1] + " " + nums[2]);
	//	System.out.println("Done.");
		}
		
		//Using OverdraftException
		try{
		System.out.println(withdraw(100.00, 50.00));
		System.out.println(withdraw(50.00, 100.00));
		}catch (OverdraftException e){
			System.out.println(e.getMessage());
			
		}
		
		
		
		
		
		
		
		
		//made a File within readme variable
		File readMe = new File("/Users/maxwagner/readme.txt");
		System.out.println(readMe.exists());
		
		
		//passing File Object into the Scanner. This is a Try-With Resources
		try(Scanner input = new Scanner(readMe)){
			//while loop occurs if input has another line.
			while(input.hasNextLine()){
				//line is now the next line that the "while loop" went thru.
				String line = input.nextLine();
				//now it prints this line
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Your file doesn't exist.");
			e.printStackTrace();
		}
		
		
		
		
		System.out.println("Done.");
	}

	
	
	
	
	
	
	
	
	
	
	
	public static int[] getArray() {
		int[] nums = {1, 2, 3};
//		try{
			nums[1] = 42;
			nums[2] = 18;
			nums[0] = 4;
//		} catch(ArrayIndexOutOfBoundsException ex){
//			System.out.println(ex.getMessage());
//		}
			return nums;
	}
	/* OverdraftException is a "checked exception" (i.e. it is a subclass of java.lang.Exception)
	 * so we need to either catch it or declare that it is thrown.  This method declares that 
	 * it can throw an OverdraftException using the "throws" keyword */
	public static double withdraw(double currentBalance, double amountToWithdraw) throws OverdraftException {
		double newBalance;
		if(amountToWithdraw <= currentBalance) {
			newBalance = currentBalance - amountToWithdraw;
		} else {
			throw new OverdraftException("The requested withdrawal amount is greater than the current balance", Math.abs(currentBalance - amountToWithdraw));
		}
		return newBalance;		
	}
	
	
}
