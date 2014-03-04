import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	List<Integer> members;
	List<Integer> fans;
	
	public Main(List<Integer> members, List<Integer> fans){
		this.members = members;
		this.fans = fans;
	}
	
	public Main(String members, String fans){
		this.members = new ArrayList<Integer>();
		this.fans = new ArrayList<Integer>();
		for(int i = 0 ; i < members.length() ; i++){
			if(members.charAt(i) == 'M') this.members.add(1);
			else this.members.add(0);
		}
		for(int i = fans.length()-1 ; i >= 0 ; i--){
			if(fans.charAt(i) == 'M') this.fans.add(1);
			else this.fans.add(0);
		}
	}
	
	public int fullHug(){
		int fullHugCount = 0;
		List<Integer> result = KaratsubaByList.karatsuba(this.members, this.fans);
		for(int i = members.size()-1 ; i < result.size() - (members.size()) ; i++){
			if(result.get(i) == 0 ) fullHugCount++;
		}
		return fullHugCount;
	}
	
	public static void main(String args[]) throws FileNotFoundException{
		testHard();
		
		Scanner in = new Scanner(new File("test.txt"));
		//Scanner in = new Scanner(System.in);
		int testCase = in.nextInt();
		for(int i = 0 ; i < testCase ; i++){
			String members = in.next();
			String fans = in.next();
			Main main = new Main(members, fans);
			System.out.println(main.fullHug());
		}
	}
	
	public static void testHard(){
		List<Integer> members = new ArrayList<Integer>();
		List<Integer> fans = new ArrayList<Integer>();
		Random rand = new Random();
		for(int i = 0 ; i < 20000 ; i++){ 
			fans.add(rand.nextInt(2));
		}
		for(int i = 0 ; i < 500 ; i++){
			members.add(rand.nextInt(2));
		}
		
		System.out.println(members);
		System.out.println(fans);
		Main main = new Main(members, fans);
		System.out.println(main.fullHug());
	}
	
	
}
