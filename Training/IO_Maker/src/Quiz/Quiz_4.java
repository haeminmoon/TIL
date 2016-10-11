package Quiz;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Quiz_4 {

	public static void main(String[] args) {
		final int n = 1491;
		
		System.out.println(getLargestNum(n));
	}
	
	public static String getLargestNum(int n) {
		StringBuilder largestNum = new StringBuilder();
		char[] charArray = String.valueOf(n).toCharArray();
	
		Arrays.sort(charArray);
		
		for(int i=charArray.length-1; i >= 0; i--) {
			largestNum.append(charArray[i]);
		}
		
		return largestNum.toString();
	}
}
