import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.stream.util.StreamReaderDelegate;

public class P0017 {
	
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		List<List<Integer>> inputList = generateInputList(T);
		
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			StringBuilder resultBuilder = new StringBuilder();
			
			resultBuilder.append(findUnsortedSequence(inputList.get(test_case-1)));
	
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(resultBuilder);
		}
	}
	
	public static List<List<Integer>> generateInputList(int T) {
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 1; i <= T; i++) {
			List<Integer> numList = makeNumList();
			list.add(numList);
		}
		return list;
	}

	public static List<Integer> makeNumList() {
		List<Integer> numList = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		String[] numStr = scan.nextLine().split(" ");
		
		for(int i = 0 ; i < numStr.length ; i++) {
			numList.add(Integer.valueOf(numStr[i]));
		}
		
		return numList;
	}
	
	public static int findEndOfLeftSubsequence(List<Integer> list) {
		for(int i = 1; i < list.size(); i++) {
			if(list.get(i) < list.get(i-1))
				return i-1;
		}
		return list.size()-1;
	}
	
	public static int findStartOfRightSubsequence(List<Integer> list) {
		for(int i = list.size() - 2; i >= 0; i--) {
			if(list.get(i) > list.get(i+1))
				return i+1;
		}
		return 0;
	}
	
	public static int shrinkLeft(List<Integer> list, int min_index, int start) {
		int comp = list.get(min_index);
		for(int i = start - 1; i>=0; i--) {
			if(list.get(i) <= comp)
				return i+1;		
		}
		return 0;
	}
	
	public static int shrinkRight(List<Integer> list, int max_index, int start) {
		int comp = list.get(max_index);
		for(int i = start; i < list.size(); i++) {
			if(list.get(i) >= comp)
				return i-1;
		}
		return list.size()-1;
	}
	
	public static String findUnsortedSequence(List<Integer> list) {
		StringBuilder strBuilder = new StringBuilder();
		
		int end_left = findEndOfLeftSubsequence(list);
		int start_right = findStartOfRightSubsequence(list);
		
		int min_index = end_left+1;
		if(min_index >= list.size()) {
			return "";
		}
		
		int max_index = start_right-1;
		for(int i = end_left; i <= start_right; i++) {
			if(list.get(i) < list.get(min_index))
				min_index = i;
			if(list.get(i) > list.get(min_index))
				max_index = i;
		}
		
		int left_index = shrinkLeft(list, min_index, end_left);
		int right_index = shrinkRight(list, max_index, start_right);
		
		return strBuilder.append(left_index + " " + right_index).toString();
	}
}
