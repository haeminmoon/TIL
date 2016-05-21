public class ReverseArray {

	public static void main(String[] args) {
		String str = "abcdefg";
		
		char[] charArray = str.toCharArray();
		
		for(int i=0;i < charArray.length/2; i++) {
			char temp;
			temp=charArray[i];
			charArray[i] = charArray[(charArray.length-1) - i];
			charArray[(charArray.length-1) - i] = temp;
		}
		System.out.println(charArray);
	}
}
