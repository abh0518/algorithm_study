import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Packing {
	
	private String[] luggage;
	private int size[];
	private int need[];
	private boolean cache[][][];
	
	public Packing(String[] luggage, int size[], int need[]){
		this.luggage = luggage;
		this.size = size;
		this.need = need;
	}
	
	public String getKey(boolean[] selectList, int remainSize){
		return remainSize+"";
	}
	
	public boolean[] pack(int backSize){
		this.cache = new boolean[luggage.length][backSize+1][];
		boolean[] selectList = new boolean[luggage.length];
		Arrays.fill(selectList, false);
		return pack( 0, backSize, selectList);
	}
	
	/**
	 * select 
	 * @param curSelectList
	 * @param select
	 * @param remainSize
	 * @return
	 */
	public boolean[] pack(int select, int remainSize, boolean[] selectList){
		if(select == luggage.length) {
			return selectList;
		}
		if(cache[select][remainSize] != null) return cache[select][remainSize]; 
		
		boolean[] result = pack(select+1, remainSize, Arrays.copyOf(selectList, selectList.length));
		
		if( remainSize >= size[select] ){
			boolean[] nSelectList = Arrays.copyOf(selectList, selectList.length);
			nSelectList[select] = true;
			nSelectList = pack(select+1, remainSize-size[select], nSelectList);
			result = maxResult(result, nSelectList);
		}
		
		cache[select][remainSize] = result;
		return result;
	}
	
	private boolean[] maxResult(boolean[] result, boolean[] nSelect){
		int resultSum = 0;
		for(int i = 0 ; i < result.length ; i++){
			if(result[i] == true) resultSum += need[i];
		}
		int nSelectSum = 0;
		for(int i = 0 ; i < nSelect.length ; i++){
			if(nSelect[i] == true) nSelectSum += need[i];
		}
		return resultSum >= nSelectSum ? result : nSelect; 
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
				Packing main = new Packing(luggageName,size,need);
				boolean selectList[] = main.pack(backSize);
			
		
			}
			Date end = new Date();
			System.out.println(end.getTime()-start.getTime());
	}
	
	public static void main(String args[]) throws FileNotFoundException{
		
		//testHard();
		Scanner in = new Scanner(new File("test.txt"));
		//Scanner in = new Scanner(System.in);
		
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
			
			Packing main = new Packing(luggageName,size,need);
			boolean selectList[] = main.pack(backSize);
			
			int needSum = 0;
			int packCount = 0;
			int sizeSum = 0;
			for(int j = 0 ; j < selectList.length ; j++){
				if(selectList[j] == true) {
					needSum += need[j];
					sizeSum += size[j];
					packCount++;
				}
			}
			System.out.println(needSum + " " + packCount + " " +sizeSum);
			
			for(int j = 0 ; j < selectList.length ; j++){
				if(selectList[j] == true) System.out.println(luggageName[j]);
			}
	
		}		
	}

}
