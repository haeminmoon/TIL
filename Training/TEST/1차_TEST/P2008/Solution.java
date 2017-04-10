
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {

	static List<Integer> primes = new ArrayList<>();
	static Map<Integer, List<Pair>> factorization = new HashMap<>();

	public static void main(String args[]) throws Exception {

		generatePrime();
		generateFactorization();

		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			System.out.println("Case #" + test_case);
			if (N == 1) {
				System.out.println("");
			} else {
				Map<Integer, Integer> map = new HashMap<>();
				for (int x = 2; x <= N; x++) {
					List<Pair> list = factorization.get(x);
					for (Pair pair : list) {
						int count = 0;
						if (map.containsKey(pair.prime)) {
							count = map.get(pair.prime);
						}
						count += pair.count;
						map.put(pair.prime, count);
					}
				}
				SortedSet<Integer> keys = new TreeSet<Integer>(map.keySet());
				int keySize = keys.size() - 1;
				for (Integer key : keys) {

					Integer value = map.get(key);
					System.out.print(key + "^" + value);
					if (keySize == 0) {
						System.out.println("");
					} else {
						System.out.print("*");
					}
					keySize--;
				}

			}
		}
	}

	private static void generatePrime() {
		for (int i = 2; i < 10000; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}

	}

	private static Boolean isPrime(int x) {
		int max = (int) Math.sqrt(x);
		for (int i = 2; i <= max; i++) {
			if (x % i == 0)
				return false;
		}
		return true;
	}

	private static void generateFactorization() {

		for (int x = 2; x <= 10000; x++) {
			List<Pair> list = new ArrayList<>();
			int tempx = x, primeIdx = 0;

			while (tempx > 1) {
				if (tempx % primes.get(primeIdx) == 0) {
					Pair fac = new Pair();
					fac.prime = primes.get(primeIdx);
					fac.count = 0;
					while (tempx % primes.get(primeIdx) == 0) {
						tempx /= primes.get(primeIdx);
						fac.count++;
					}
					list.add(fac);
				}
				primeIdx++;
			}
			factorization.put(x, list);
		}
	}

	static class Pair {
		public int prime;
		public int count;
	}
}
