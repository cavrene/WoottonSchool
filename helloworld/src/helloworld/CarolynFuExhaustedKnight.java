/*Carolyn Fu
 * Computer Programming 2
 * Exhausted KNight
 * This program will utilize arrays, matrices, and the concept of neighborhoods to direct the knight to different positions
 * based on its "L" shape movement path, and this keeps happening until the knight has no spots on the chessboard where it
 * has not yet visited in its neighborhood.
*/

package helloworld;

public class CarolynFuExhaustedKnight {
	
	public static final int[] HORZDISP = {1, 2, 2, 1, -1, -2, -2, -1};
	public static final int[] VERTDISP = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	public static void main (String [] args) {
		
		int [][] board = new int[8][8]; 
		board[0][0] = 1;
		
		//calling functions that will run the knight simulation
		System.out.println("The knight has made " + moveKnight(board, 0, 0) + " moves");
		printBoard(board);
	}
	
	//returns int array that contains all indexes of moves that are possible according to current position in relation to element in HORZDISP and VERTDISP
	public static int[] determineMoves (int [][]board, int currentRow, int currentCol) {
		
		int arrayLen = 0;
		
		//finds the length of returned array based on conditions
		for (int i=0; i<VERTDISP.length; i++) {
			
			int nextRow = currentRow + VERTDISP[i];
			int nextCol = currentCol + HORZDISP[i];
			
			//conditions are: if the next square is off the board or it has already been visited
			if ((nextRow>-1 && nextRow<board.length) && (nextCol>-1 && nextCol < board.length) && board[nextRow][nextCol] == 0) {
				arrayLen++;
			}
		}
		
		//intializing array to the length previously counted
		int [] goodMoves = new int[arrayLen];
		int count = 0;
		
		//add the values we found in the previous loop to the new array
		for (int i=0; i<VERTDISP.length; i++) {
			
			int nextRow = currentRow + VERTDISP[i];
			int nextCol = currentCol + HORZDISP[i];
			
			//same conditions as above
			if ((nextRow>-1 && nextRow<board.length) && (nextCol>-1 && nextCol < board.length) && board[nextRow][nextCol] == 0) {
				goodMoves[count] = i;
				count++;
			}
		}	
		
		return goodMoves;
	}
	
	//void function that prints out the entire board + numbers on teh sides
	public static void printBoard(int [][] board) {
		
		System.out.println("\t\t1\t2\t3\t4\t5\t6\t7\t8\n\n");
		
		//rows of board
		for (int row = 0; row<board.length; row++) {
			
			System.out.print(row+1+"\t\t");
			
			//columns of board
			for (int col = 0; col<board.length; col++) {
				
				System.out.print(board[row][col]+"\t");
			}
			System.out.println("\n");
		}
	}
	
	//returns an integer representing the amount of moves the knight made/num of locations
	public static int moveKnight (int [][] board, int currentRow, int currentCol) {
		
		int[] goodMoves;
		int chosenRow;
		int chosenCol;
		
		//will run until there are no more spaces to visit
		do {
			goodMoves = determineMoves(board, currentRow, currentCol);
		
			//checks if there still are spaces to visit in the board
			if (goodMoves.length != 0) {
				
				//determining the random new square to move to based on array returned from determineMoves
				int	chosenMove = goodMoves[(int)(Math.random()*goodMoves.length)];
				chosenRow = currentRow + VERTDISP[chosenMove];
				chosenCol = currentCol + HORZDISP[chosenMove];
				
				//placing the knight at the new place adn changing the current row and column to the chosenRow
				board[chosenRow][chosenCol] = board[currentRow][currentCol] + 1;
				currentRow = chosenRow;
				currentCol = chosenCol;
			}
			
		}while(goodMoves.length != 0);
		
		return board[currentRow][currentCol];
	}
}