import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
	
	Boolean cache[][][];
	char[][] wordBoard;
	
	public Main(char[][] wordBoard){
		this.wordBoard = wordBoard;
	}
	
	public boolean find(String str){
		cache = new Boolean[5][5][str.length()+1];
		boolean result = false;
		char[] word = str.toCharArray();
		for(int i = 0 ; i < wordBoard.length && result==false; i++){
			for( int j = 0 ; j < wordBoard[i].length ; j++){
				result = find(word, 0 ,i,j ) || result;
			}
		}
		return result;
	}	
	
	private boolean find(char[] word, int index, int x, int y){
		if(x < 0 || x == wordBoard.length || y < 0 || y == wordBoard.length) return false;
		if(cache[x][y][index] != null) return cache[x][y][index];
		
		boolean result = false;
		if(wordBoard[x][y]==word[index]){
			if(index+1 < word.length) {
				for(int i = x-1 ; i < x+2 ; i++){
					for(int j = y-1 ; j < y+2 ; j++){
						if( !(i==x && y==j) ){
							result = find(word, index+1, i,j) || result;
						}
					}
				}
			}
			else{
				result=true;
			}
		}
		cache[x][y][index] = result;
		return result;
	}
	
	public static void main(String args[]) throws FileNotFoundException{
				
		//Scanner in = new Scanner(new File("test.txt"));
		Scanner in = new Scanner(System.in);
		int testCase = in.nextInt();
		
		for(int i = 0 ; i < testCase; i++){
			
			char[][] board = new char[5][5];
			for(int j = 0 ; j < board.length ; j++){
				String str = in.next();
				board[j] = str.toCharArray();
			}
			
			Main main = new Main(board);
			
			int wordCount = in.nextInt();
			for(int j = 0 ; j < wordCount ; j++){
				String word = in.next();
				System.out.println(word + " " + (main.find(word) ? "YES" : "NO") );
				
			}
		}
		
	}

}
