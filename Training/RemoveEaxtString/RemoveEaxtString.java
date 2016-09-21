
public class RemoveEaxtString {

	public static void main(String[] args) {
		String str = "I have have a car";
		String removeStr = "hav";

		System.out.println(removingEaxtStr(str, removeStr));
	}
	
	public static String removingEaxtStr(String str, String removeStr) {
		StringBuilder removedStrB = new StringBuilder();
		String[] splitedStrArray = splitStr(str);
		
		for(int i = 0; i < splitedStrArray.length; i++) {
			if(!splitedStrArray[i].equals(removeStr)) 
				removedStrB.append(splitedStrArray[i]).append(" ");
		}
		
		return removedStrB.toString();
	}
	
	public static String[] splitStr(String str) {
		String[] strArray = str.split(" ");
		
		return strArray;
	}

}
