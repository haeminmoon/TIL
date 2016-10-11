package Quiz;
/*How many count '3' in 100000*/
public class Quiz_3 {

	public static void main(String[] args) {
		final int n = 10000;
		
		System.out.println(countingThree(n));
	}
	
	public static int countingThree(int n) {
		int countedThree = 0;
		int temp = 0;
		
		for(int i = 0; i <= n; i++) {
			temp = i;
			while(temp > 0) {
				if(temp % 10 == 3)
					countedThree++;
				
				temp/=10;
			}
		}
		
		return countedThree;
	}

}
