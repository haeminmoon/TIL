import java.util.ArrayList;
import java.util.List;

public class ConvertNumberToKorean {
	public static void main(String[] args) {
		final int n = 499999999;
		
		System.out.println(convertingKorean(n));
	}
	
	public static String convertingKorean(int n) {
		StringBuilder convertedKorean = new StringBuilder();
		List<Integer> numberList = getNumberList(n);
		
		final String[] ONE = {"", "일", "이","삼","사","오","육","칠","팔","구"}; 
		final String[] TEN1 = {"천", "" , "십", "백"};
		final String[] TEN2 = {"", "만", "억"};
		
		int chipher = numberList.size();
		int chipCount = 0;
		int chipTemp = 1;
		
		for(int i  = 0; i < numberList.size(); i++, chipher--) {

			if(numberList.get(i) != 0) {
				convertedKorean.append(ONE[numberList.get(i)]);
				convertedKorean.append(TEN1[chipher%4]);
			}

			if((chipher/4 > 0) && chipher%4 == 1) {
				chipTemp = chipher/4;		
				convertedKorean.append(TEN2[chipTemp]+" ");
			}	
		}
		
		if(numberList.get(numberList.size()-1) != 1)
			return convertedKorean.toString().replace("일", "");
		else
			return new StringBuffer(convertedKorean.toString().replace("일", "")).append("일").toString();
	}
	
	public static List<Integer> getNumberList(int n) {
		List<Integer> list = new ArrayList<>();
		String[] tempArray = String.valueOf(n).split("");
		
		for(String s: tempArray) {list.add(Integer.parseInt(s));}
		
		return list;
	}
}
