import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P0011 {
	
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		List<Integer> inputList = generateInputList(T, sc);
		
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			StringBuilder resultBuilder = new StringBuilder();
			
			resultBuilder.append(drawTriangle(inputList.get(test_case-1)));

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(replaceLast(resultBuilder.toString(), "\n", ""));
		}
	}
	
	public static List<Integer> generateInputList(int T, Scanner sc) {
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			list.add(n);
		}
		return list;
	}

	public static String drawTriangle(int lineNumber) {
		StringBuilder strBuilder = new StringBuilder();
		
		for (int i = 0; i < lineNumber; i++) {
			StringBuilder tempBuilder = new StringBuilder();
			
			for (int j = 0; j < lineNumber - i; j++) {
				tempBuilder.append(" ");
			}
			
			for (int k = 0; k <= 2 * i; k++) {
				if (k == 0 || 2 * i == k)
					tempBuilder.append("*");
				else
					tempBuilder.append("*");
			}
			
			for(int j = lineNumber + i; j < (lineNumber*2-1); j++)
				tempBuilder.append(" ");
			
			for(int h = 0; h < lineNumber; h++)
				strBuilder.append(tempBuilder.toString());
			
			strBuilder.append("\n");
		}
		
		return strBuilder.toString();
	}
	
	private static String replaceLast(String string, String toReplace, String replacement) {
		int pos = string.lastIndexOf(toReplace);
		if (pos > -1) {
			return string.substring(0, pos) + replacement + string.substring(pos + toReplace.length(), string.length());
		} else {
			return string;
		}
	}
}
