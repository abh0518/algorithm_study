import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class MagicTrick {

	int cards[][];
	
	public MagicTrick(int choiceCount){
		cards = new int[choiceCount][];
	}
	
	public void addChoice(int index, int[] cards){
		this.cards[index] = cards;
	}
	
	public String solve(){
		Set<Integer> temp = new HashSet<Integer>();
		for(int i = 0 ; i < cards[0].length ; i++){
			temp.add(cards[0][i]);
		}
		
		Set<Integer> result = null;
		for(int i = 1 ; i < cards.length ; i++){
			result = new HashSet<Integer>();
			for(int j = 0 ; j < cards[i].length ; j++){
				if(temp.contains(cards[i][j])){
					result.add(cards[i][j]);
				}
			}
			temp = result;	
		}
		
		int size = result.size();
		if(size == 1) return String.valueOf((Integer)result.toArray()[0]);
		if(size > 1) return "Bad magician!";
		return "Volunteer cheated!";
	}
	
	public static void main(String args[]) throws IOException{
		
		//Scanner in = new Scanner(new File("test.txt"));
		Scanner in = new Scanner(new File("A-small-practice.in"));
		FileWriter out = new FileWriter(new File("result.txt"));
		
		int testCount = in.nextInt();
		
		for(int i = 0 ; i < testCount ; i++){
			MagicTrick trick = new MagicTrick(2);
			
			for(int j = 0 ; j < 2 ;j++){
				int selectedRow = in.nextInt()-1;
				int cards[][] = new int[4][4];
				
				for(int n = 0 ; n < 4 ; n++){
					for(int m = 0 ; m < 4 ; m++){
						cards[n][m] = in.nextInt();
					}
				}
			
				trick.addChoice(j, cards[selectedRow]);
			}
			
			System.out.println("Case #" + (i+1) + ": " + trick.solve());
			out.append("Case #" + (i+1) + ": " + trick.solve() + "\n");
		}
		
		out.flush();
		out.close();
		
	}
}
