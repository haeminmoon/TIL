package AlphabetRemetch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String inputStr = "CCBADFFSSSSF";
		int[] convertedAsciiArr = convertStringToAscii(inputStr);
		List<Alphabet> alphabetList = generateAlphabetList(convertedAsciiArr);
		
		Collections.sort(alphabetList, new NoAscCompare());
		
		for (Alphabet alphabet : alphabetList) {
			for(int i = 0; i < alphabet.getCount(); i++) {
				System.out.print((char)alphabet.getAscii());
			}
		}
	}
	
	private static int[] convertStringToAscii(String str) {
		int[] asciiArr = new int[100];
		char[] charArr = str.toCharArray();
		
		for (char c : charArr) {
			asciiArr[c]++;
		}
		
		return asciiArr;
	}

	private static List<Alphabet> generateAlphabetList(int[] convertedAsciiArr) {
		List<Alphabet> alphabetList = new ArrayList<>();
		
		for(int i = 0; i < convertedAsciiArr.length; i++) {
			if(convertedAsciiArr[i] != 0) {
				Alphabet alphabet = new Alphabet();
				alphabet.setAscii(i);
				alphabet.setCount(convertedAsciiArr[i]);
				alphabetList.add(alphabet);
			}
		}
		return alphabetList;
	}
	

//	static class NameAscCompare implements Comparator<Alphabet> {
//		@Override
//		public int compare(Alphabet arg0, Alphabet arg1) {
//			// TODO Auto-generated method stub
//			return arg0.getName().compareTo(arg1.getName());
//		}
//
//	}
//	static class NameDescCompare implements Comparator<Alphabet> {
//		@Override
//		public int compare(Alphabet arg0, Alphabet arg1) {
//			// TODO Auto-generated method stub
//			return arg1.getName().compareTo(arg0.getName());
//		}
//
//	}

	static class NoAscCompare implements Comparator<Alphabet> {
		public int compare(Alphabet arg0, Alphabet arg1) {
			return arg0.getCount() < arg1.getCount() ? -1 : arg0.getCount() > arg1.getCount() ? 1:0;
		}

	}


	static class NoDescCompare implements Comparator<Alphabet> {
		@Override
		public int compare(Alphabet arg0, Alphabet arg1) {
			return arg0.getCount() > arg1.getCount() ? -1 : arg0.getCount() < arg1.getCount() ? 1:0;
		}
	}

}
