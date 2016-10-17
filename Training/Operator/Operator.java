
public class Operator {

	public static void main(String[] args) {
		int a = 4, b = 2;
		
		System.out.println(minus(a, b));
		System.out.println(multiply(a, b));
		System.out.println(divide(a, b));
	}
	
	public static int negate(int a) {
		int neg = 0;
		int d = a < 0 ? 1: -1;
		while(a!=0) {
			neg += d;
			a += d;
		}
		return neg;
	}
	
	public static int minus(int a, int b) {
		return a + negate(b);
	}

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
	
	public static int abs(int a) {
		if(a<0) {
			return negate(a);
		} else {
			return a;
		}
	}
	
	public static int divide(int a, int b) { 
		int absa = abs(a);
		int absb = abs(b);
		
		int product = 0;
		int x = 0;
		while(product + absb <= absa) {
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
