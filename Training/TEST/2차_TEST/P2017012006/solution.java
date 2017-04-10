package first;

import java.util.Scanner;

public class Problem {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		int T = 0;
		T = Integer.parseInt(scan.nextLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = 0;
			int K = 0;
			N = scan.nextInt();
			K = scan.nextInt();

			int temp = 0;
			StringBuilder ans = new StringBuilder();
			while (N > 0) {
				temp = N % K;
				if (temp < 10) {
					ans.append((char) (temp + '0'));
				} else {
					ans.append((char) (temp - 10 + 'A'));
				}
				N /= K;
			}

			System.out.println("Case #" + test_case);
			System.out.println(ans.reverse());
		}

		scan.close();
	}
}
