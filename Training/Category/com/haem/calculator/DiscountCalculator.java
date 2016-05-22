package com.haem.calculator;




public class DiscountCalculator implements Calculator{

	@Override
	public long calculate(long baseAmount,long discountAmount) {
		long result = baseAmount - discountAmount;
		if(result < 0 ) return 0;
		return result;
	}

}
