import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

	boolean[][] board;
	boolean[][][] blocks;
	
	public Main(boolean[][] board, boolean[][] block){
		this.board = board;
		//1. 4개의 블록 타임을 미리 초기화 (비트 처리로 빠르게 비교가 가능하지 않을까?)
		blocks = new boolean[4][][];
		for(int i = 0 ; i < blocks.length ; i++){
			blocks[i] = block;
			// block을 90도 회전
			boolean[][] newBlock = new boolean[block[0].length][block.length];
			for(int n = 0 ; n < block.length ; n++){
				for(int m = 0; m < block[n].length ; m++){
					newBlock[block[0].length-1-m][n] = block[n][m];
				}
			}
			block = newBlock;
		}		
	}
	
	public int solve(){
		int result = 0 ;
		for(int y = 0 ; y < board.length; y++){
			for(int x = 0 ; x < board[y].length ; x++){
				if(board[y][x] == true){
					for(int i = 0 ; i < blocks.length ; i++){
						int newResult = 0;
						if(put(i, x, y)){
							newResult++;
							result = Math.max(result,newResult + solve());
							pop(i,x,y);
						}
					}
				}
			}
		}
		
		return result;
	}
	
	
	private boolean put(int type, int x, int y){
		boolean[][] block = blocks[type];
		if(y + block.length > board.length || x + block[0].length > board[0].length) return false;
		
		for(int i = 0 ; i < block.length ; i++){
			for(int j = 0 ; j < block[i].length ; j++){
				if(block[i][j] == false){
					if(board[y+i][x+j] == false){
						return false;
					}
				}	
			}
		}
		
		for(int i = 0 ; i < block.length ; i++){
			for(int j = 0 ; j < block[i].length ; j++){
				if(block[i][j] == false){
					if(board[y+i][x+j] == true){
						board[y+i][x+j] = false;
					}
				}	
			}
		}
		
		return true;
	}
	
	private void pop(int type, int x, int y){
		boolean[][] block = blocks[type];
		for(int i = 0 ; i < block.length ; i++){
			for(int j = 0 ; j < block[i].length ; j++){
				if(block[i][j] == false){
					board[y+i][x+j] = true;
				}
			}
		}
	}
	
	private void printBlocks(){
		for(int i = 0 ; i < blocks.length ; i++){
			printBlock(blocks[i]);
		}
	}
	
	private void printBlock(boolean[][] block){
		for(int i = 0 ; i < block.length; i++){
			for(int j = 0 ; j < block[i].length ; j++){
				if(block[i][j]==true) System.out.print(".");
				else System.out.print("#");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String args[]) throws FileNotFoundException{
		
		Scanner in = new Scanner(new File("test.txt"));
		
		int testCount = in.nextInt();
		
		for(int i = 0 ; i < testCount; i++){
			
			int boardHeight = in.nextInt();
			int boardWidth = in.nextInt();
			int blockHeight = in.nextInt();
			int blockWidth = in.nextInt();
			in.nextLine();
			
			boolean[][] board = new boolean[boardHeight][boardWidth];
			
			for(int j = 0 ; j < boardHeight ; j++){
				String line = in.nextLine();
				for(int n = 0 ; n < line.length() ; n++){
					if(line.charAt(n) == '#'){
						board[j][n] = false;
					}
					else{
						board[j][n] = true;
					}
				}
			}
			
			boolean[][] block = new boolean[blockHeight][blockWidth];
			
			for(int j = 0 ; j < blockHeight ; j++){
				String line = in.nextLine();
				
				for(int n = 0 ; n < line.length() ; n++){
					if(line.charAt(n) == '#'){
						block[j][n] = false;
					}
					else{
						block[j][n] = true;
					}
				}
			}
			
			
			Main main = new Main(board, block);
			System.out.println(main.solve());
			
		}
	}
}
