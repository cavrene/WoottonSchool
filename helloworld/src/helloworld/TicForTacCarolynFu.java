/*Carolyn Fu
 * Programming 1, Turner
 * This program called TicForTac will hard code a square matrix of any power of 2 and check for every single possible way either
 * x or o can win with the existing board. This program will utilize matrices and a lot of for loops to achieve this goal.
 */


package helloworld;

public class TicForTacCarolynFu {

	public static void main (String [] args) {
		//initializing board
		char [][] board = {{'o','o','x','o'}, {'o','x','x','o'},{'x', 'x', 'o', 'x'}, {'o','x','x','o'}};
		
		//printing out board
		for (int rows = 0; rows<board.length; rows++) {
			
			for (int cols = 0; cols<board[0].length; cols++) {
				
				System.out.print(board[rows][cols] + "   ");
			}
			System.out.println("\n");
		}
		
		//checks if one piece/neither piece has won and prints out a statement accordingly
		if (hasWon(board, 'x')) {
			
			System.out.println("X has won!");
		}
		else if (hasWon(board, 'o')) {
			
			System.out.println("O has won!");
		}
		else{
			
			System.out.println("No one has won");
		}
	}

	//rowOff and colOff represent the offset for where to start looking within the board
	public static boolean checkQuad(char[][]board, int rowOff, int colOff, char target){
		
		int half = board.length/2;

		for(int row = 0; row < half; row++){
			
			for(int col = 0; col < half; col++){
				
				if(board[row+rowOff][col+colOff] != target)
					return false;
			}
		}
		return true;
	}
	
	//returns true if the target is found in all 4 corners
	public static boolean checkCorners (char[][] board, char target) {

		int boardEnd = board.length-1;
		if (board[0][0] != target || board[0][boardEnd] != target || board[boardEnd][0] != target || board[boardEnd][boardEnd] != target) {
			return false;
		}
		
		return true;
	}
	
	//returns true if the target is found in every location of the provided column
	public static boolean checkRow (char [][] board, int row,  char target) {
		
		//iterates through all columns of one row
		for (int cols = 0; cols<board.length; cols++) {
			
			//if the selected element is not target - the target has not won using this method
			if (board[row][cols]!= target){
				return false;
			}
		}
		return true;
	}
	
	//Returns true if the target is found in every location if the provided column
	public static boolean checkCol (char [][] board, int col, char target) {
		
		//iterates through all rows of one column
		for (int rows = 0; rows<board.length; rows++) {
			
			//if the selected element is not target - the target has not won using this method
			if (board[rows][col]!= target){
				return false;
			}
		}
		return true;
	}
	
	//Returns true if the target is found in every location of the forward major diagonal
	public static boolean checkForwardDiag (char [][] board, char target) {
			
		//iterates through both rows and columns simeltaneously
		for (int rowCol = 0; rowCol<board.length; rowCol++) {
			
			//if the selected element is not target - the target has not won using this method
			if (board[rowCol][rowCol] != target) {
				return false;
			}
		}
		return true;
	}
	
	//returns ture if the target is found in every location of the backwards major diagonal
	public static boolean checkBackDiag (char[][] board, char target) {
		
		//iterates through both rows and columns simeltaneously
		for (int rowCol = 0; rowCol<board.length; rowCol++) {
			
			//if the selected element is not target - the target has not won using this method
			if (board[board.length-1-rowCol][rowCol] != target) {
				return false;
			}
		}
		return true;
	}
	
	//Examines all quadrants, and returns true if the target is found in any of the four quadrants of teh board
	public static boolean allQuads (char[][] board, char target) {
		
		int halfLoc = board.length/2;
		
		//iterates through the whole matrix in sequence of half the matrix (iterates through the quadrants)
		for (int row=0; row<=halfLoc; row = row+halfLoc) {
			
			for (int col = 0; col<=halfLoc; col = col+halfLoc) {
				
				//if the selected quadrant has the target in all spaces
				if (checkQuad (board, row, col, target)) {
					return true;
				}
			}
		}
		return false;
	}	
	
	//Returns true if the target has won the game
	public static boolean hasWon (char[][] board, char target) {
		
		//checking for wins with functions that don't require to iterate through matrix
		if (allQuads(board, target) || checkForwardDiag(board,target) || checkBackDiag(board, target) || checkCorners (board, target)){
			return true;
		}
		//checking for wins with functions that do require to iterate through matrix
		for (int rowCol = 0; rowCol <board.length; rowCol ++) {
			if (checkRow(board, rowCol, target) || checkCol(board, rowCol, target)) {
				return true;
			}
		}
		return false;
	}
}