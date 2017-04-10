import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2001 {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		List<Integer> inputList = generateInputList(T, sc);
		
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			StringBuilder resultBuilder = new StringBuilder();
			
			resultBuilder.append(convertToKorean(inputList.get(test_case-1)));
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
	
	public static String convertToKorean(int n) {
		StringBuilder convertedKorean = new StringBuilder();
		List<Integer> numberList = generateNumberList(n);
		
		final String[] ONE = {"", "일", "이","삼","사","오","육","칠","팔","구"}; 
		final String[] TEN1 = {"천", "" , "십", "백"};
		final String[] TEN2 = {"", "만"};
		
		int chipher = numberList.size();
		int chipCount = 0;
		int chipTemp = 1;
		
		for(int i  = 0; i < numberList.size(); i++, chipher--) {

			if(numberList.get(i) != 0 && numberList.get(i) != 1) {
				convertedKorean.append(ONE[numberList.get(i)]);
				convertedKorean.append(TEN1[chipher%4]);			
			}else if(numberList.get(i) == 1){
				if(chipher%4 == 1) {
					convertedKorean.append(ONE[numberList.get(i)]);
					convertedKorean.append(TEN1[chipher%4]);	
				} else {
					convertedKorean.append(TEN1[chipher%4]);
				}
			}

			if((chipher/4 > 0) && chipher%4 == 1) {
				chipTemp = chipher/4;		
				convertedKorean.append(TEN2[chipTemp]+" ");
			}	
		}
	
		return convertedKorean.toString();
	}
	
	public static List<Integer> generateNumberList(int n) {
		List<Integer> list = new ArrayList<>();
		String[] tempArray = String.valueOf(n).split("");
		
		for(String s: tempArray) {list.add(Integer.parseInt(s));}
		
		return list;
	}
}
