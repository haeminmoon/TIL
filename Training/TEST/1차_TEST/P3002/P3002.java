import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P3002 {
	
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		List<Integer> inputList = generateInputList(T, sc);
		
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			StringBuilder resultBuilder = new StringBuilder();
			
			resultBuilder.append(countFactZeros(inputList.get(test_case-1)));

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(resultBuilder);
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

	public static int countFactZeros(int n) {
		int count = 0;
		if(n < 0) {
			return -1;
		}
		for (int i= 5; n / i> 0; i*=5) {
			count += n / i;
		}
		
		return count;
	}

}
