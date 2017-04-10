import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2009 {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		List<List<Integer>> inputList = generateInputList(T, sc);
		
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			StringBuilder resultBuilder = new StringBuilder();
			
			resultBuilder.append(efficientLargestSum(inputList.get(test_case-1)));
	
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(resultBuilder);
		}
	}
	
	public static List<List<Integer>> generateInputList(int T, Scanner sc) {
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 1; i <= T; i++) {
			List<Integer> numList = makeNumList(sc);
			list.add(numList);
		}
		return list;
	}

	public static List<Integer> makeNumList(Scanner sc) {
		int N = sc.nextInt();
		sc.nextLine();
		
		List<Integer> numList = new ArrayList<>();
		String[] numStr = sc.nextLine().split(" ");
		
		if(numStr.length != N)
			 throw new ArrayIndexOutOfBoundsException("error");
		
		for(int i = 0 ; i < numStr.length ; i++) {
			numList.add(Integer.valueOf(numStr[i]));
		}	
		return numList;
	}
	
	public static int efficientLargestSum(List<Integer> numList) {
		int sum = 0;
		int ret = 0;
		
		for(int i=0; i<numList.size(); i++) {
			sum = Math.max(sum, 0) + numList.get(i);
			ret = Math.max(sum, ret);
		}	
		return ret;
	}
}

