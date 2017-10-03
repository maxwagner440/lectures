package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWriter {

	public static void main(String[] args) {
		//create a file object BEFORE try so you have a handle on it and can put it in the pom.xml AFTER the TRY.
		File writtenPom = new File("pom.xml.1");
		File originalPom = new File("pom.xml");
		try(
			Scanner readPom = new Scanner(originalPom); 
			PrintWriter writePom = new PrintWriter(writtenPom)){
			while(readPom.hasNextLine()){
				String line = readPom.nextLine();
				if(line.contains("<version>1.0</version>")){
					line = line.replace("1.0", "1.5");
				}
				//reading from pom.xml. THEN writing pom.xml to pom.xml.1
				writePom.println(line);
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			//Exits the program if the File was not found
			System.exit(1);
		}

		//move pom.xml.1 to pom.xml
		writtenPom.renameTo(originalPom);
		
	}

}
