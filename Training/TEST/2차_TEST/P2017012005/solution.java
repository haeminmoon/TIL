
import java.util.ArrayList;
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
		
		int max = 2;
		int temp = 0;
		ArrayList<Long> fib = new ArrayList<>();
		fib.add((long) 1);
		fib.add((long) 1);
		sc.nextLine();
		
		for(test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.
			temp = sc.nextInt();
			if(temp>max){
				for(int j = fib.size();j<temp;j++){
					fib.add(fib.get(j-1)+fib.get(j-2));
				}
			}
			
			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(fib.get(temp-1)*fib.get(temp-1));


		}
	}
}
		
