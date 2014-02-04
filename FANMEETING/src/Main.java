import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	
	char[] members;
	char[] fans;
	
	public Main(String members, String fans){
		this.members = members.toCharArray();
		this.fans = fans.toCharArray();
	}
	
	public int fullHug(){
		
		List<Integer> pattern = new ArrayList<Integer>();
		for(int i = 0 ; i < members.length ; i++){
			if(members[i] == 'M'){
				pattern.add(i);
			}
		}
		
		int fullHugCount = 0;
		for(int i = 0 ; i < fans.length - members.length + 1 ; i++){
			if(checkFullHug(i, pattern)){
				fullHugCount++;
			}
		}
		return fullHugCount;
	}
	
	private boolean checkFullHug(int index, List<Integer> pattern){
		for(int  i = 0 ; i < pattern.size() ; i++){
			if(fans[index+pattern.get(i)] == 'M'){
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String args[]) throws FileNotFoundException{
		//Scanner in = new Scanner(new File("test.txt"));
		Scanner in = new Scanner(System.in);
		int testCase = in.nextInt();
		for(int i = 0 ; i < testCase ; i++){
			String members = in.next();
			String fans = in.next();
			Main main = new Main(members, fans);
			System.out.println(main.fullHug());
		}
		
	}

}
