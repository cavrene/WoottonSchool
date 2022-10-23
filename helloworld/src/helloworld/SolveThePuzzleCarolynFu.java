/*Carolyn Fu
 * This program is called Solve The Puzzle, in which the user tries to solve a hangman game where a word is hidden, and uses hints in the form of letters to figure out the hangman word.
 * This program utilizes random method on class Math and multiple functions to achieve its goal. 
 */

package helloworld;
import java.util.*;


public class SolveThePuzzleCarolynFu {
		public static void main(String[] args){
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the puzzle: ");
		
		//puzzle will not be modified
		String original = keyboard.nextLine();
		
		//"clears" the screen
		for(int i = 0; i < 20; i++)
			System.out.println();
				
//ADDED CODE--------------------------------------------------------------------------------------------		
		String letters = buildLetterList(original);
		String hidden = buildHidden(original);
		String hintChoice = "";
		int trial = 0;
		
		//runs until either the user wants to try and solve or the whole word has been revealed
		do {
			//user choice for hint
			System.out.println("Solve: " + hidden);
			System.out.println("Would you like a hint? (y/n)");
			hintChoice = keyboard.nextLine();
			
			//if the user wants a hint
			if (hintChoice.equals("y")) {
				
				//revealing hint
				String hintLetter = provideHint(letters);	
				hidden = revealHint(original, hidden, hintLetter);
				trial++;		
				
				int letterPos = letters.indexOf(hintLetter);
				
				//getting rid of the letter just used in the list of letters
				letters = letters.substring(0,letterPos) + letters.substring(letterPos+1);
			}
						
		}while (hintChoice.equals("y")&&!hidden.equals(original));
	
		//if the answer has already been revealed
		if (hidden.equals(original)) {
			System.out.println("The answer: " + hidden);
			System.out.println("You took too long and the program had to spell out the word for you! Try harder");
		}
		//if the user want to try and guess
		else {
			System.out.println("What is the word? ");
			String attempt = keyboard.nextLine();
			
			//if the user guessed right
			if (attempt.equals(original)) {
				System.out.println("You got it! Congrats! It took you " + trial + " hint(s) to get it!");
			}
			//if the user guessed wrong
			else {
				System.out.println("Sorry, you got it wrong.");
			}
		}
	}
	//converts puzzle to new word (ignoring spaces)
	public static String buildHidden(String word){
		//added String Constant		
		String hidden= "";
		for(int i = 0; i < word.length(); i++){
			if(word.substring(i,i+1).equals(" ")) {
				hidden+= " ";
			}
			
			else
				hidden+= "_";
		}
		
		return hidden;
			
	}
	
	//Printing out the letters according to given hint
	public static String revealHint(String original, String hidden, String hintLetter) {
		
		//loops through every letter of hidden
		for (int i=0; i<hidden.length(); i++) {
			String currentLetter = original.substring(i,i+1);
			
			//if the current letter (lowercase) is the hint
			if (currentLetter.toLowerCase().equals(hintLetter)) {
				hidden = hidden.substring(0,i) + currentLetter + hidden.substring(i+1);
			}
		}
		return hidden;
	}
	
	//will computer a random number then return the character at that point
	public static String provideHint (String letterList) {

		//generates random number and return the 
		int randomNum = (int)(Math.random()*letterList.length());
		return letterList.substring(randomNum, randomNum+1);
	}
	
	//makes and returns a list of all letters in the word
	public static String buildLetterList (String word) {
		
		String letterList= "";
		
		//for loop that loops through the entire word
		for(int i = 0; i < word.length(); i++){
			String currentLetter = word.substring(i,i+1).toLowerCase();
			
			//if the list of letters does no contain current letter and its not a space
			if(letterList.indexOf(currentLetter) == -1 && !currentLetter.equals(" ")) {
				letterList+= currentLetter;
			}
		}
		return letterList;
	}
}