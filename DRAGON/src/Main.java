import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	private static String S="FX";
	private static String X="X+YF";
	private static String Y="FX-Y";
	private Long cache[][]; 
	
	int getType(String str){
		if(str.equals(S)) return 0;
		else if(str.equals(X)) return 1;
		else return 2;
	}
	
	String curve(int generation, int p, int l){
		cache = new Long[generation+1][3];
		StringBuffer curve = new StringBuffer();
		curve(generation, Main.S, 0, curve, p, l);
		return curve.toString();
	}
	
	void curve(int remain, String partition,long curLength, StringBuffer curve, long p, long l){
		if(remain == 0) {
			for(int i = 0 ; i < partition.length() ; i++){
				curLength += 1;
				if( p <= curLength && curLength < p+l){
					curve.append(partition.charAt(i));
				}
			}
			return;
		}
		
		for(int i=0 ; i< partition.length() ; i++){
			char token = partition.charAt(i);
			long nextLength = 0;
			if(token == 'X' ){
				nextLength = curLength + size(remain-1,Main.X);
				if( nextLength >= p && curLength < p+l){
					curve(remain-1, Main.X, curLength, curve, p, l);
				}
				curLength = nextLength;
			}
			else if( token == 'Y' ){	
				nextLength = curLength + size(remain-1,Main.Y);
				if( nextLength >= p && curLength < p+l){
					curve(remain-1, Main.Y, curLength, curve, p, l);
				}
				curLength = nextLength;
			}
			else{
				curLength += 1;
				if( p <= curLength && curLength < p+l){
					curve.append(token);
				}
			}
		}
	}
	
	private long size(int remain, String parent){
		if(remain == 0) return parent.length();
		
		if(cache[remain][getType(parent)]!=null) return cache[remain][getType(parent)]; 
		
		long length = 0;
		
		for(int i=0 ; i< parent.length() ; i++){
			char token = parent.charAt(i);
			if(token == 'X'){
				length += size(remain-1, Main.X);
			}
			else if(token == 'Y'){
				length += size(remain-1, Main.Y);
			}
			else{
				length += 1;
			}
		}
		
		cache[remain][getType(parent)] = length;
		
		return length;
	}
	
	public static void main(String args[]) throws FileNotFoundException{
		
		//Scanner in = new Scanner(new File("test.txt"));
		Scanner in = new Scanner(System.in);
		
		int testCount = in.nextInt();
		
		for(int i = 0 ; i < testCount ; i++){
			int generation = in.nextInt();
			int p = in.nextInt();
			int l = in.nextInt();
			Main main = new Main();
			System.out.println(main.curve(generation, p, l));
		}
		
	}

}
