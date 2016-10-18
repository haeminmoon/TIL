import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P0014 {
	
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		List<String> inputList = generateInputList(T);
		
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			StringBuilder resultBuilder = new StringBuilder();
			String[] array = inputList.get(test_case-1).split(" ");
			int a = Integer.parseInt(array[0]);
			int b = Integer.parseInt(array[1]);
			
			resultBuilder.append(add(a, b));

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
	
	public static int add(int a, int b) {		
		if(b==0)
			return a;
		
		int sum=a^b;
		int carry=(a&b)<<1;
		
		return add(sum, carry);
	}
}
