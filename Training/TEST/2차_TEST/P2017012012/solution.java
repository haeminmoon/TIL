// ���� ���̵� �ڵ��Դϴ�. ������ �ڵ带 ����ϼŵ� �˴ϴ�.
//package ���� ����
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// ����ϴ� Ŭ�������� Problem ID �̾�� �մϴ�.

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
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.
			sc.nextInt();
			buf = sc.nextLine();
			buf = buf.trim();
			str = buf.split(" ");
			sortedStr = str.clone();
			Arrays.sort(sortedStr);
			
			
			// �� �κп��� ������ ����Ͻʽÿ�.
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
		
