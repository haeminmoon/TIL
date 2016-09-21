
public class CompressString {

	public static void main(String[] args) {
		String str = "aaabbACCCCSSbb";
		
		System.out.println(compressingStr(str));
	}
	
	public static String compressingStr(String str) {
		StringBuilder compressedStrBuilder = new StringBuilder();
		char[] charArray = str.toCharArray();
		
		int count = 1;
		char temp = charArray[0];
		
		for(char c : charArray) {
			if(c==temp) {
				count++;
			} else {
				compressedStrBuilder.append(temp).append(count);
				temp = c;
				count=1;
			}
		}
		compressedStrBuilder.append(temp).append(count);
		
		return compressedStrBuilder.toString();
	}

}
 