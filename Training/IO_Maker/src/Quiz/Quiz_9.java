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

/* Convert Factorial to the least common multiple list*/
public class Quiz_9 extends BufferedStream implements IQuiz{
	List<Object> resultList = new ArrayList<>();
	List<Object> inputList = getInputList();

//	public static int getUserInput() {
//		Scanner sc = new Scanner(System.in);
//		int input = sc.nextInt();
//		
//		return input;
//	}

	/* Get prime number from factorial number*/
	public static List<SpecialNum> getPrimeNumList(int num) {
		List<SpecialNum> pnl = new ArrayList<>();
		boolean isPrimeNumber;

		for (int i = 2; i <= num; i++) {
			isPrimeNumber = true;
			for (int j = 2; j <= (int) Math.sqrt(i); j++) {
				if (i % j == 0) {
					isPrimeNumber = false;
					break;
				}
			}

			if (isPrimeNumber)
				pnl.add(new SpecialNum(i));
		}
		return pnl;
	}

	/* Check frequency of prime number  */
	public static String convertSpecialNFac(List<SpecialNum> sList, int num) {
		StringBuilder strBuilder = new StringBuilder();
		
		for (int i=2; i<=num; i++) {
			for(int j=0; j<sList.size(); j++) {
				int div = i/sList.get(j).getMyNum();
				
				while(div > 0) {	
					
					if(i%sList.get(j).getMyNum() == 0) {
						sList.get(j).addMyCount();
					}
								
					if(div%sList.get(j).getMyNum() != 0)
						break;
					
					div /= sList.get(j).getMyNum();
				}
			}
		}
		
		for(SpecialNum s: sList) {
			if(!sList.get(sList.size()-1).equals(s))
				strBuilder.append(s.getMyNum() + "^" + s.getMyCount() + "*");
			else
				strBuilder.append(s.getMyNum() + "^" + s.getMyCount());
		}
		
		return strBuilder.toString();
	}

	/* Round specialNFacList for print*/
//	public static void printSpecialNFac(List<SpecialNum> sList) {
//		for(SpecialNum s: sList) {
//			if(!sList.get(sList.size()-1).equals(s))
//				System.out.print(s.getMyNum() + "^" + s.getMyCount() + "*");
//			else
//				System.out.print(s.getMyNum() + "^" + s.getMyCount());
//		}
//	}

	@Override
	public void solve() {
		int T = Integer.parseInt(inputList.get(0).toString());
		for(int i = 1;i<=T;i++)
		{
			String str = inputList.get(i).toString();
			int n = Integer.parseInt(str);
			List<SpecialNum> specialNumList = getPrimeNumList(n);
			resultList.add(convertSpecialNFac(specialNumList, n));
		}
		setOutput(resultList);	
	}

	@Override
	public List<Object> getInputList() {
		List<Object> arrayList = new ArrayList<>();
		String string=null;
		
		try {
			br = new BufferedReader(new FileReader("Quiz9/input.txt"));
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
			bw = new BufferedWriter(new FileWriter("Quiz9/output.txt"));
			
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

class SpecialNum {
	int myNum;
	int myCount;
	
	public SpecialNum(int myNum) {
		this.myNum = myNum;
		this.myCount = 0;
	}
	
	public int getMyNum() {
		return myNum;
	}

	public void setMyNum(int myNum) {
		this.myNum = myNum;
	}

	public int getMyCount() {
		return myCount;
	}

	public void addMyCount() {
		this.myCount++;
	}
}
