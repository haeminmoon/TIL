import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class P0007 {
	
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
			
			List<Map<Character, Integer>> removedWordList = makeRemovedWordList(inputList.get(test_case-1));
			
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
	
	public static String getReomovedWordList(List<Map<Character, Integer>> list) {
		StringBuilder strBuilder = new StringBuilder();
		
		for(Map<Character, Integer> map: list) {		
			for(Character key: map.keySet()) {
				if(map.get(key) == 1) {
					strBuilder.append(key);
				}
			}
			strBuilder.append(" ");
		}
		
		return strBuilder.toString();
	}
	
	public static List<Map<Character, Integer>> makeRemovedWordList(String str) {
		List<Map<Character, Integer>> firstWordList = new ArrayList<>();
		
		String[] strArray = str.split(" ");
		
		for(int i=0; i<strArray.length;i++) {
			Map<Character, Integer> wordMap = new LinkedHashMap<>();
			char[] charArray = strArray[i].toCharArray();
			
			for(int j=0; j<charArray.length; j++) {
				if(!wordMap.containsKey(charArray[j])) 
					wordMap.put(charArray[j], 1);
				else
					wordMap.put(charArray[j], wordMap.get(charArray[j])+1);
			}	
			firstWordList.add(wordMap);
		}
		return firstWordList;
	}
}
