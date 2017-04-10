package first;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = 0;
		T = Integer.parseInt(scan.nextLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int lineCount = Integer.parseInt(scan.nextLine());
			String line = scan.nextLine();

			int charToNum = 0;
			StringBuilder res = new StringBuilder();

			for (int i = 0; i < lineCount; i++) {
				charToNum = line.charAt(i) + 4;

				if (122 < charToNum) {// 'a' == 97, 'z' == 122
					charToNum -= 26;
				}

				res.append((char) charToNum);
			}

			System.out.println("Case #" + test_case);
			System.out.println(res.toString());
		}

		scan.close();
	}
}
