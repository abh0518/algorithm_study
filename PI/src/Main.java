import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	
	static class Pi {

		int[] numbers;
		int[] resultCache;
		
		public Pi(int[] numbers){
			this.numbers = numbers;
			resultCache = new int[numbers.length];
			Arrays.fill(resultCache, -1);
		}
		
		public int start(){
			return find(0);
		}
		
		private int find(int start){
			if( start >= numbers.length ) return 0;
			if(resultCache[start] != -1) return resultCache[start];
			
			int result = 987654321;
			int remains = numbers.length - start;
			
			if(remains <= 2 ){
				result = 987654321;
			}
			else{
				for(int i = 2 ; i < 5 ; i++){
					int end = start+i;
					if(end < numbers.length){
						int score = score(start, end) + find(end+1);
						result = Math.min(result, score);
					}
				}
				
			}
			
			resultCache[start] = result;
			return resultCache[start];
		}
		
		private int score(int start, int end){
			if (isRepeat(start,end)){
				return 1;
			}
			else if(isOneProgression(start, end)){
				return 2;
			}
			else if(isRotation(start,end)){
				return 4;
			}
			else if(isNProgression(start, end)){
				return 5;
			}
			return 10;
		}
		
		private boolean isRepeat(int start, int end){
			for(int i = start ; i <= end ; i++ ){
				 if (numbers[i] != numbers[start] ){
					 return false;
				 }
			}
			return true;
		}
		
		private boolean isOneProgression(int start, int end){
			int n = numbers[start+1] - numbers[start];
			if(Math.abs(n) != 1) return false;
			for(int i = start+1 ; i <= end ; i++ ){
				if (numbers[i] != numbers[i-1] + n ){
					return false;
				}
			}
			return true;
		}
		
		private boolean isRotation(int start, int end){
			for(int i = start; i <= end ; i=i+2){
				if (numbers[i] != numbers[start]){
				    return false;
				}
			}
			for(int i = start+1; i <= end ; i=i+2){
				if (numbers[i] != numbers[start+1]){
				    return false;
				}
			}
			return true;
		}
		
		private boolean isNProgression(int start, int end){
			int n = numbers[start+1] - numbers[start];
			if (n == 0) return false;
			for(int i = start+1 ; i <= end ; i++ ){
				if (numbers[i] != numbers[i-1] + n ){
					 return false;
				}
			}
			return true;
		}	
	}

	
	public static void main(String args[]) throws IOException{
			Scanner in = new Scanner(System.in);
			//Scanner in = new Scanner(new File("test.txt"));
			
			int count = in.nextInt();
			in.nextLine();
			int[] result = new int[count];
			for(int i = 0 ; i < count ; i++){
				String data_str = in.nextLine();
				int data[] = new int[data_str.length()];
				
				for(int j = 0 ;j < data.length ; j++){
					data[j] = Character.getNumericValue(data_str.charAt(j));
				}
				
				result[i] = new Pi(data).start();
				System.out.println(result[i]);
			}	
			
//			for(int i = 0 ; i < result.length ; i++){
//				System.out.println(result[i]);	
//			}
	}

	
	
}
