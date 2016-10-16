
public class Operator {

	public static void main(String[] args) {
		

	}
	
	/*양수는 음수로, 음수는 양수로 뒤집는다.*/
	public static int negate(int a) {
		int neg = 0;
		int d = a < 0 ? 1: -1;
		while(a!=0) {
			neg += d;
			a += d;
		}
		return neg;
	}
	
	/*b를 negate한 다음에 더하여 두 수의 차를 계산한다*/
	public static int minus(int a, int b) {
		return a + negate(b);
	}

	/*a를 b번 더하여 a*b를 구현한다.*/
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
	
	/*절대값 반환*/
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
		while(product + absb <= absa) { /*a를 넘지 않도록*/
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
