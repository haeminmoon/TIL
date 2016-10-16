
public class countZero {

	public static void main(String[] args) {
		int n = 15;
		
		System.out.println(countFactZeros(n));

	}
	
	public static int countFactZeros(int n) {
		int count = 0;
		if(n < 0) {
			return -1;
		}
		for (int i= 5; n / i> 0; i*=5) {
			count += n / i;
		}
		
		return count;
	}

}
