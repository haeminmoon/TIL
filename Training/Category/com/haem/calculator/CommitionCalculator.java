package com.haem.calculator;


public class CommitionCalculator implements Calculator {
	
	@Override
	public long calculate(long baseAmount,long commitionAmount) {
		double commition = commitionAmount*0.01;
		return (long) (baseAmount+(long)(baseAmount*commition));
	}
	
}
