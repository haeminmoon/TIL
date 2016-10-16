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
		/*�߸��� ����*/
		if(leftRem < 0 || rightRem < leftRem)
			return;
		
		/*���� ��ȣ�� ����*/
		if(leftRem == 0 && rightRem == 0) {
			String s = String.copyValueOf(str);
			list.add(s);
		} else {
			/* ���� ���� ��ȣ�� �ִ� ��� ���� ��ȣ �߰� */
			if(leftRem > 0) {
				str[count] = '(';
				addParen(list, leftRem - 1, rightRem, str, count + 1);
			}
			
			/* ���� ������ �߻����� �ʴ´ٸ� ������ ��ȣ �߰� */
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
