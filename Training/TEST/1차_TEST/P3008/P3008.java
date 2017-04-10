import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class P3008 {
	
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
			
			Map<Character, Integer> removedWordList = makeRemovedWordMap(inputList.get(test_case-1));
			
			resultBuilder.append(getReomovedWordList(removedWordList));

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
	
	public static String getReomovedWordList(Map<Character, Integer> map) {
		StringBuilder strBuilder = new StringBuilder();

		for (Character key : map.keySet()) {
			if (map.get(key) == 1) {strBuilder.append(key);}
		}

		return strBuilder.toString();
	}
	
	public static Map<Character, Integer> makeRemovedWordMap(String str) {
		Map<Character, Integer> wordMap = new LinkedHashMap<>();

		char[] charArray = str.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			if (!wordMap.containsKey(charArray[i]))
				wordMap.put(charArray[i], 1);
			else
				wordMap.put(charArray[i], wordMap.get(charArray[i]) + 1);
		}
		return wordMap;
	}
}
