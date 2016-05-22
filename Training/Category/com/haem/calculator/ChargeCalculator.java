package com.haem.calculator;


public class ChargeCalculator implements Calculator {

	@Override
	public long calculate(long baseAmount,long chargeAmount) {
		return baseAmount+chargeAmount;
	}
}
