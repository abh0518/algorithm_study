import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KaratsubaByList {
	
	public static void main(String args[]){
		int[] a0 = {1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7};
		int[] b0 = {1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6};
		System.out.println( Arrays.toString(Karatsuba.multiply(a0 ,b0)));
		System.out.println( Arrays.toString(Karatsuba.karatsuba(a0 ,b0)));
		
//		List<Integer> a1 = Arrays.asList(1,1);
//		List<Integer> b1 = Arrays.asList(1,1);
//		System.out.println(KaratsubaByList.add(a1, b1, 0));
//		System.out.println(KaratsubaByList.add(a1, b1, 1));
//		System.out.println(KaratsubaByList.add(a1, b1, 2));
//		System.out.println(KaratsubaByList.add(a1, b1, 3));
//		System.out.println(KaratsubaByList.add(a1, b1, 4));		
//		System.out.println(KaratsubaByList.add(a1, b1, 5));
//		
//		System.out.println();
//		
		
//		List<Integer> a2 = Arrays.asList(1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4,1,4,3,6,8,3,6,7,8,9,2,3,2,2,3,5,4,3,2,3,5,4,3,2,5,4);
//		List<Integer> b2 = Arrays.asList(3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5,3,6,5,2,8,9,5,0,1,5,2,4,6,7,2,3,5,4,3,2,3,5,4,5);
//		
		List<Integer> a2 = Arrays.asList(1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7);
		List<Integer> b2 = Arrays.asList(1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6);
		
		
		System.out.println( KaratsubaByList.multiply(a2, b2));
		System.out.println( KaratsubaByList.karatsuba(a2 ,b2));

		
		
	}
	
	/**
	 * 큰 수의 자릿수를 정리한다.
	 * @param num
	 * @return
	 */
	private static List<Integer> normalize(List<Integer> num){
		for(int i = 0 ; i < num.size()-1 ; i++){
			if(num.get(i) < 0){
				int borrow = (Math.abs(num.get(i)) + 9) / 10;
				num.set(i+1, num.get(i+1) - borrow);
				num.set(i, num.get(i) + borrow * 10);
			}
			else{
				num.set(i+1, num.get(i+1) + num.get(i)/10);
				num.set(i, num.get(i)%10);
			}
		}
		while(!num.isEmpty() && num.get(num.size()-1) == 0 ) num.remove(num.size()-1);
		return num;
	}
		
	/**
	 * 두 큰 수를 곱한다. O(n^2)
	 * @param a
	 * @param b
	 * @return
	 */
	public static List<Integer> multiply(List<Integer> a, List<Integer> b){
		List<Integer> result = new ArrayList<Integer>();
		int resultSize = a.size() + b.size();
		for(int i = 0 ; i < resultSize ; i++) result.add(0);
		for(int indexA = 0 ; indexA < a.size() ; indexA++){
			for( int indexB = 0 ; indexB < b.size() ; indexB++) {
				result.set(indexA + indexB, result.get(indexA + indexB) + a.get(indexA) * b.get(indexB) );
			}
		}	
		return normalize(result);
	}
	
	/**
	 * 두 큰수를 더한다. k는 b의 자릿수  
	 * @param a
	 * @param b
	 * @param k
	 * @return
	 */
	private static List<Integer> add(List<Integer> a, List<Integer> b, int k){
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 0 ; i < a.size() && i < k ; i++) result.add(a.get(i));
		if( k < a.size()){ //겹치는 부분이 있음 
			for(int i = 0 ; i + k < a.size() && i < b.size() ; i++ ) result.add(a.get(i+k) + b.get(i));
			for(int i = a.size() - k ; i < b.size() ; i++) result.add(b.get(i));
			for(int i = k+b.size() ; i < a.size() ; i++) result.add(a.get(i));
		}
		else{ // 겹치는 부분이 없음 
			for(int i = k - a.size() ; i > 0 ; i--) result.add(0);
			for(int i = 0 ; i < b.size() ; i++) result.add(b.get(i)); 
		}
		return result;
	}
	
	/**
	 * 두 큰수의 뺄셈
	 * @param a
	 * @param b
	 * @return
	 */
	private static List<Integer> sub(List<Integer> a, List<Integer> b){
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 0 ; i < b.size() ; i++)	result.add(a.get(i) - b.get(i));
		for(int i = b.size() ; i < a.size() ; i++)	result.add(a.get(i));
		return result;
	}
	
	public static List<Integer> karatsuba(List<Integer> a, List<Integer> b){
		return karatsuba_real(a, b);
	}
	
	/**
	 * 카라츠바 곱셈
	 * @param a
	 * @param b
	 * @return
	 */
	private static List<Integer> karatsuba_real(List<Integer> a, List<Integer> b){
		if(a.size()< b.size()) karatsuba_real(b, a);
		
		if(a.size() < 50) return multiply(a, b);
		
		//1.a와 b를 반으로 쪼갠다. (a0, a1, b0, b1)
		int half = a.size() / 2;
		
		List<Integer> a0 = a.subList(0,  half);
		List<Integer> a1 = a.subList(half, a.size());
		List<Integer> b0 = b.subList(0, Math.min(b.size(), half)); 
		List<Integer> b1 = ( b.size() > half ) ? b.subList(half, b.size()) : new ArrayList<Integer>();;
		
		// a1 * b1 = z2를 구한다	
		List<Integer> z2 = karatsuba_real(a1, b1);
		
		// a0 * b0 = z0 을 구한다
		List<Integer> z0 = karatsuba_real(a0, b0);
		
		// z1의 전단계를 구한다
		List<Integer> z1 = karatsuba_real(add(a0, a1, 0),add(b0, b1, 0));

		// z1에서 z0과 z2를 빼서 최종 z1을 구한다
		z1 = sub(z1 , z0);
		z1 = sub(z1 , z2);
		
		// z2 * 전체 자릿수 + z1 * 반자릿수 + z0 을 구한다
		List<Integer> result = add(z0 , z2, half*2);
		result = add(result , z1, half);
		return normalize(result);
	}
	
}

