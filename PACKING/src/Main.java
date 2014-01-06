import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	private String[] luggage;
	private int size[];
	private int need[];
	private Integer cache[][];
	
	public Main(String[] luggage, int size[], int need[]){
		this.luggage = luggage;
		this.size = size;
		this.need = need;
	}
	
	public boolean[] pack(int backSize){
		cache = new Integer[luggage.length][backSize+1];
		boolean[] result = new boolean[luggage.length];
		Arrays.fill(result, false);
		track(0,backSize,result);
		return result;
	}
    
	
	private void track(int index, int remainSize, boolean[] selectList){
		if(index == luggage.length) return;
		
		int nonSelectResult = pack(index+1, remainSize);
		if(remainSize - size[index] >= 0 ){
			int selectResult = need[index] + pack(index+1, remainSize-size[index]);
			if(selectResult > nonSelectResult){
				selectList[index] = true;
				remainSize -= size[index];
			}
		}
		
		track(index+1, remainSize, selectList);
	}
	
	private int pack(int index, int remainSize){
		if(index == luggage.length) return 0;
		if(cache[index][remainSize] != null) return cache[index][remainSize];
		
		//index를 선택하지 않은 경우
		int result = pack(index+1, remainSize);
		
		//index를 선택한 경우
		if ( remainSize - size[index] >= 0 ){
			result = Math.max(result, need[index] + pack(index+1, remainSize-size[index]));
		}
		
		cache[index][remainSize] = result;
		return result;
	}
    
	public static void testHard() throws FileNotFoundException{
        Date start = new Date();
        Scanner in = new Scanner(new File("test_hard.txt"));
        
        int luggageCount = in.nextInt();
        int backSize = in.nextInt();
        
        String[] luggageName = new String[luggageCount];
        int[] size = new int[luggageCount];
        int[] need = new int[luggageCount];
        in.nextLine();
        for(int j = 0 ; j < luggageCount ; j++){
            String str = in.nextLine();
            StringTokenizer tk = new StringTokenizer(str," ");
            luggageName[j] = tk.nextToken();
            size[j] = Integer.parseInt(tk.nextToken());
            need[j] = Integer.parseInt(tk.nextToken());
            
        }
        
        for(int i = 0 ; i < 100 ; i++){
            Main main = new Main(luggageName,size,need);
            //				boolean selectList[] = main.pack(backSize);
			
            
        }
        Date end = new Date();
        System.out.println(end.getTime()-start.getTime());
	}
	
	public static void main(String args[]) throws FileNotFoundException{
		
		//testHard();
		//Scanner in = new Scanner(new File("test.txt"));
		Scanner in = new Scanner(System.in);
		
		int testCount = in.nextInt();
		
		for(int i = 0 ; i < testCount ; i++){
			int luggageCount = in.nextInt();
			int backSize = in.nextInt();
			
			String[] luggageName = new String[luggageCount];
			int[] size = new int[luggageCount];
			int[] need = new int[luggageCount];
			in.nextLine();
			for(int j = 0 ; j < luggageCount ; j++){
				String str = in.nextLine();
				StringTokenizer tk = new StringTokenizer(str," ");
				luggageName[j] = tk.nextToken();
				size[j] = Integer.parseInt(tk.nextToken());
				need[j] = Integer.parseInt(tk.nextToken());
				
			}
			
			Main main = new Main(luggageName,size,need);
            
			boolean selectList[] = main.pack(backSize);
			
			int needSum = 0;
			int packCount = 0;
			for(int j = 0 ; j < selectList.length ; j++){
				if(selectList[j] == true) {
					needSum += need[j];
					packCount++;
				}
			}
			System.out.println(needSum + " " + packCount);
			
			for(int j = 0 ; j < selectList.length ; j++){
				if(selectList[j] == true) System.out.println(luggageName[j]);
			}
            
		}		
	}
    
}
