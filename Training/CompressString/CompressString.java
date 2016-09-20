
public class CompressString {

	public static void main(String[] args) {
		String str = "aaabbACCCCSSbb";
		
		System.out.println(compressingStr(str));
	}
	
	public static String compressingStr(String str) {
		StringBuilder compressedStrBuilder = new StringBuilder();
		StringBuilder convertedStrBuilder = new StringBuilder(str).append(' ');
		
		int count = 1;
		char temp = convertedStrBuilder.charAt(0);
		
		for(int i = 1; i < convertedStrBuilder.length(); i++) {
			if(temp != convertedStrBuilder.charAt(i)) {
				compressedStrBuilder.append(temp).append(count);
				temp = convertedStrBuilder.charAt(i);
				count=1;
			} else {
				count++;
			}
		}
		
		return compressedStrBuilder.toString();
	}

}
 