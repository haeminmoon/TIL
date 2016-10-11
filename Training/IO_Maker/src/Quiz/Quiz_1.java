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
	public void convertingDec();
}

class Binary implements IConvert{
	int n;
	
	public Binary(int n) {
		this.n = n;
	}
	
	@Override
	public void convertingDec() {
		StringBuilder convertedDec = new StringBuilder();
		
		do {
			convertedDec.append(n%2);
			n /= 2; 
		}while(n > 1);
		
		if(n != 0)
			convertedDec.append(n);
		
		System.out.println(convertedDec.reverse().toString() +"(2)");
	}
}

class Octal implements IConvert{
	int n;
	
	public Octal(int n) {
		this.n = n;
	}
	
	@Override
	public void convertingDec() {
		StringBuilder convertedDec = new StringBuilder();
		
		do {
			convertedDec.append(n%8);
			n /= 8; 
		}while(n > 1);
		
		if(n != 0)
			convertedDec.append(n);
		
		System.out.println(convertedDec.reverse().toString() +"(8)");
	}
}
class Hexa implements IConvert{
	int n;
	
	public Hexa(int n) {
		this.n = n;
	}
	
	@Override
	public void convertingDec() {
		StringBuilder convertedDec = new StringBuilder();
		char[] HexaMappingTable = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		
		do {
			convertedDec.append(HexaMappingTable[n%16]);
			n /= 16; 
		}while(n > 1);
		
		if(n != 0)
			convertedDec.append(n);
		
		System.out.println(convertedDec.reverse().toString() +"(16)");
	}
}

public class Quiz_1  extends BufferedStream implements IQuiz{
	public void convertingDec(IConvert convert) {
		convert.convertingDec();
	}
	
	@Override
	public void solve() {
		int n = 11111;

		convertingDec(new Binary(n));
		convertingDec(new Octal(n));
		convertingDec(new Hexa(n));
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
			bw = new BufferedWriter(new FileWriter("Quiz1/output.txt"));
			
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
