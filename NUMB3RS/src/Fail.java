/**
 * 잘 동작하긴 하나, 시간 조건을 만족하지 못
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
 
public class Fail {


	public static class NUMB3RS {
		
		private int town[][];
		private Double cache[][][];
		
		public NUMB3RS(int town[][]){
			this.town = town;		
			cache = new Double[50][50][100];
		}
		
		public double getProbability(int start, int end, int days){
			if(days == 0){
				if(start != end){
					return 0;
				}
				return 1;
			}
			
			if(cache[start][end][days-1] != null) return cache[start][end][days-1];
			
			int nearTownCount = 0;
			double probablility = 0;
			for(int i = 0 ; i <  town[start].length ; i++){
				if(town[start][i]==1) {
					nearTownCount++;
					probablility = probablility + getProbability(i, end, days-1);
				}
			}
			
			probablility = probablility * 1.0/nearTownCount;
			
			cache[start][end][days-1] = probablility;
			return probablility;
		}
		

	}
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		Date startTime = new Date();
		
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new FileInputStream("test.txt"));
		
		int testCount = in.nextInt();
		
		for(int i = 0 ; i < testCount ; i++){
			int townCount = in.nextInt();
			int days = in.nextInt();
			int start = in.nextInt();
			
			int town[][] = new int[townCount][townCount];
			for(int j = 0 ; j < townCount ; j++){
				for(int x = 0 ; x < townCount ; x++){
					town[j][x] = in.nextInt();
				}
			}
			
			NUMB3RS numb = new NUMB3RS(town);
			
			int endCount = in.nextInt();
			
			int[] end = new int[endCount];
			for(int j = 0 ; j < endCount ; j++){
				end[j] = in.nextInt();
			}	
			
			
			for(int j = 0 ; j < endCount ; j++){
				if(j+1 != endCount){
					System.out.print(Double.parseDouble(String.format("%.8f",  numb.getProbability(start, end[j], days)))+" ");
				}
				else{
					System.out.println(Double.parseDouble(String.format("%.8f",  numb.getProbability(start, end[j], days))));				
				}
			}
		}
		
		Date endTime = new Date();
		System.out.println(endTime.getTime() - startTime.getTime());
	
	}
	
	

}
