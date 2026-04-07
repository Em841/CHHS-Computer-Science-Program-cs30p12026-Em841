
/*
 * Program:CountVowel
 * Purpose:the purpose of this code is to count how many vowels are in a text
 * field you choose.
 * Author: Eman Abid
 * School:CHHS
 * Course: computer science 4 OB
  */
package Mastery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountVowels {

	public static void main (String[] args) {

		// Declare file-related objects
		File textFile;
	    FileReader in;
	    BufferedReader readFile;

	    // Declare variables for reading and processing text
	    String fileName;
	    String lineInFile, lowercaseText;
	    char letter;

	    // Variable to store total number of vowels
	    int vowelSum = 0;

	    // Create a File object that points to the text file location
	    File textFile1 = new File("C:\\Users\\1100080482\\git\\CHHS-Computer-Science-Program-cs30p12026-Em841\\Chp11\\src\\Mastery\\vowels.txt");

	    /* Count the vowels in the file */
	    try {

	    	// Create a FileReader to read the file
	    	in = new FileReader(textFile1);

	        // Wrap FileReader with BufferedReader for efficient reading
	    	readFile = new BufferedReader(in);

	        // Read the file line by line until there are no more lines
	    	while ((lineInFile = readFile.readLine()) != null) {

	    		// Convert line to lowercase and remove non-letter characters
	    		lowercaseText = lineInFile.toLowerCase().replaceAll("\\W", "");

	    		// Print the cleaned line (for debugging/visibility)
	    		System.out.println(lowercaseText);

	    		// Loop through each character in the line
	    		for (int i = 0; i < lowercaseText.length(); i ++) {

	    			// Get the current character
	    			letter = lowercaseText.charAt(i);

	    			// Check if the character is a vowel
	    			if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {

	    				// Increase vowel count
	    				vowelSum += 1;
	    			}
	    		}
	    	}

	    	// Output the total number of vowels found in the file
	    	System.out.println("There Are " + vowelSum + " Vowel(s) In This File.");

	    	// Close BufferedReader
	    	readFile.close();

	    	// Close FileReader
	    	in.close();
		}

	    // Handle case where file is not found
	    catch (FileNotFoundException e){
	    	System.out.println("File doesn't exist.");
			System.err.println("FileNotFOundException: " + e.getMessage());
		}

	    // Handle general input/output errors
		catch (IOException e) {
			System.out.println("Problem reading file.");
			System.err.println("IOException: " + e.getMessage());
		}
	}

}
/*
 *screen dump 
 * tictactoe
breakaplate
localbank
wordguess
semesteravg
countvowels
There Are 23 Vowel(s) In This File.
*/
 