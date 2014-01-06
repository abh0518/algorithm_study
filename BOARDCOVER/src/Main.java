import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
	
	enum BLOCK_TYPE{
		LTYPE,
		LLTYPE,
		ILTYPE,
		ILLTYPE
	}
	
	boolean[][] board;
	
	public Main(boolean[][] board){
		this.board = board;
	}
	
	public int find(){
		int blockCount=0; 
		for(int i = 0 ; i < board.length ; i++){
			for(int j = 0 ; j < board[0].length ; j++){
				if(board[i][j] == true){
					blockCount++;
				}
			}
		}
		if(blockCount%3 != 0){
			return 0;
		}
		return find(blockCount/3);
	}
	
	private int find(int blockCount){
		if(blockCount == 0){
			return 1;
		}
		
		//좌측 상단부터 무조건 채워나간다.
		int result = 0;
		int[] nextPoint = nextPoint();
		
		if(nextPoint != null ){
			BLOCK_TYPE[] types = BLOCK_TYPE.values();
			for(int i = 0 ; i < types.length ; i++){
				if(fill(nextPoint[0],nextPoint[1],types[i])){
					result += find(blockCount-1);
					unfill(nextPoint[0], nextPoint[1], types[i]);
				}
			}
		}

		return result;
	}
	
	private int[] nextPoint(){
		for(int i = 0 ; i < board.length ; i++){
			for(int j = 0 ; j < board[0].length ; j++){
				if(board[i][j] == true){
					int[] result = {i,j};
					return result;
				}
			}
		}
		return null;
	}
	
	private boolean fill(int h, int w, BLOCK_TYPE type){
		
		if(h+1 == board.length) return false;
		
		switch(type){
		case LTYPE:{
			/*
			 @
			 @ @
			 */
			if( w+1 < board[0].length && board[h][w] && board[h+1][w] && board[h+1][w+1]){
				board[h][w] = false;
				board[h+1][w] = false;
				board[h+1][w+1] = false;
				return true;
			}
			break;
		}
		case LLTYPE:{
			/*
		       @   
		     @ @  
			 */
			if( w > 0 && board[h][w] && board[h+1][w] && board[h+1][w-1] ){
				board[h][w] = false;
				board[h+1][w] = false;
				board[h+1][w-1] = false;
				return true;
			}
			break;
		}
		case ILTYPE:{ 
            /*
             @ @
             @ 
             */
			if(w+1 < board[0].length && board[h][w] && board[h][w+1] && board[h+1][w] ){
				board[h][w] = false;
				board[h][w+1] = false;
				board[h+1][w] = false;
				return true;
			}
			break;
		}
		case ILLTYPE:{ 
            /*
             @ @
               @
             */
			if(w+1 < board[0].length && board[h][w] && board[h][w+1] && board[h+1][w+1] ){
				board[h][w] = false;
				board[h][w+1] = false;
				board[h+1][w+1] = false;
				return true;
			}
			break;
		}
		}
		return false;
	}
	
	private void unfill(int h, int w, BLOCK_TYPE type){
		switch(type){
		case LTYPE:{
			/*
			 @
			 @ @
			 */
			board[h][w] = true;
			board[h+1][w] = true;
			board[h+1][w+1] = true;
			break;
		}
		case LLTYPE:{
			/*
		       @   
		     @ @  
			 */
			board[h][w] = true;
			board[h+1][w] = true;
			board[h+1][w-1] = true;
			break;
		}
		case ILTYPE:{ 
            /*
             @ @
             @ 
             */
			board[h][w] = true;
			board[h][w+1] = true;
			board[h+1][w] = true;
			break;
		}
		case ILLTYPE:{ 
            /*
             @ @
               @
             */
			board[h][w] = true;
			board[h][w+1] = true;
			board[h+1][w+1] = true;
			break;
		}
		}
	}
	
	public static void main(String args[]) throws FileNotFoundException{
		
	    //Scanner in = new Scanner(new File("test.txt"));
	    Scanner in = new Scanner(System.in);
	    int testCase = in.nextInt();
	    
	    for(int i = 0 ; i < testCase ; i++){
	    	
	    	int h = in.nextInt();
	    	int w = in.nextInt();
	    	boolean board[][] = new boolean[h][w];
	    	
	    	for(int j = 0 ; j < h ; j++){
	    		String str = in.next();
	    		for(int x = 0 ; x < w ; x++){
	    			if(str.charAt(x) == '#'){
	    				board[j][x] = false;	
	    			}
	    			else{
	    				board[j][x] = true;
	    			}
	    		}
	    	}
	    	
	    	Main main = new Main(board);
	    	System.out.println(main.find());
	    }
		
		
	}

}
