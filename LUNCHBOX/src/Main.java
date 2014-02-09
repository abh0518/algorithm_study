import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	private class LunchSet {
		int heatingTime;
		int eatingTime;
		
		public LunchSet(int heatTime, int eatTime){
			this.heatingTime = heatTime;
			this.eatingTime = eatTime;
		}
		
		@Override
		public String toString(){
			return this.heatingTime+":"+this.eatingTime;
		}
	}
	
	LunchSet[] lunchSet;
	
	public Main(int[] heatTime, int[] eatTime){
		lunchSet = new LunchSet[heatTime.length];
		for(int i = 0 ; i < heatTime.length ; i++){
			lunchSet[i] = new LunchSet(heatTime[i], eatTime[i]);
		}
	}
	
	public int fastEat(){
		Arrays.sort(lunchSet, new Comparator<LunchSet>(){
			@Override
			public int compare(LunchSet frontSet, LunchSet lastSet) {
				if(frontSet.eatingTime < lastSet.eatingTime) return 1;
				else if(frontSet.eatingTime > lastSet.eatingTime) return -1;
				else return 0;
			}
		});
		int totalTime = 0;
		int remainTime = 0; 
		for(int i = 0 ; i < lunchSet.length ; i++){
			totalTime += lunchSet[i].heatingTime;
			if(lunchSet[i].eatingTime + lunchSet[i].heatingTime < remainTime){
				remainTime = remainTime - lunchSet[i].heatingTime;
			}
			else{
				remainTime = lunchSet[i].eatingTime;
			}
		}	
		totalTime += remainTime;
		return totalTime;
	}
			
	public static void testHard(){
		for(int t = 0 ; t < 50 ; t++){
			int[] heatingTimes = new int[10000];
			int[] eatingTimes = new int[10000];
			Random rand = new Random();
			for(int i = 0 ; i < heatingTimes.length ; i++){
				heatingTimes[i] = rand.nextInt(999)+1;
				eatingTimes[i] = rand.nextInt(999)+1;
			}
			
			Main main = new Main(heatingTimes, eatingTimes);
			System.out.println(main.fastEat());
		}
	}
	
	public static void main(String args[]) throws FileNotFoundException{
		//Main.testHard();
		//Scanner in = new Scanner(new File("test.txt"));
		Scanner in = new Scanner(System.in);
		int testCase = in.nextInt();
		for(int i = 0 ; i < testCase ; i ++){
			int lunchCount = in.nextInt();
			int lunchSet[][] = new int[2][lunchCount];
			
			for(int j = 0 ; j < 2 ; j++){
				for(int c = 0 ; c < lunchCount ; c++){
					lunchSet[j][c] = in.nextInt();
				}
			}
			
			Main main = new Main(lunchSet[0], lunchSet[1]);
			System.out.println(main.fastEat());
		}	
	}
}
