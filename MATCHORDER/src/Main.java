import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	
	private int[] rTeam;
	private int[] kTeam;
	
	public Main( int[] rTeam, int []kTeam){
		this.rTeam = rTeam;
		this.kTeam = kTeam;
		Arrays.sort(this.rTeam);
		Arrays.sort(this.kTeam);
	}
	
	public int getMaxWinCount(){
		int searchIndex = 0;
		int winCount = 0 ;
		for(int i = 0 ; i < rTeam.length && searchIndex < kTeam.length; i++){
			int matchIndex = getMatch(searchIndex, kTeam.length-1, this.rTeam[i]);
			if(kTeam[matchIndex] >= rTeam[i]){
				winCount++;
				searchIndex = matchIndex+1;
			}
		}
		return winCount;
	}
	
	public int getMatch(int startIndex, int lastIndex, int rRating){
		if(startIndex == lastIndex) return lastIndex;
		int middle = (startIndex + lastIndex)/2;
		if(kTeam[middle] >= rRating){
			return getMatch(startIndex, middle, rRating);
		}
		else{
			return getMatch(middle+1, lastIndex, rRating);
		}
	}
	
	public static void main(String args[]) throws FileNotFoundException{
		//Scanner in = new Scanner(new File("test.txt"));
		Scanner in = new Scanner(System.in);
		int testCase = in.nextInt();
		
		for(int i = 0 ; i < testCase ; i++){
			
			int entryCount = in.nextInt();
			
			int[][] entrys = new int[2][entryCount];
			
			for(int j = 0 ; j < entrys.length ; j++){
				for(int x = 0 ; x < entryCount ; x++){
					entrys[j][x] = in.nextInt();
				}
			}
			
			Main main = new Main(entrys[0], entrys[1]);
			System.out.println(main.getMaxWinCount());
		}
	}

}
