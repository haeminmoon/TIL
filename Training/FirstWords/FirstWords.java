import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FirstWords {

	public static void main(String[] args) {
		String str = getUserInput();
		List<Map<Character, Integer>> firstWordList = makeFirstWordList(str);
		printFirstWordList(firstWordList);
	}
	
	public static void printFirstWordList(List<Map<Character, Integer>> firstWordList) {
		for(Map<Character, Integer> map: firstWordList) {
			Iterator<Character> i = map.keySet().iterator();
			boolean isPrinted = false;
			while(i.hasNext()) {
				 
				 Character key = i.next();
				 Integer value = map.get(key);
				 
				 if(value == 1) {
					 System.out.println(key);
					 isPrinted = true;
					 break;
				 }
			}
			
			if(isPrinted == false)
				System.out.println("All words removed");
		}
	}
	
	public static String getUserInput() {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		return str;
	}
	
	public static List<Map<Character, Integer>> makeFirstWordList(String str) {
		List<Map<Character, Integer>> firstWordList = new ArrayList<>();
		
		String[] strArray = str.split(" ");
		
		for(int i=0; i<strArray.length;i++) {
			Map<Character, Integer> wordMap = new HashMap<>();
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
