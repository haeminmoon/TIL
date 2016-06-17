import java.util.Arrays;
import java.util.Scanner;

public class BiggestFamilyNum {
	public static void main(String[] args) {
		String num = getUserInput();
		System.out.println(getBiggestFamilyNum(num));
	}
	
	public static String getUserInput() {
		Scanner scan = new Scanner(System.in);
		String num = scan.nextLine();
		return num;
	}
	
	public static char[] getBiggestFamilyNum(String num) {
		char[] splitArray = num.toCharArray();
		Arrays.sort(splitArray);
		
		for(int i=0; i<splitArray.length/2; i++) {
			char temp = splitArray[i];
			splitArray[i] = splitArray[splitArray.length - 1 - i];
			splitArray[splitArray.length - 1 - i] = temp;
		}
		return splitArray;
	}
}
