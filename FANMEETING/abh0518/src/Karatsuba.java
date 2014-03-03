import java.util.Arrays;

public class Karatsuba {
	
	public static void main(String args[]){
		int[] a = {1,4,3,6,8,3,6,7,8,9,2,3,2};
		int[] b = {3,6,5,2,8,9,5,0,1};
		System.out.println( Arrays.toString(Karatsuba.multiply(a, b)));
		System.out.println( Arrays.toString(karatsuba(a ,b)));
	}
	
	/**
	 * 자릿수 처리
	 * @param num
	 * @return
	 */
	private static int[] normalize(int[] num){
		for(int i = 0 ; i < num.length-1 ; i++){
			if(num[i] < 0){
				int borrow = (Math.abs(num[i]) + 9) /10;
				num[i+1] -= borrow;
				num[i] += borrow*10;
			}
			else{
				num[i+1] += num[i] / 10;
				num[i] = num[i] % 10;
			}
		}
		return num;
	}
	
	/**
	 * 두 수의 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int[] multiply(int[] a, int[] b){
		int[] result = new int[a.length + b.length];
		Arrays.fill(result, 0);
		for(int indexA = 0 ; indexA < a.length ; indexA++){
			for( int indexB = 0 ; indexB < b.length ; indexB++) {
				result[indexA + indexB] += a[indexA] * b[indexB];
			}
		}	
		return normalize(result);
	}
	
	/**
	 * 두 큰수의 덧셈 (k는 b의 자릿수)
	 * @param a
	 * @param b
	 * @param k
	 * @return
	 */
	private static int[] add(int[] a, int[] b, int k){
		int[] result = ( b.length + k > a.length) ? new int[b.length + k]: new int[a.length];
		Arrays.fill(result, 0);
		for(int i = 0 ; i < b.length ; i++){
			result[k+i] += b[i];
		}
		for(int i = 0 ; i < a.length ; i++){
			result[i] += a[i];
		}
		return result;
	}
	
	/**
	 * 두 큰수간의 뺄
	 * @param a
	 * @param b
	 * @return
	 */
	private static int[] sub(int[] a, int[] b){
		for(int i = 0 ; i < b.length ; i++){
			a[i] -= b[i];
		}
		return a;
	}
	
	/**
	 * 카라츠바 곱을 끝내고 남은 상위 자릿수 0들을 제
	 * @param num
	 * @return
	 */
	private static int[] cutZero(int[] num){
		int cutPoint = 0;
		for(int i = num.length -1 ; i > -1 ; i--){
			if(num[i] == 0 ) cutPoint++;
			else break;
		}		
		return Arrays.copyOfRange(num, 0, num.length - cutPoint);
	}
	
	public static int[] karatsuba(int[] a, int[]b){
		return cutZero(karatsuba_real(a, b));
	}
	
	/**
	 * 카라츠바 곱셈
	 * @param a
	 * @param b
	 * @return
	 */
	private static int[] karatsuba_real(int[] a, int[] b){
		if(a.length < b.length) karatsuba_real(b, a);
		
		if(a.length < 50) return multiply(a, b);
		
		//1.a와 b를 반으로 쪼갠다. (a0, a1, b0, b1)
		int half = a.length / 2;
		
		int[] a0 = Arrays.copyOfRange(a, 0, half);
		int[] a1 = Arrays.copyOfRange(a, half, a.length);
		int[] b0 = Arrays.copyOfRange(b, 0, Math.min(b.length, half));
		int[] b1 = ( b.length > half ) ? Arrays.copyOfRange(b, half, b.length) : new int[0];
		
		// a1 * b1 = z2를 구한다	
		int[] z2 = karatsuba_real(a1, b1);
		
		// a0 * b0 = z0 을 구한다
		int[] z0 = karatsuba_real(a0, b0);
		
		// z1의 전단계를 구한다
		int[] z1 = karatsuba_real( add(a0, a1, 0) , add(b0, b1, 0) );
		
		// z1에서 z0과 z2를 빼서 최종 z1을 구한다
		z1 = sub(z1 , z0);
		z1 = sub(z1 , z2);
		
		// z2 * 전체 자릿수 + z1 * 반자릿수 + z0 을 구한다
		int[] result = add(z0 , z2,half*2);
		result = add(result , z1,half);
		normalize(result);
		return result;
	}
	
}

