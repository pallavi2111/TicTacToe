import java.util.Scanner;

class TicTacToe{
	static char[][] board;//declare the board
	
	public TicTacToe(){
		board = new char[3][3];//assign a value
		initBoard();//initialize a board
	}
	
	void initBoard() {//initialization method
		
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j] = ' ';
			}
		}
		
	}
	
	static void dispBoard() {//display of board method
		System.out.println("-------------");
		for(int i=0;i<board.length;i++) {
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j] +" | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
		
	}
	
	static void placeMark(int row,int col,char mark) { //to place the mark 'X' or 'O' by the player in correct postion otherwise it will return invalid position
		if(row>=0 && row<=2 && col>=0 && col<=2) {
			board[row][col] = mark;
		}
		else {
			System.out.println("Invalid Position");
		}
	}
	static boolean checkColWin() { //to check column wise win
		for(int j=0;j<=2;j++) {
			if(board[0][j] != ' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j]) {
				return true;
			}
		}		
		return false;
	}
	static boolean checkRowWin() { //to check row wise win
		for(int i=0;i<=2;i++) {
			if(board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2] ) {
				return true;
			}
		}
		
		return false;
	}
	static boolean checkDiagWin() { //to check diagonal win
		if(board[0][0] !=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2] || board[0][2] !=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0] ) {
			return true;
		}
		return false;
	}
	
	}
class HumanPlayer{
	String name;
	char mark;
	
	HumanPlayer(String name,char mark){
		this.name = name;
		this.mark = mark;
			}
	
	void makeMove() { //to make move by human player
		Scanner scan = new Scanner(System.in);
		int row;
		int col;
		do {
			System.out.println("Enter the number of row and column:");
			row = scan.nextInt();//taking row & column from user 
			col = scan.nextInt();
		}while(!isValidMove(row, col));//checking is the move valid or not
		TicTacToe.placeMark(row, col, mark);
		
	}
	boolean isValidMove(int row,int col) { // to check move is valid or not
		if(row>=0 && row<=2 && col>=0 && col<=2) {
			if(TicTacToe.board[row][col] == ' ') {
				return true;
			}
			
		}
		return false;
		
	}
}
public class LaunchGame{

	public static void main(String[] args) {
		
		TicTacToe t1 = new TicTacToe();
		HumanPlayer p1 = new HumanPlayer("Pallavi", 'X');
		HumanPlayer p2 = new HumanPlayer("Khushi", 'O');
		
		HumanPlayer cp;//here cp is the reference variable
		cp = p1;//assigning value of p1 to the cp
		while(true) {
			System.out.println(cp.name +" turns:");
			cp.makeMove();
			TicTacToe.dispBoard();
			if(TicTacToe.checkRowWin() || TicTacToe.checkColWin() || TicTacToe.checkDiagWin()) {
				System.out.println(cp.name +" won the game:)");
				break;
			}
			else {
				if(cp == p1) {//checking if the cp is reference variable of p1 or not
					cp = p2;//if cp is reference variable of p1 then on next move it will change to p2
				}
				else {
					cp = p1;//and if cp is not the reference variable of p1 then it will change to p1
				}
			}
		}

	}

}
