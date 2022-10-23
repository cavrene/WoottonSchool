/*
 Carolyn Fu
 Turner Computer Programming 2
 This program called Igpay Atinlay will take user input as a sentence and convert it to pig latin. This function utilizes mutliple string methods to complete this task. 
*/

// i am in the cloud

package helloworld;
import java.util.*;

public class PigLatin {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner (System.in);
		
		//getting user input for the phrase
		System.out.println("Enter phrase");
		String input = keyboard.nextLine();
		
		//turning phrase into pig latin
		String result = phraseToPig(input);
		
		//printing out results
		System.out.println(result);
	}
	
	//checks if the word is capitalized, returns true if so
	public static boolean isCapitalized (String word) {
		
		//taking the first letter and turning it into capitalized version
		String firstLetter = word.substring(0,1);
		String firstLetterCap = firstLetter.toUpperCase();
		
		//checking if the capitalized first letter is the regular first letter, if so then it must be true
		if (firstLetter.equals(firstLetterCap)) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	//capitalizes the first letter, returns capitalized word
	public static String capitalize (String word) {
		
		//get the first letter of word and make it uppercase
		String firstLetter = word.substring(0,1);
		firstLetter = firstLetter.toUpperCase();
		
		//return the new word with capitalization
		return firstLetter + word.substring(1);
	}
	
	//returns index of first vowel (all 10), returns -1 if no vowels are used
	public static int hasAVowel(String word) {
		
		word = word.toLowerCase();
		
		for (int i=0; i<word.length(); i++) {
			
			String current = word.substring(i, i+1);
			
			if (current.equals("a")||current.equals("i")||current.equals("e")||current.equals("o")||current.equals("u")) {
				return i;
			}
		}
		
		return -1;

	}
	
	//converts a word to pig latin
	public static String wordToPig(String english) {
		// MOM's code
		//int vowIndex = hasAVowel(english);

		//there are no vowels in the word or the vowel is at the beginning of the word
		if (hasAVowel(english) == -1 || hasAVowel(english) == 0) {
			return english + "-ay";
		}
		
		//there are vowels in the word
		else{
			
			//intiailizing variables for first part until vowel and second part from vowel to end
			String firstHalf = english.substring(0, hasAVowel(english));
			String secondHalf = english.substring(hasAVowel(english));	
			
			//the word is capitalized
			if (isCapitalized(english)) {
				
				//turn the first half to lowercase
				String letterFirst = firstHalf.substring(0,1);
				letterFirst = letterFirst.toLowerCase();
				firstHalf = letterFirst + firstHalf.substring(1);
				
				//make the second half uppercase
				secondHalf = capitalize(secondHalf);
				
			}
			//return final word
			return secondHalf + "-" + firstHalf + "ay";
		}
		
	}
	
	//converts a phrase to pig latin
	public static String phraseToPig(String phrase) {
		
		//splitting the phrase into words
		String [] words = phrase.split(" ");
		
		//initializing the final phrase string
		String finalPhrase = "";
		
		//loops through the list
		for (int i=0; i< words.length; i++) {
			
			//making the word pig latin
			String pigWord = wordToPig(words[i]);
			//adding the new word to the final phrase + space
			finalPhrase += pigWord + " ";
		}
		
		//return final phrase
		return finalPhrase;

	}
	
}
