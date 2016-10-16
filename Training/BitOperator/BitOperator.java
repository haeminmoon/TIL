
public class BitOperator {

	public static void main(String[] args) {
		int a=3, b=2;
		
		System.out.println(add(a, b));
		System.out.println(swap(a, b));
	}
	
	public static int add(int a, int b) {		
		if(b==0)
			return a;
		
		int sum=a^b;
		int carry=(a&b)<<1;
		
		return add(sum, carry);
	}
	public static int swap(int _a, int _b) {
		int a=_a, b=_b;
		
		a = a^b;
		b = a^b;
		a = a^b;
		
		return a;
	}
}
