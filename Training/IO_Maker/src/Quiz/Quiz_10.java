package Quiz;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import IO_Class.BufferedStream;
import Interface.IQuiz;

public class Quiz_10  extends BufferedStream implements IQuiz{
	List<Object> resultList = new ArrayList<>();
	List<Object> inputList = getInputList();

	public static List<Integer> makeNumList(String str) {
		List<Integer> numList = new ArrayList<>();
		String[] strArray = str.split(" ");
		
		for(int i = 0 ; i < strArray.length ; i++) {
			numList.add(Integer.valueOf(strArray[i]));
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

	@Override
	public void solve() {
		int T = Integer.parseInt(inputList.get(0).toString());
		for(int i = 1;i<=T;i++)
		{
			String str = inputList.get(i).toString();
			List<Integer> numList = makeNumList(str);
			resultList.add(efficientLargestSum(numList));
		}
		setOutput(resultList);
	}

	@Override
	public List<Object> getInputList() {
		List<Object> arrayList = new ArrayList<>();
		String string=null;
		
		try {
			br = new BufferedReader(new FileReader("Quiz10/input.txt"));
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
			bw = new BufferedWriter(new FileWriter("Quiz10/output.txt"));
			
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
