import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P0003 {

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		List<Integer> inputList = generateInputList(T);
		
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			StringBuilder resultBuilder = new StringBuilder();
			
			resultBuilder.append(countThree(inputList.get(test_case-1)));
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
	
	public static int countThree(int n) {
		int countedThree = 0;
		int temp = 0;
		
		for(int i = 0; i <= n; i++) {
			temp = i;
			while(temp > 0) {
				if(temp % 10 == 3)
					countedThree++;
				
				temp/=10;
			}
		}
		return countedThree;
	}
}
