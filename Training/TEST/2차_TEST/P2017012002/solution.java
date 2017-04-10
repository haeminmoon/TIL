package first;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = 0;
		T = scan.nextInt();

		int metrixSize = 0;
		for (int test_case = 1; test_case <= T; test_case++) {
			metrixSize = scan.nextInt();
			int[][] metrix = new int[metrixSize][metrixSize];

			int bingoCounter = 0;// Total count of bingo
			int bingoChecksum = 1;
			for (int i = 0; i < metrixSize; i++) {
				bingoChecksum = 0;
				for (int j = 0; j < metrixSize; j++) {
					metrix[i][j] = scan.nextInt();
					bingoChecksum += metrix[i][j];
				}
				if (bingoChecksum == 5) {
					bingoCounter++;
				}
			}

			for (int i = 0; i < metrixSize; i++) {
				bingoChecksum = 0;
				for (int j = 0; j < metrixSize; j++) {
					bingoChecksum += metrix[j][i];
				}
				if (bingoChecksum == 5) {
					bingoCounter++;
				}
			}

			bingoChecksum = 0;
			for (int i = 0; i < metrixSize; i++) {
				bingoChecksum += metrix[i][i];
			}
			if (bingoChecksum == 5) {
				bingoCounter++;
			}

			bingoChecksum = 0;
			for (int i = 0; i < metrixSize; i++) {
				bingoChecksum += metrix[i][4 - i];
			}
			if (bingoChecksum == 5) {
				bingoCounter++;
			}

			System.out.println("Case #" + test_case);
			System.out.println(bingoCounter);
		}
		scan.close();
	}
}
