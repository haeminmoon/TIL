// ���� ���̵� �ڵ��Դϴ�. ������ �ڵ带 ����ϼŵ� �˴ϴ�.
//package ���� ����
import java.util.Scanner;

// ����ϴ� Ŭ�������� Problem ID �̾�� �մϴ�.

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		
		String temp = "";
		String str = "";
		
		sc.nextLine();
		
		for(test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.

			str = sc.nextLine();
			for(int i = 0;i<str.length();i++){
				temp = temp + str.charAt(str.length()-i-1);
			}
						
			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			if(temp.equals(str)) System.out.println("Y");
			else System.out.println("N");
			temp = "";
			
		}
	}
}
