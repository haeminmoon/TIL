import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Convert Factorial to the least common multiple list*/
public class P2008 {
	
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		List<Integer> inputList = generateInputList(T, sc);
		
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			StringBuilder resultBuilder = new StringBuilder();
			
			List<SpecialNum> specialNumList = makePrimeNumList(inputList.get(test_case-1));
			
			resultBuilder.append(getSpecialNFac(convertSpecialNFac(specialNumList, inputList.get(test_case-1))));

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(resultBuilder);
		}
	}
	
	public static List<Integer> generateInputList(int T, Scanner sc) {
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			list.add(n);
		}
		return list;
	}
	
	/* Get prime number from factorial number*/
	public static List<SpecialNum> makePrimeNumList(int num) {
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
	public static List<SpecialNum> convertSpecialNFac(List<SpecialNum> sList, int num) {
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

		return sList;
	}

	/* Round specialNFacList for print*/
	public static String getSpecialNFac(List<SpecialNum> sList) {
		StringBuilder strBuilder = new StringBuilder();
		
		for(SpecialNum s: sList) {
			if(!sList.get(sList.size()-1).equals(s))
				strBuilder.append(s.getMyNum() + "^" + s.getMyCount() + "*");
			else
				strBuilder.append(s.getMyNum() + "^" + s.getMyCount());
		}
		return strBuilder.toString();
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
