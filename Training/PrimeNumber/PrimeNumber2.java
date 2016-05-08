import java.util.Scanner;

/* Print prime number list */
public class PrimeNumber2 {

	public static void main(String[] args) {
		int inputNum;
		Scanner sc = new Scanner(System.in);
		inputNum=sc.nextInt();
		
		printPrimeNumber(inputNum);
	}
	
	public static void printPrimeNumber(int num) {		
		boolean isPrimeNumber;
		
		for(int i=2; i<=num; i++) {
			isPrimeNumber=true;
			
			for(int j=2; j<=(int)Math.sqrt(i); j++ ) {
				if(i%j==0) {
					isPrimeNumber=false;
					break;
				}
			}
			if(isPrimeNumber)
				System.out.print(i + " ");
		}
	}
}


