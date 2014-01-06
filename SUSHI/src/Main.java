import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class Main {
	
	private int price[];
	private int preference[];
	private int cache[];
	
	public Main(int price[], int preference[]){
		this.price = price;
		this.preference = preference;
	}
	
	
	public int eat(int budget){
		cache = new int[budget+1];
		Arrays.fill(cache, -1);
		
		return eat(0,budget);
	}
	
	private int eat(int select, int remainBudget){
		if(select == price.length)	{
			return 0 ;
		}
		
		if(cache[remainBudget] != -1) return cache[remainBudget]; 
		
		int result = 0;
		int nextBudget = remainBudget + price[select];
		int curPref = 0;
		while(nextBudget > 0){
			nextBudget = nextBudget - price[select]; 
			if(nextBudget >= 0 ){
				int pref = curPref + eat(select+1, nextBudget);
				result = Math.max(result,  pref);	
			}
			curPref += preference[select];
		}

		cache[remainBudget] = result;
		return result;
	}
	
	public static void main(String ags[]) throws FileNotFoundException{
		
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("test.txt"));
		
		int testCase = in.nextInt();
		
		for(int i = 0 ; i < testCase; i++){
			
			int kindOfSushi = in.nextInt();
			int budget = in.nextInt();
			
			int price[] = new int[kindOfSushi];
			int preference[] = new int[kindOfSushi];
			
			for(int j = 0 ; j < kindOfSushi; j++){
				price[j] = in.nextInt()/100;
				preference[j] = in.nextInt();
			}
			
			Main main = new Main(price, preference);
			Date start = new Date();
			System.out.println(main.eat(budget/100));
			Date end = new Date();
			System.out.println(end.getTime() - start.getTime());
		}
		
		in.close();
	}
	
	

}
