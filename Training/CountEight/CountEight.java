
public class CountEight {

	public static void main(String[] args) {
		int n = 30;

		System.out.println(countingEight(n));
	}
	
	public static int countingEight(int n) {
		int count = 0;
		int temp = 0;
		
		for(int i=1; i <= n; i++) {
			temp = i;
			while(temp > 0) {
				if(temp % 10 == 8)
					count++;
				temp/=10;
			}
		}
		
		return count;
	}

}
