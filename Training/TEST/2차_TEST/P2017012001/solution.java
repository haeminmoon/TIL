
import java.util.Scanner;

// ���� ���̵� �ڵ��Դϴ�. ������ �ڵ带 ����ϼŵ� �˴ϴ�.
//package ���� ����


// ����ϴ� Ŭ�������� Problem ID �̾�� �մϴ�.

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		int base = 0;
		int exp = 0;
		
		sc.nextLine();
		
		for(test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.
			base=sc.nextInt();
			exp = sc.nextInt();
			sc.nextLine();
			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println((int)(base*Math.pow(2, exp)));

		}
	}
}
		
