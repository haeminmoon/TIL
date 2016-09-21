
public class RemoveString {

	public static void main(String[] args) {
		String str = "This is aplle have have money isis money";
		String removeStr = "is";
		
		System.out.println(removingStr(str, removeStr));
		System.out.println(str.replace(removeStr, ""));
	}
	
	//sol1
//	public static String removingStr(String str, String removeStr) {
//		StringBuilder removedStrB = new StringBuilder();
//		StringBuilder tempStrB = new StringBuilder(str);
//		
//		int index = 0;
//		
//		index = tempStrB.indexOf(removeStr);
//		
//		while(index != -1) {
//			removedStrB.append(tempStrB.substring(0, index));
//			tempStrB = new StringBuilder(tempStrB.substring(index+removeStr.length()));
//			index = tempStrB.indexOf(removeStr);
//		}
//		removedStrB.append(tempStrB);
//		
//		return removedStrB.toString();
//	}
	
	//sol2
//	public static char[] removingStr(String str, String removeStr) {
//		char[] removedStr = str.toCharArray();
//		
//		int index=0;
//		int temp=0;
//		
//		for(int i=0; i < str.length() - removeStr.length(); i++) {
//			temp = i;
//			index = 0;
//			
//			while(str.charAt(i+index) == removeStr.charAt(index)) {
//				if(index == removeStr.length() - 1) {
//					while(temp < (i + removeStr.length())) {
//						removedStr[temp] = ' '; 
//						temp++;
//					}
//					break;
//				}
//				index++;
//			}
//		}
//		return removedStr;
//	}
	
	//sol2
	public static String removingStr(String str, String removeStr) {
		StringBuilder removedStrB = new StringBuilder();
		
		for(int i=0; i < str.length(); i++) {
			int temp = i;
			int index = 0;
			
			if(str.charAt(i) != removeStr.charAt(index)) {
				removedStrB.append(str.charAt(i));
			} else {
				while(str.charAt(i+index) == removeStr.charAt(index)) {
					if(index == removeStr.length() - 1) {
						i+=index;
						break;
					} 
					index++;
				}
				
				if(index > 0 && i == temp)
					removedStrB.append(str.charAt(i));
			}
		}
		return removedStrB.toString();
	}
}
