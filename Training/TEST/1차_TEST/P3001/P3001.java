//샘플 가이드 코드입니다. 본인의 코드를 사용하셔도 됩니다.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//사용하는 클래스명은 Problem ID 이어야 합니다.
class P3001 {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		List<Integer> inputList = generateInputList(T, sc);
		
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			StringBuilder resultBuilder = new StringBuilder();
			
			resultBuilder.append(convertToBinary(inputList.get(test_case-1))).append(" ");
			resultBuilder.append(convertToOctal(inputList.get(test_case-1))).append(" ");
			resultBuilder.append(convertToHexa(inputList.get(test_case-1)));
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
	
	public static String convertToBinary(int n) {
		StringBuilder strBuilder = new StringBuilder();
		
		do {
			strBuilder.append(n%2);
			n /= 2; 
		}while(n > 1);
		
		if(n != 0)
			strBuilder.append(n);
		
		return strBuilder.reverse().append("(2)").toString();
	}
	
	public static String convertToOctal(int n) {
		StringBuilder strBuilder = new StringBuilder();
		
		do {
			strBuilder.append(n%8);
			n /= 8; 
		}while(n > 1);
		
		if(n != 0)
			strBuilder.append(n);
		
		return strBuilder.reverse().append("(8)").toString();
	}
	
	public static String convertToHexa(int n) {
		StringBuilder strBuilder = new StringBuilder();
		char[] HexaMappingArray = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		
		do {
			strBuilder.append(HexaMappingArray[n%16]);
			n /= 16; 
		}while(n > 1);
		
		if(n != 0)
			strBuilder.append(n);
		
		return strBuilder.reverse().append("(16)").toString();
	}
} 

