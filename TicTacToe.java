
import java.util.Scanner;
public class TicTacToe {
	static String[][] board = new String[3][3];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	
		initBoard();
		boolean result =false;
		String mark = "O";
		printBoard();
		System.out.println("Please input like A0, B1, etc.");
		for(int i=0;i<9;i++){
			if(i%2==0){
				mark = "O";
			}
			else
				mark ="X";			
			System.out.print("Player "+mark+" : ");			
			while(true){
				String x=input.nextLine();
				int a = x.charAt(0) - 'A';
				int b = x.charAt(1) - '0';
				if(a>2||b>2||a<0||b<0)
					System.out.print("Invalid input! Please input again: ");
				else if(isEmpty(a,b) ==true){
					setBoard(a, b, mark);
					break;
				}
				else{
					System.out.print("Duplicated input! Please input again: ");
				}
			}
			printBoard();
			result = checkWinner();
			if(result==true){
				String winner = (i%2 == 0) ? "O" : "X";
				System.out.println("The Winner is : "+ winner);
				break;				
			}
		}
		if(result==false){
			System.out.println("Draw!");
		}
	}		
	public static void initBoard(){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				board[i][j]=" ";
			}
		}
	}
	public static boolean isEmpty(int x,int y){
		if(board[x][y].equals(" "))
			return true;
		else
			return false;		
	}
	public static void setBoard(int x, int y, String mark){
		board[x][y]=mark;
	}
	public static void printBoard(){
		System.out.println("    0   1   2  ");
		System.out.println("  +---+---+---+");
		for(int i=0;i<board.length;i++){
			if(i==0) System.out.print("A ");
			else if(i==1) System.out.print("B ");
			else System.out.print("C ");
			for(int j=0;j<board[i].length;j++){
				System.out.print("| "+board[i][j]+" ");				
			}
			System.out.println("|");
			System.out.println("  +---+---+---+");						
		}		
	}
	public static boolean checkWinner(){
		boolean ret =false;
		for(int i=0;i<3;i++){
			if(board[i][0]!=" "&&board[i][0]==board[i][1]&&board[i][0]==board[i][2]) ret = true;
			
			else if(board[0][i]!=" "&&board[0][i]==board[1][i]&&board[0][i]==board[2][i]) ret = true;
		}
		if(board[0][0]!=" "&&board[0][0]==board[1][1]&&board[0][0]==board[2][2]) ret = true;
		else if(board[0][2]!=" "&&board[0][2]==board[1][1]&&board[0][2]==board[2][0]) ret = true;
		
		return ret;
	}
}
