import java.util.Scanner;
import java.util.Stack;

public class SpecialStr {
	private String input;
	private Stack<Integer> stackM;
	private Stack<Integer> stackT;

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		SpecialStr specialStr = new SpecialStr(scan.nextLine());
	}

	public SpecialStr(String input) {
		if (input.length() >= 50 || input.length() <= 2) {
			System.out.println("False");
			return;
		}
		this.input = input;
		this.stackM = new Stack<>();
		this.stackT = new Stack<>();
		if (isMatch(input)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}

	private boolean isMatch(String input) {
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == 'T') {
				if (stackT.isEmpty()) {
					stackT.push(i);
				} else {
					if (stackM.isEmpty()) {
						stackT.pop();
					} else {
						int compareIndexM = stackM.peek();
						int compareIndexT = stackT.peek();
						if (compareIndexT > compareIndexM || i < compareIndexM) {
							stackT.pop();
						}

					}
				}
			} else {
				if (stackM.isEmpty()) {
					stackM.push(i);
				} else {
					if (stackT.isEmpty()) {
						stackM.pop();
					} else {
						int compareIndexT = stackT.peek();
						int compareIndexM = stackM.peek();
						if (compareIndexM > compareIndexT || i < compareIndexT) {
							stackM.pop();
						}

					}
				}
			}
		}

		return (stackM.isEmpty() && stackT.isEmpty());
	}

}
