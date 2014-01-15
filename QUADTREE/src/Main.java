import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	public String upsideDown(String quadTree){
		return upsideDown(quadTree,0);
	}
	
	private String upsideDown(String quadTree, int index){
		
		char ch = quadTree.charAt(index);
		
		if(ch=='x'){
			String LT = upsideDown(quadTree, ++index);
			index += LT.length();
			String RT = upsideDown(quadTree, index);
			index += RT.length();
			String LD = upsideDown(quadTree, index);
			index += LD.length();
			String RD = upsideDown(quadTree, index);
			return "x"+LD+RD+LT+RT;
		}
		else{
			return Character.toString(ch);
		}
	}
	
	
	public static void main(String args[]) throws FileNotFoundException{
		
		//Scanner in = new Scanner(new File("test.txt"));
		Scanner in = new Scanner(System.in);
		
		int testCount = in.nextInt();
		Main main = new Main();
		for( int i = 0 ; i < testCount ; i++){
			String str = in.next();
			System.out.println(main.upsideDown(str));
		}
		
		
	}

}
