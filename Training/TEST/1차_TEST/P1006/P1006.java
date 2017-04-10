import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1006 {
	
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
			
			resultBuilder.append(addOne(inputList.get(test_case-1)));
			
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
	
	public static BigInteger addOne(String strN) {
		BigInteger bigN = new BigInteger(strN);
		return bigN.add(new BigInteger("1"));
	}
}
