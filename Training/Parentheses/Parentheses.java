import java.util.ArrayList;
import java.util.List;

public class Parentheses {

	public static void main(String[] args) {
		int n=15;
		
		List<String> list = generateParens(n);
		System.out.println(list.size());
//		for(String s:list) {
//			System.out.println(s);
//		}

	}
	
	public static void addParen(List<String> list, int leftRem, int rightRem, char[] str, int count) {
		/*잘못된 상태*/
		if(leftRem < 0 || rightRem < leftRem)
			return;
		
		/*남은 괄호가 없음*/
		if(leftRem == 0 && rightRem == 0) {
			String s = String.copyValueOf(str);
			list.add(s);
		} else {
			/* 남은 왼쪽 괄호가 있는 경우 왼쪽 괄호 추가 */
			if(leftRem > 0) {
				str[count] = '(';
				addParen(list, leftRem - 1, rightRem, str, count + 1);
			}
			
			/* 문법 오류가 발생하지 않는다면 오른쪽 괄호 추가 */
			if(rightRem > leftRem) {
				str[count] = ')';
				addParen(list, leftRem, rightRem - 1, str, count + 1);
			}
		}
	}
	
	public static List<String> generateParens(int count) {
		char[] str = new char[count * 2];
		List<String> list = new ArrayList<>();
		addParen(list, count, count, str, 0);
		return list;
	}

}
