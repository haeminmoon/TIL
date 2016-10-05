
public class IsPowerOfTwo {

	public static void main(String[] args) {
		final int n = 32;
		
		System.out.println(checkPowerOfTwo(n));
	}
	
	public static boolean checkPowerOfTwo(int n) {
		return ((n & (n-1))==0) && (n != 0);
	}

}
