
public class Operator {

	public static void main(String[] args) {
		

	}
	
	/*����� ������, ������ ����� �����´�.*/
	public static int negate(int a) {
		int neg = 0;
		int d = a < 0 ? 1: -1;
		while(a!=0) {
			neg += d;
			a += d;
		}
		return neg;
	}
	
	/*b�� negate�� ������ ���Ͽ� �� ���� ���� ����Ѵ�*/
	public static int minus(int a, int b) {
		return a + negate(b);
	}

	/*a�� b�� ���Ͽ� a*b�� �����Ѵ�.*/
	public static int multiply(int a, int b) {
		if(a<b) {
			return multiply(b, a);
		}
		
		int sum = 0;
		for(int i = Math.abs(b); i > 0; i--) {
			sum += a;
		}
		if(b < 0) {
			sum = negate(sum);
		}
		return sum;
	}
	
	/*���밪 ��ȯ*/
	public static int abs(int a) {
		if(a<0) {
			return negate(a);
		} else {
			return a;
		}
	}
	
	public static int divide(int a, int b) { 
		if(b == 0) {
			
		}
		
		int absa = abs(a);
		int absb = abs(b);
		
		int product = 0;
		int x = 0;
		while(product + absb <= absa) { /*a�� ���� �ʵ���*/
			product += absb;
			x++;
		}
		
		if((a<0 && b<0) || (a>0 && b>0)) {
			return x;
		} else {
			return negate(x);
		}
	}
}
