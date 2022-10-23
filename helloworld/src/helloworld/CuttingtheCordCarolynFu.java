/*
 Carolyn Fu
 Turner Computer Programming 2
 This program called Cutting the Cord will take in user input about how much they want to pay, what genre they prefer, and the PG rating of content to give them the optimal streaming service. The program accomplishes this by recieving user input on these preferences and uses a chain of if-else to give the user the optimal streaming service output. 
 */

package helloworld;
import java.util.*;

public class CuttingtheCordCarolynFu {

	public static void main(String[] args) {
		
		//declaraing scanner to read user input
		Scanner keyboard = new Scanner (System.in);
		
		//asking user for their preferred pay amount
		System.out.print("Do you want to pay less than $9 a month? (yes/no)");
		String payInput = keyboard.nextLine();
		
		//asking user for their preferred genre
		System.out.print("What genre do you prefer? (drama/animated/sports)");
		String genreInput = keyboard.nextLine();
		
		//asking user for their preferred pg rating
		System.out.print("Do you prefer family friendly content? (yes/no)");
		String pgInput = keyboard.nextLine();
		
		//if else chain that chooses inputs based on preferences of genre and pg rating	
		
		//genre is animated
		if (genreInput.equals("animated")) {
			//if they want it to be family friendly
			if (pgInput.equals("yes")) {
				System.out.println("You should subscribe to the \"Disney Plus\" streaming service");
			}
			else {
				System.out.println("You should subscribe to the \"Crunchy Roll\" streaming service");
			}
		}
		//genre is sports
		else if (genreInput.equals("sports")){
			//if they want it to be family friendly
			if (pgInput.equals("yes")) {
				System.out.println("You should subscribe to the \"ESPN\" streaming service");
			}
			else {
				System.out.println("You should subscribe to the \"WWE Network\" streaming service");
			}
		}
		//genre is drama
		else if (genreInput.equals("drama")){
			//if they want it to be family friendly
			if (pgInput.equals("yes")) {
				System.out.println("You should subscribe to the \"Hulu\" streaming service");
			}
			else {
				System.out.println("You should subscribe to the \"Netflix\" streaming service");
			}
		}
	}
}
