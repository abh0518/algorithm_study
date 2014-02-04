import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	private int[] fence;
	
	public Main(int[] fence){
		this.fence = fence;
	}
	
	public int solve(){
		return solve(0,fence.length-1);
	}
	
	private int solve(int head, int last){
		if(head==last) return fence[head];
		
		//문제를 쪼갠다!
		int middle = (head+last)/2;
		int max = Math.max(solve(head,middle),solve(middle+1,last));
		
		//쪼개에 얻은 결과와 중간 펜스를 기준으로 구한 max와 다시 비교...
		max = Math.max(getMaxArea(head,last, middle), max);
		
		return max; 
	}
	
	private int getMaxArea(int head, int last, int select){
		
		int minHeight = Math.min(fence[select], fence[select+1]); 
		int max = minHeight * 2;
		int left = select-1;
		int right = select+2;
		
		//select 기준점으로 좌우로 높이가 큰 펜스부터 하나씩 찾아가야하는데 아오 귀찮다 대충 짜자...
		while( head <= left || right <= last){
			int selectedHeight = 987654321;
			
			if( left < head && right <= last){
				selectedHeight=fence[right];
				right++;
			}
			else if( head <= left && last < right ){
				selectedHeight=fence[left];
				left--;
			}
			else{
				//큰쪽부터 골라서 비
				if(fence[left] > fence[right]){
					selectedHeight=fence[left];
					left--;
				}
				else{
					selectedHeight=fence[right];
					right++;
				}
			}
			
			minHeight = Math.min(minHeight, selectedHeight);
			max = Math.max(max, (right-left-1) * minHeight);
		}
		
			
		return max;
    }
	
	
	public static void hardTest(){
		
		int fence[] = new int[20000];
		Random rand = new Random();
		for(int i = 0 ; i < fence.length ; i ++){
			fence[i] = Math.abs(rand.nextInt(9999)+1);
		}
		
		Main main = new Main(fence);
		
		System.out.println(main.solve());
		
		
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
		
//		Date start = new Date();
//		for(int i = 0 ; i < 50; i++){
//			Main.hardTest();
//		}		
//		Date end = new Date();
//		
//		System.out.println(end.getTime() - start.getTime());
	}
}
