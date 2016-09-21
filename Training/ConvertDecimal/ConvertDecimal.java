import java.util.Scanner;

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
		
		System.out.println("Convert Binary n : " + convertedDec.reverse().toString() +"(2)");
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
		
		System.out.println("Convert Octal n : " + convertedDec.reverse().toString() +"(8)");
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
		
		System.out.println("Convert Hexa n : " + convertedDec.reverse().toString() +"(16)");
	}
}

public class ConvertDecimal {

	public static void main(String[] args) {
		int n = 233;
		
		convertingDec(new Binary(n));
		convertingDec(new Octal(n));
		convertingDec(new Hexa(n));
	}
	
	public static void convertingDec(IConvert convert) {
		convert.convertingDec();
	}
}
