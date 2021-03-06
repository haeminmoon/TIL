package Quiz;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import IO_Class.BufferedStream;
import Interface.IQuiz;

public class Quiz_7 extends BufferedStream implements IQuiz{
	List<Object> resultList = new ArrayList<>();
	List<Object> inputList = getInputList();

	public static String removedWordList(List<Map<Character, Integer>> firstWordList) {
		
		StringBuilder strBuilder = new StringBuilder();
		
		for(Map<Character, Integer> map: firstWordList) {		
			for(Character key: map.keySet()) {
				if(map.get(key) == 1) {
					strBuilder.append(key);
				}
			}
			strBuilder.append(" ");
		}
		return strBuilder.toString();
	}
	
	public static String getUserInput() {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		return str;
	}
	
	public static List<Map<Character, Integer>> makeWordList(String str) {
		List<Map<Character, Integer>> WordList = new ArrayList<>();
		
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
			WordList.add(wordMap);
		}
		return WordList;
	}

	@Override
	public void solve() {
		int T = Integer.parseInt(inputList.get(0).toString());
		for(int i = 1;i<=T;i++)
		{
			String str = inputList.get(i).toString();
			List<Map<Character, Integer>> WordList = makeWordList(str);
			resultList.add(removedWordList(WordList));
		}
		setOutput(resultList);			
	}

	@Override
	public List<Object> getInputList() {
		List<Object> arrayList = new ArrayList<>();
		String string=null;
		
		try {
			br = new BufferedReader(new FileReader("Quiz7/input.txt"));
			do
			{
				string = br.readLine();
				
				if(string != null) {
					arrayList.add(string);
				}
			}while(string != null);
		}
		catch (Exception e) {
			System.out.println(e);
			
		}
		finally {
			try {br.close();}
			catch (Exception e) {System.out.println(e);}
		}
		return arrayList;
	}

	@Override
	public void setOutput(List<Object> resultList) {
		try {
			int caseNum = 1;
			bw = new BufferedWriter(new FileWriter("Quiz7/output.txt"));
			
			for(Object o: resultList) {
				bw.write("Case #" + (caseNum++));
				bw.newLine();
				bw.write(o.toString());
				bw.newLine();
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {bw.close();}
			catch (Exception e) {System.out.println(e);}
		}
		
	}
}
