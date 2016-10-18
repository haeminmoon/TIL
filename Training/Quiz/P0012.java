import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P0012 {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		List<String> inputList = generateInputList(T);
		
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			StringBuilder resultBuilder = new StringBuilder();
			String s1 = "Welcome to Hanwha S&C";
			String s2 = inputList.get(test_case-1);
			
			resultBuilder.append(getDistance(s1, s2));

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(resultBuilder);
		}
	}
	
	public static List<String> generateInputList(int T) {
		List<String> list = new ArrayList<>();
		for(int i = 1; i <= T; i++) {
			Scanner scan = new Scanner(System.in);
			String s = scan.nextLine();
			list.add(s);
		}
		return list;
	}

	private static int getDistance(String s1, String s2) {
		int longStrLen = s1.length() + 1;
		int shortStrLen = s2.length() + 1;

		int[] cost = new int[longStrLen];
		int[] newcost = new int[longStrLen];

		for (int i = 0; i < longStrLen; i++) {
			cost[i] = i;
		}

		for (int j = 1; j < shortStrLen; j++) {

			newcost[0] = j;

			for (int i = 1; i < longStrLen; i++) {

				int match = 0;

				if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
					match = 1;
				}

				int replace = cost[i - 1] + match;
				int insert = cost[i] + 1;
				int delete = newcost[i - 1] + 1;

				newcost[i] = Math.min(Math.min(insert, delete), replace);
			}

			int[] temp = cost;
			cost = newcost;
			newcost = temp;
		}

		return cost[longStrLen - 1];
	}
}
