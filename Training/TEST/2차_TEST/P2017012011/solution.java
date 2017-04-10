package first;

import java.io.IOException;
import java.util.Scanner;

public class Problem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = 0;
		T = scan.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int A = scan.nextInt();
			int B = scan.nextInt();
			int V = scan.nextInt();

			int res = 0;
			double check = V - A;
			if (check > 0) {
				double sec = (double) (check / (A - B));
				res = (int) Math.ceil(sec);
				System.out.println("Case #" + test_case);
				System.out.println(res * 2 + 1);
			} else {
				System.out.println("Case #" + test_case);
				System.out.println(1);
			}
		}
		scan.close();
	}
}
