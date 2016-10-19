import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P0016 {
	
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
			String[] array = inputList.get(test_case-1).split(" ");
			int a = Integer.parseInt(array[0]);
			int b = Integer.parseInt(array[1]);
			
			resultBuilder.append(minus(a, b)).append("(minus) ");
			resultBuilder.append(multiply(a, b)).append("(multiply) ");
			resultBuilder.append(divide(a, b)).append("(divide)");

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
	
	public static int negate(int a) {
		int neg = 0;
		int d = a < 0 ? 1: -1;
		while(a!=0) {
			neg += d;
			a += d;
		}
		return neg;
	}
	
	public static int minus(int a, int b) {
		return a + negate(b);
	}

	public static int multiply(int a, int b) {
		if(a<b) {
			return multiply(b, a);
		}
		
		int sum = 0;
		for(int i = Math.abs(b); i > 0; i--) {
			sum += a;
		}
		if(b < 0) {
			sum = negate(sum);
		}
		return sum;
	}
	
	public static int abs(int a) {
		if(a<0) {
			return negate(a);
		} else {
			return a;
		}
	}
	
	public static int divide(int a, int b) { 
		int absa = abs(a);
		int absb = abs(b);
		
		int product = 0;
		int x = 0;
		while(product + absb <= absa) {
			product += absb;
			x++;
		}
		
		if((a<0 && b<0) || (a>0 && b>0)) {
			return x;
		} else {
			return negate(x);
		}
	}
}
