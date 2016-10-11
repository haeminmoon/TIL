package Quiz;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import IO_Class.BufferedStream;
import Interface.IQuiz;

/*Convert String "345" to Integer "345"*/
public class Quiz_2 extends BufferedStream implements IQuiz {
	List<Object> resultList = new ArrayList<>();
	List<Object> inputList = getInputList();

	public Integer convertingInteger(String str) {
		char[] charArray = str.toCharArray();
		Integer N = 0;

		for (char c : charArray) {
			N = (N * 10) + ((int) c - (int) '0');
		}
		return N;
	}

	@Override
	public void solve() {
		int T = Integer.parseInt(inputList.get(0).toString());
		for(int i = 1;i<=T;i++)
		{
			String str = inputList.get(i).toString();
			resultList.add(convertingInteger(str) + 1);
		}
		setOutput(resultList);
	}

	@Override
	public List<Object> getInputList() {
		List<Object> arrayList = new ArrayList<>();
		String string=null;
		
		try {
			br = new BufferedReader(new FileReader("input.txt"));
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
			bw = new BufferedWriter(new FileWriter("output.txt"));
			
			for(Object o: resultList) {
				bw.write("Case #" + (resultList.indexOf(o)+1));
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
