import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Convert Factorial to the least common multiple list*/
public class SpecialNFac {

	public static void main(String[] args) {
		int inputFacNum;
		Scanner sc = new Scanner(System.in);
		inputFacNum = sc.nextInt();

		List<SpecialNum> specialNumList = getPrimeNumList(inputFacNum);
		printSpecialNFac(convertSpecialNFac(specialNumList, inputFacNum));
	}

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
	public static List<SpecialNum> convertSpecialNFac(List<SpecialNum> sList, int num) {
		for (int i=2; i<=num; i++) {
			for(int j=0; j<sList.size(); j++) {
				int div = i/sList.get(j).getMyNum();
				
				while(div >= 1) {	
					
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
	public static void printSpecialNFac(List<SpecialNum> sList) {
		for(SpecialNum s: sList) {
			if(!sList.get(sList.size()-1).equals(s))
				System.out.print(s.getMyNum() + "^" + s.getMyCount() + "*");
			else
				System.out.print(s.getMyNum() + "^" + s.getMyCount());
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
