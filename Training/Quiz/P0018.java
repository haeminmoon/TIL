import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P0018 {
	
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		List<Integer> inputList = generateInputList(T);
		
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			StringBuilder resultBuilder = new StringBuilder();
			
			List<String> parensList = generateParens(inputList.get(test_case-1));
			
			resultBuilder.append(parensList.size());

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(resultBuilder);
		}
	}
	
	public static List<Integer> generateInputList(int T) {
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= T; i++) {
			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
			list.add(n);
		}
		return list;
	}
	
	public static void addParen(List<String> list, int leftRem, int rightRem, char[] str, int count) {
		if(leftRem < 0 || rightRem < leftRem)
			return;
	
		if(leftRem == 0 && rightRem == 0) {
			String s = String.copyValueOf(str);
			list.add(s);
		} else {
			if(leftRem > 0) {
				str[count] = '(';
				addParen(list, leftRem - 1, rightRem, str, count + 1);
			}
			
			if(rightRem > leftRem) {
				str[count] = ')';
				addParen(list, leftRem, rightRem - 1, str, count + 1);
			}
		}
	}
	
	public static List<String> generateParens(int count) {
		char[] str = new char[count * 2];
		List<String> list = new ArrayList<>();
		addParen(list, count, count, str, 0);
		return list;
	}
}
