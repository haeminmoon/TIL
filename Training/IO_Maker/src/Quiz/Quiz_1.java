package Quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import IO_Class.BufferedStream;
import Interface.IQuiz;

interface IConvert {
	public String convertingDec();
}

class Binary implements IConvert{
	int n;
	
	public Binary(int n) {
		this.n = n;
	}
	
	@Override
	public String convertingDec() {
		StringBuilder convertedDec = new StringBuilder();
		
		do {
			convertedDec.append(n%2);
			n /= 2; 
		}while(n > 1);
		
		if(n != 0)
			convertedDec.append(n);
		
		return convertedDec.reverse().append("(2)").toString();
	}
}

class Octal implements IConvert{
	int n;
	
	public Octal(int n) {
		this.n = n;
	}
	
	@Override
	public String convertingDec() {
		StringBuilder convertedDec = new StringBuilder();
		
		do {
			convertedDec.append(n%8);
			n /= 8; 
		}while(n > 1);
		
		if(n != 0)
			convertedDec.append(n);
		
		return convertedDec.reverse().append("(8)").toString();
	}
}
class Hexa implements IConvert{
	int n;
	
	public Hexa(int n) {
		this.n = n;
	}
	
	@Override
	public String convertingDec() {
		StringBuilder convertedDec = new StringBuilder();
		char[] HexaMappingTable = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		
		do {
			convertedDec.append(HexaMappingTable[n%16]);
			n /= 16; 
		}while(n > 1);
		
		if(n != 0)
			convertedDec.append(n);
		
		return convertedDec.reverse().append("(16)").toString();
	}
}

public class Quiz_1  extends BufferedStream implements IQuiz{
	List<Object> resultList = new ArrayList<>();
	List<Object> inputList = getInputList();
	
	public String convertingDec(IConvert convert) {
		return convert.convertingDec();
	}
	
	@Override
	public void solve() {
		int T = Integer.parseInt(inputList.get(0).toString());
		for(int i = 1;i<=T;i++)
		{
			String str = inputList.get(i).toString();
			resultList.add(convertingDec(new Binary(Integer.parseInt(str))) + " " +
					convertingDec(new Octal(Integer.parseInt(str))) + " " +
					convertingDec(new Hexa(Integer.parseInt(str))));
		}
		setOutput(resultList);

//		convertingDec(new Binary(n));
//		convertingDec(new Octal(n));
//		convertingDec(new Hexa(n));
	}
	
	@Override
	public List<Object> getInputList() {
		List<Object> arrayList = new ArrayList<>();
		String string=null;
		
		try {
			br = new BufferedReader(new FileReader("Quiz1/input.txt"));
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
			bw = new BufferedWriter(new FileWriter("Quiz1/output.txt"));
			
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

