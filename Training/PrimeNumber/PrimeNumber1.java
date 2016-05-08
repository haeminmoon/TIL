import java.util.Scanner;

/* Distinguish prime number */
public class PrimeNumber {

	public static void main(String[] args) {
		int inputNum;
		Scanner sc = new Scanner(System.in);
		inputNum=sc.nextInt();
		
		if(distinguishPrimeNumber(inputNum))
			System.out.println(inputNum + " is prime number.");
		else
			System.out.println(inputNum + " is not prime number");
	}
	
	public static boolean distinguishPrimeNumber(int num) {		
		/*Time complexity - O(n)*/
//		for(int i=2; i<=num; i++) {
//			if(num%i == 0) {
//				return false;
//			}
//		}
//		
//		/*Time complexity - O(n/2)*/
//		for(int i=2; i<=num/2; i++) {
//			if(num%i == 0) {
//				return false;
//			}
//		}
		
		/*Time complexity - is less than O(n/2)*/
		for(int i=2; i<=(int)Math.sqrt(num); i++) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}
}


