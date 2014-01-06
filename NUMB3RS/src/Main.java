/**
 * 두니발 박사 탈옥 알고스팟 통과
 * 1. 간당간단하게 통과함
 * 2. 메모이제이션을 쓰는데 다른 해결책과 날리 getProba 메소드를 실행할때마다 메모이제이션 배열을 초기화 해줘여 답이 제대로 나옴
 * 3. 메모이제이션 저장 부분 로직을 뭔가 잘못짠건가? -> 메모이제이션을 잘못하고 있었음, 수정완료, 알고스판 테스트 1초대로 단축 
 * 
 */

import java.io.IOException;
import java.util.Scanner;


public class Main {
	
	private int town[][];
	int[] degree;
	
	private int prison;
	
	private Double cache[][];
	
	public Main(int town[][], int prison){ 
		this.town = town;
		this.prison = prison;
		
		this.degree = new int[town.length];
		for(int i = 0 ; i < town.length ; i++){
			int count = 0 ;
			for(int j = 0 ; j < town[i].length ; j++){
				if(town[i][j] == 1) count++;	
			}
			degree[i] = count;
		}
		
		cache = new Double[50][100];
	}
	
	private double getProbability(int visit, int days){
		
		if(days == 0){
			if(visit != this.prison) return 0;
			return 1;
		}
		
		if(cache[visit][days] != null) return cache[visit][days];
		
		double probablility = 0L;
		for(int i = 0 ; i <  town[visit].length ; i++){
			if(town[visit][i]==1) {
				probablility = probablility + getProbability(i , days-1)/degree[i];
			}
		}
		
		cache[visit][days] = probablility;
		return probablility;
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		
		Scanner in = new Scanner(System.in);
		//Scanner in = new Scanner(new FileInputStream("test.txt"));
		
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
			
			int endCount = in.nextInt();
			
			int[] end = new int[endCount];
			for(int j = 0 ; j < endCount ; j++){
				end[j] = in.nextInt();
			}	
			
			Main numb = new Main(town,start);
			
			for(int j = 0 ; j < endCount ; j++){
				if(j+1 != endCount){
					System.out.print(Double.parseDouble(String.format("%.8f",  numb.getProbability(end[j],days)))+" ");
				}
				else{
					System.out.println(Double.parseDouble(String.format("%.8f",  numb.getProbability(end[j],days))));				
				}
			}
		}
	
	
	}
	

}
	

	
	

