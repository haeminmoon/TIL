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
		
		int prediction = 0;
		int count = 0;
		for(test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.
			prediction = 0;
			count = sc.nextInt();
			sc.nextLine();
			ArrayList<Integer> date = new ArrayList<>();
			for(int i=0;i<count;i++){
				date.add(sc.nextInt());
			}
			for(int i=2;i<count;i++){
				if(date.get(i-2)+date.get(i-1)+date.get(i) < 5){
					prediction++;
				}
			}

			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(prediction);
		}
	}
}
		
