package com.haem.product;

public class Product {
	private String code;
	private int price;
	private String proudctName;
	private String description;

	public Product(String code, int price, String proudctName,
			String description) {
		super();
		this.code = code;
		this.price = price;
		this.proudctName = proudctName;
		this.description = description;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProudctName() {
		return proudctName;
	}

	public void setProudctName(String proudctName) {
		this.proudctName = proudctName;
	}

	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}
	
}
