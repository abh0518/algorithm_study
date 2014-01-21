import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
	
	private int[] fence;
	
	public Main(int[] fence){
		this.fence = fence;
	}
	
	public int solve(){
		int max = 0;
		
		for(int i = 0 ; i < fence.length ; i++){
			int minHeight = fence[i];
			for(int j = i ; j < fence.length ; j++){
				int width = j-i+1;
				minHeight = Math.min(fence[j], minHeight);
				max = Math.max(minHeight * width, max);
			}			
		}
		
		return max;
	}
	
	
	public static void main(String args[]) throws FileNotFoundException{
		
		//Scanner in = new Scanner(new File("test.txt"));
		Scanner in = new Scanner(System.in);
		
		int testCase = in.nextInt();
		
		for(int i = 0 ; i < testCase ;i++){
			
			int boardCount = in.nextInt();
			int[] fence = new int[boardCount];
			
			for(int j = 0 ; j < boardCount ; j++){
				fence[j] = in.nextInt();
			}
			Main main = new Main(fence);
			System.out.println(main.solve());
			
		}
		
	}
}
