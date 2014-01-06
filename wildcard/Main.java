import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static class Wildcard {

		String pattern;
		String str;
		Boolean cache[][]; 
		
		public Wildcard(String pattern, String str){
			this.pattern = pattern;
			this.str = str;
			cache = new Boolean[pattern.length()+1][str.length()+1];
		}
		
		public boolean match(){
			return match(0,0);
		}
		
		private boolean match(int patternIndex, int strIndex){
			if (cache[patternIndex][strIndex] != null) return cache[patternIndex][strIndex];
				
			int patternIndexBack = patternIndex;
			int strIndexBack = strIndex;
			
			boolean result = true;
			while(patternIndex < pattern.length() & result){
				char patternChar = pattern.charAt(patternIndex);
				
				if(patternChar == '*'){
					boolean childResult = false;
					childResult = childResult | match(patternIndex+1 , strIndex);
					if(strIndex < str.length()){
						childResult = childResult | match(patternIndex+1 , strIndex+1);
						childResult = childResult | match(patternIndex , strIndex+1);
					}
					result = childResult;
					patternIndex = pattern.length();
					strIndex = str.length();
					break;
				}
				else {
					if(strIndex < str.length()){
						char strChar = str.charAt(strIndex);
						if(patternChar != '?' && patternChar != strChar){
							result = false;
						}
					}
					else{
						result = false;
					}
				}
				patternIndex++;
				strIndex++;
			}
			
			result = result & patternIndex == pattern.length() & strIndex == str.length();
			
			cache[patternIndexBack][strIndexBack] = result;
			return result;
		}
	}
	
	
	public static void test(){
		System.out.println(new Wildcard("*aafddsa*fdsafas*fdsa??fasd","fdsafsafsasfsafsafgewgweagffdsfsafaswef234rfweafasdfsafgsagsafasfsadgfasdfgasfgds").match());
		System.out.println(new Wildcard("*","a").match());
		System.out.println(new Wildcard("*abc***","abc").match());
		System.out.println(new Wildcard("?","").match());
		System.out.println(new Wildcard("***?","a").match());
		
		System.out.println(new Wildcard("he?p","help").match());
		System.out.println(new Wildcard("he?p","heap").match());
		System.out.println(new Wildcard("he?p","helpp").match());
		
		System.out.println(new Wildcard("*p*","help").match());
		System.out.println(new Wildcard("*p*","papa").match());
		System.out.println(new Wildcard("*p*","hello").match());
	}
	
	public static void main() throws NumberFormatException, IOException{
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int patternCount = Integer.parseInt(reader.readLine());
		for (int i = 0 ; i < patternCount ; i++){
			String pattern = reader.readLine();
			
			int stringCount = Integer.parseInt(reader.readLine());
			
			ArrayList<String> resultList = new ArrayList<String>();
			for(int j = 0 ; j < stringCount ; j++){
				String str = reader.readLine();
				Wildcard wc = new Wildcard(pattern, str);
				if(wc.match()){
					resultList.add( str);
				}
			}
			
			String[] result = new String[resultList.size()];
			result = resultList.toArray(result);
			
			Arrays.sort(result, new Comparator<String>(){
				@Override
				public int compare(String arg0, String arg1) {
					return arg0.compareTo(arg1);
				}
				
			});
			
			for(String str : result){
				System.out.println(str);
			}
			
			
		}
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		//test();
		main();
	}

}
