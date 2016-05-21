package com.taehyung.option;

import com.taehyung.calculator.Calculator;

public class Option {

	private String optionCode;
	private long price;
	private String name;
	private String description;
	private Calculator calcultor;

	public Option(String optionCode, long price, String name,
			String description, Calculator calcultor) {
		super();
		this.optionCode = optionCode;
		this.price = price;
		this.name = name;
		this.description = description;
		this.calcultor = calcultor;
	}

	public String getOptionCode() {
		return optionCode;
	}

	public void setOptionCode(String optionCode) {
		this.optionCode = optionCode;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public long calculate(long orderPrice) {
		return calcultor.calculate(orderPrice,price);
	}

}
