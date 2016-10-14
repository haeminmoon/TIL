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

public class Quiz_11 extends BufferedStream implements IQuiz {
	List<Object> resultList = new ArrayList<>();
	List<Object> inputList = getInputList();

	public static int getUserInput() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		return n;
	}
	
	public static String drawTriangle(int lineNumber) {
		StringBuilder strBuilder = new StringBuilder();
		
		for (int i = 0; i < lineNumber; i++) {
			StringBuilder tempBuilder = new StringBuilder();
			
			for (int j = 0; j < lineNumber - i; j++) {
				tempBuilder.append(" ");
			}
			
			for (int k = 0; k <= 2 * i; k++) {
				if (k == 0 || 2 * i == k)
					tempBuilder.append("*");
				else
					tempBuilder.append("*");
			}
			
			for(int j = lineNumber + i; j < (lineNumber*2-1); j++)
				tempBuilder.append(" ");
			
			for(int h = 0; h < lineNumber; h++)
				strBuilder.append(tempBuilder.toString());
			
			strBuilder.append("\n");
		}
		
		return strBuilder.toString().replace("\n", System.getProperty("line.separator"));
	}

	@Override
	public void solve() {
		int T = Integer.parseInt(inputList.get(0).toString());
		for(int i = 1;i<=T;i++)
		{
			String str = inputList.get(i).toString();
			int n = Integer.parseInt(str);
			resultList.add(drawTriangle(n));
		}
		setOutput(resultList);		
	}

	@Override
	public List<Object> getInputList() {
		List<Object> arrayList = new ArrayList<>();
		String string=null;
		
		try {
			br = new BufferedReader(new FileReader("Quiz11/input.txt"));
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
			bw = new BufferedWriter(new FileWriter("Quiz11/output.txt"));
			
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
