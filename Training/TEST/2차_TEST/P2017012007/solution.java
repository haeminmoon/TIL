package first;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = 0;
		T = Integer.parseInt(scan.nextLine());

		int[] position = new int[50];
		for (int test_case = 1; test_case <= T; test_case++) {
			for (int i = 0; i < 50; i++) {
				position[i] = 0;
			}

			int num = 0;
			num = scan.nextInt();

			int count = 0;
			int visitor = 0;
			for (int i = 0; i < num; i++) {
				visitor = scan.nextInt();
				if (position[visitor - 1] == 0) {
					position[visitor - 1] = 1;
				} else {
					count++;
				}
			}

			System.out.println("Case #" + test_case);
			System.out.println(count);
		}

		scan.close();
	}
}
