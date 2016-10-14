package Quiz;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import IO_Class.BufferedStream;
import Interface.IQuiz;

public class Quiz_5 extends BufferedStream implements IQuiz{
	List<Object> resultList = new ArrayList<>();
	List<Object> inputList = getInputList();
	
	public static String convertingKorean(int n) {
		StringBuilder convertedKorean = new StringBuilder();
		List<Integer> numberList = getNumberList(n);
		
		final String[] ONE = {"", "일", "이","삼","사","오","육","칠","팔","구"}; 
		final String[] TEN1 = {"천", "" , "십", "백"};
		final String[] TEN2 = {"", "만", "억"};
		
		int chipher = numberList.size();
		int chipCount = 0;
		int chipTemp = 1;
		
		for(int i  = 0; i < numberList.size(); i++, chipher--) {

			if(numberList.get(i) != 0 && numberList.get(i) != 1) {
				convertedKorean.append(ONE[numberList.get(i)]);
				convertedKorean.append(TEN1[chipher%4]);			
			}else if(numberList.get(i) == 1){
				if(chipher%4 == 1) {
					convertedKorean.append(ONE[numberList.get(i)]);
					convertedKorean.append(TEN1[chipher%4]);	
				} else {
					convertedKorean.append(TEN1[chipher%4]);
				}
			}

			if((chipher/4 > 0) && chipher%4 == 1) {
				chipTemp = chipher/4;		
				convertedKorean.append(TEN2[chipTemp]+" ");
			}	
		}
	
		return convertedKorean.toString();
	}
	
	public static List<Integer> getNumberList(int n) {
		List<Integer> list = new ArrayList<>();
		String[] tempArray = String.valueOf(n).split("");
		
		for(String s: tempArray) {list.add(Integer.parseInt(s));}
		
		return list;
	}

	@Override
	public void solve() {
		int T = Integer.parseInt(inputList.get(0).toString());
		for(int i = 1;i<=T;i++)
		{
			String str = inputList.get(i).toString();
			int n = Integer.parseInt(str);
			resultList.add(convertingKorean(n));
		}
		setOutput(resultList);			
	}

	@Override
	public List<Object> getInputList() {
		List<Object> arrayList = new ArrayList<>();
		String string=null;
		
		try {
			br = new BufferedReader(new FileReader("Quiz5/input.txt"));
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
			bw = new BufferedWriter(new FileWriter("Quiz5/output.txt"));
			
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
