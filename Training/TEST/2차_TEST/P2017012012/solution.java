// 샘플 가이드 코드입니다. 본인의 코드를 사용하셔도 됩니다.
//package 선언 금지
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 사용하는 클래스명은 Problem ID 이어야 합니다.

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		
		String[] str = new String[100];
		String[] sortedStr = new String[100];
		String buf = "";
				
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			sc.nextInt();
			buf = sc.nextLine();
			buf = buf.trim();
			str = buf.split(" ");
			sortedStr = str.clone();
			Arrays.sort(sortedStr);
			
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			if(Arrays.equals(str,sortedStr))
				System.out.println("INC");
			else{
				sortedStr = str.clone();
				Arrays.sort(sortedStr,Collections.reverseOrder());
				if(Arrays.equals(str,sortedStr))
					System.out.println("DEC");
				else
					System.out.println("NOTSORTED");
			
			}
		}
	}
}
		
