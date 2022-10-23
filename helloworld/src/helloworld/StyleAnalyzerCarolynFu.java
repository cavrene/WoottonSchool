/*Carolyn Fu
 * Turner Prog 2
 * Style Analyzer
 * This program will make use of arrays and file methods to recieve a file that needs style work and correct the file based on user's choice
 * of matching file and class name, adding vertical spaces when needed, and saving file. */

package helloworld;

import java.util.*;
import java.io.*;

public class StyleAnalyzerCarolynFu {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner (System.in);
		
		String [] file = new String [0];		
		String [] undo = new String[0];

		int userChoice = 0;
		String fileName = "";
		
		//prints out menu until the user's choice is 7 (to exit the program)
		do {
			
			System.out.println("1) Load File \n2) Display File \n3) Save File \n4) File and Class Name Match? \n5) Vertical Spacer \n6) Undo Last Change \n7) Exit");
			
			userChoice = keyboard.nextInt();
			keyboard.nextLine();
			
			//if the user wants to load a file
			if (userChoice==1) {
				
				System.out.println("Enter the file you want to load");
				fileName = keyboard.nextLine();
				
				undo = file;
				
				file = loadFile (fileName);
			}
			//if user wants to print out the file
			else if (userChoice ==2) {
				
				for (int i=0; i<file.length; i++) {
					System.out.println(file[i]);
				}
			}
			//if user wants to save a file
			else if (userChoice == 3) {
				System.out.println("What file would you like to save it to?");
				String saveFileName = keyboard.nextLine();
				
				saveFile(saveFileName, file);
			}
			//if user wants to see if the class and file name match
			else if (userChoice == 4) {
				undo = file;
				match(file, fileName);
			 
			}
			//if user wants to space out program
			else if (userChoice == 5) {
				undo = file;
				file = spacer(file);
			}
			//if user wants to undo last change
			else if (userChoice == 6) {
				file = undo;
			}
		}while (userChoice != 7);
	}
	
	//loads a file into an array in which every element is a line of the file, returns this array
	public static String[] loadFile(String fname) {
		
		Scanner inFile = null;
		String[] file = new String [0];
		
		//try-catch that makes sure file exists
		try {
			inFile = new Scanner (new File (fname));
		}catch (FileNotFoundException e) {
			return file;
		}
		
		//gets the next line in the file
		while(inFile.hasNextLine()) {
			
			file = resize(file, 1);
			file[file.length-1] = inFile.nextLine();;
		}
		
		inFile.close();
		return file;
	}
	
	//prints out all lines in the file out to screen
	public static void displayFile(String[]lines) {
		
		//iterates through every element of array
		for (int i=0; i<lines.length; i++) {
			System.out.println(lines[i]);
		}
	}
	
	//saves the array to a file location designated by fname
	public static void saveFile(String fname, String[] lines) {
		
		//try-catch loop that writes elements of array to file
		try {
			FileWriter outfile = new FileWriter(fname);
			
			for(int i=0; i<lines.length; i++) {
				outfile.write(lines[i] + "\r\n");
			}
			outfile.close();
		}catch(IOException e) {
			System.out.println("IO issue");
			System.exit(-1);
		}
	}
	
	//checks if the name of file matches the name of class, if it doesn't, it changes the class name so that it matches the file name
	public static void match(String []lines, String fname) {
		
		if (fname.equals("")) {
			System.out.println("file name must be provided");
			return;
		}
		
		fname = fname.substring(0, fname.indexOf("."));
		
		//iterates through every element of list
		for (int i=0; i<lines.length; i++) {
			
			int classLoc = lines[i].indexOf("public class");
			
			//checks if the line contains a "public class" and if the user has submitted an appropriate file name
			if (classLoc!=-1) {
	
				//checks if the line contains the file name
				if (lines[i].indexOf(fname)==-1) {	
					
					//changes the 
					System.out.println("class name does not match file name");
					lines[i] = "public class " + fname + " {";
					return;
				}
				else {
					System.out.println("Class name matches file name");
					return;
				}
			}
		}
	}
	
	public static String[] spacer (String[] lines) {
		
		String [] spacedArray = new String [0];
		//int count = 0;
		
		for (int i=0; i<lines.length-1; i++) {
			
			String currentLine = lines[i].trim();
			String nextLine = lines[i+1].trim();
			
			int bracketLoc = currentLine.indexOf("{");
			
			if (bracketLoc!=-1 && bracketLoc!=0 && !(nextLine.equals(""))) {
				
				spacedArray = resize(spacedArray, 2);
								
				//count++;
				spacedArray[spacedArray.length-1] = "";
				spacedArray[spacedArray.length-2] = lines[i];
				
			}
			else {

				spacedArray = resize(spacedArray, 1);
				
				spacedArray[spacedArray.length-1] = lines[i];
			}
			
		}
		
		//adds last line to the array
		spacedArray = resize(spacedArray, 1);
		spacedArray[spacedArray.length-1] = lines[lines.length-1];
		
		return spacedArray;
	}
	
	public static String[] resize(String [] lines, int newLen) {
		
		String[] retLines = new String [lines.length+newLen];
 		
 		for (int i=0; i<lines.length; i++) {
 			retLines[i] = lines[i];
 		}
 		
 		return retLines;
	}
	
}