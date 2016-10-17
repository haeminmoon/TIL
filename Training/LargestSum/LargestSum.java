import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargestSum {
	public static void main(String[] args) {
		List<Integer> numList = makeNumList();
		int LargestSum = efficientLargestSum(numList);

		System.out.println(LargestSum);
	}
	
	public static List<Integer> makeNumList() {
		List<Integer> numList = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		String[] numStr = scan.nextLine().split(" ");
		
		for(int i = 0 ; i < numStr.length ; i++) {
			numList.add(Integer.valueOf(numStr[i]));
		}
		
		return numList;
	}
	
	public static int efficientLargestSum(List<Integer> numList) {
		int sum = 0;
		int ret = 0;
		
		for(int i=0; i<numList.size(); i++) {
			sum = Math.max(sum, 0) + numList.get(i);
			ret = Math.max(sum, ret);
		}	
		return ret;
	}

	/*Other solution*/
	public static int getMaxSum(int[] a) {
		int maxsum = 0;
		int sum=0;
		for(int i = 0; i < a.lenght; i++) {
			sum += a[i];
			if(maxsum < sum) {
				maxsum = sum;
			} else if(sum < 0) {
				sum = 0;
			}
		}
		return maxsum;
	}
}


