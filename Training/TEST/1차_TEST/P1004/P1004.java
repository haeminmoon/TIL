import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1004 {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		List<Integer> inputList = generateInputList(T, sc);
		
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			StringBuilder resultBuilder = new StringBuilder();
			
			resultBuilder.append(generateParens(inputList.get(test_case-1)));

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(resultBuilder);
		}
	}
	
	public static List<Integer> generateInputList(int T, Scanner sc) {
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			list.add(n);
		}
		return list;
	}
	
	public static void countParen(IntegerObj num, int leftRem, int rightRem, int count) {
		if(leftRem < 0 || rightRem < leftRem)
			return;
		
		if(leftRem == 0 && rightRem == 0) {
			num.counting();
		} else {
			if(leftRem > 0) {
				countParen(num, leftRem - 1, rightRem, count + 1);
			}
			if(rightRem > leftRem) {
				countParen(num, leftRem, rightRem - 1, count + 1);
			}
		}
	}
	
	public static int generateParens(int count) {
		IntegerObj num = new IntegerObj(0);
		countParen(num, count, count, 0);
		return num.getValue();
	}
}

class IntegerObj {
    int value;
    IntegerObj(int val) {
        this.value = val;
    }
    
    public void counting() {
    	this.value++;
    }
    
    public int getValue() {
    	return this.value;
    }
}
