
import java.util.ArrayList;
import java.util.Scanner;

// 샘플 가이드 코드입니다. 본인의 코드를 사용하셔도 됩니다.
//package 선언 금지


// 사용하는 클래스명은 Problem ID 이어야 합니다.

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		
		int max = 2;
		int temp = 0;
		ArrayList<Long> fib = new ArrayList<>();
		fib.add((long) 1);
		fib.add((long) 1);
		sc.nextLine();
		
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			temp = sc.nextInt();
			if(temp>max){
				for(int j = fib.size();j<temp;j++){
					fib.add(fib.get(j-1)+fib.get(j-2));
				}
			}
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(fib.get(temp-1)*fib.get(temp-1));


		}
	}
}
		
