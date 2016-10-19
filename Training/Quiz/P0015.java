import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class P0015 {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		sc.nextLine();
		List<String> inputList = generateInputList(T, sc);
		
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			StringBuilder resultBuilder = new StringBuilder();
			
			resultBuilder.append(checkString(inputList.get(test_case-1)));

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(resultBuilder);
		}
	}
	
	public static List<String> generateInputList(int T, Scanner sc) {
		List<String> list = new ArrayList<>();
		for(int i = 1; i <= T; i++) {
			String s = sc.nextLine();
			list.add(s);
		}
		return list;
	}

	public static String checkString(String input) {
		StringBuilder strBuilder = new StringBuilder();
		
		if (input.length() >= 50 || input.length() <= 2) {
			strBuilder.append("false");
		}
		
		if (isMatch(input)) {
			strBuilder.append("true");
		} else {
			strBuilder.append("false");
		}
		
		return strBuilder.toString();
	}

	public static boolean isMatch(String input) {
		Stack<Integer> stackH = new Stack<>();
		Stack<Integer> stackW = new Stack<>();
		
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == 'H') {
				if (stackW.isEmpty()) {
					stackW.push(i);
				} else {
					if (stackH.isEmpty()) {
						stackW.pop();
					} else {
						int compareIndexM = stackH.peek();
						int compareIndexT = stackW.peek();
						if (compareIndexT > compareIndexM || i < compareIndexM) {
							stackW.pop();
						}
					}
				}
			} else {
				if (stackH.isEmpty()) {
					stackH.push(i);
				} else {
					if (stackW.isEmpty()) {
						stackH.pop();
					} else {
						int compareIndexT = stackW.peek();
						int compareIndexM = stackH.peek();
						if (compareIndexM > compareIndexT || i < compareIndexT) {
							stackH.pop();
						}

					}
				}
			}
		}

		return (stackH.isEmpty() && stackW.isEmpty());
	}
}
