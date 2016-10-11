//package Quiz;
//import IO_Class.BufferedStream;
//
//interface IConvert {
//	public void convertingDec();
//}
//
//class Binary implements IConvert{
//	int n;
//	
//	public Binary(int n) {
//		this.n = n;
//	}
//	
//	@Override
//	public void convertingDec() {
//		StringBuilder convertedDec = new StringBuilder();
//		
//		do {
//			convertedDec.append(n%2);
//			n /= 2; 
//		}while(n > 1);
//		
//		if(n != 0)
//			convertedDec.append(n);
//		
//		System.out.println(convertedDec.reverse().toString() +"(2)");
//	}
//}
//
//class Octal implements IConvert{
//	int n;
//	
//	public Octal(int n) {
//		this.n = n;
//	}
//	
//	@Override
//	public void convertingDec() {
//		StringBuilder convertedDec = new StringBuilder();
//		
//		do {
//			convertedDec.append(n%8);
//			n /= 8; 
//		}while(n > 1);
//		
//		if(n != 0)
//			convertedDec.append(n);
//		
//		System.out.println(convertedDec.reverse().toString() +"(8)");
//	}
//}
//class Hexa implements IConvert{
//	int n;
//	
//	public Hexa(int n) {
//		this.n = n;
//	}
//	
//	@Override
//	public void convertingDec() {
//		StringBuilder convertedDec = new StringBuilder();
//		char[] HexaMappingTable = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
//		
//		do {
//			convertedDec.append(HexaMappingTable[n%16]);
//			n /= 16; 
//		}while(n > 1);
//		
//		if(n != 0)
//			convertedDec.append(n);
//		
//		System.out.println(convertedDec.reverse().toString() +"(16)");
//	}
//}
//
//public class Quiz_1 {
//
//	public static void main(String[] args) {
//		BufferedStream bs = new BufferedStream();
//		
//		int n = 11111;
//		
//		convertingDec(new Binary(n));
//		convertingDec(new Octal(n));
//		convertingDec(new Hexa(n));
//	}
//	
//	public static void convertingDec(IConvert convert) {
//		convert.convertingDec();
//	}
//}
