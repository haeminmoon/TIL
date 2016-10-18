import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Convert String "345" to Integer "345"*/
public class P0002 {
	
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		List<String> inputList = generateInputList(T);
		
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			StringBuilder resultBuilder = new StringBuilder();
			
			resultBuilder.append(converToInteger(inputList.get(test_case-1))+1);
			
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
	
	public static Integer converToInteger(String strN) {
		char[] charArray = strN.toCharArray();
		Integer N = 0;

		for (char c : charArray) {
			N = (N * 10) + ((int) c - (int) '0');
		}
		return N;
	}
}
