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
		
		int temp = 0;
		
		for(test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.

			temp = sc.nextInt();
			
			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(temp*(temp-3)/2);
			
		}
	}
}
