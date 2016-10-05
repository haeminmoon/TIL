
public class Atoi {

	public static void main(String[] args) {
		String str = "123";

//		System.out.println('0' <= '1');
//		System.out.println((int)'0'+2);
		System.out.println(atoi(str)+1);
	}
	
	public static int atoi(String str) {
		char[] charArray = str.toCharArray();
		int N=0;
		
		for(char c: charArray) {
			N = (N * 10) + ((int)c - (int)'0');
		}
		
		return N;
	}

}
