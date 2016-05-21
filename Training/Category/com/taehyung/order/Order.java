package com.taehyung.order;

import java.util.List;

import com.taehyung.option.Option;
import com.taehyung.product.Product;

public class Order {
	private long orderSrl;
	private String userId;
	private Product product;
	private List<Option> optionList;
	private long totalPrice;

	public Order(long orderSrl, String userId, Product product,
			List<Option> optionList) {
		this.orderSrl = orderSrl;
		this.userId = userId;
		this.product = product;
		this.optionList = optionList;
		this.totalPrice = calculatePrice();
	}
	
	public long calculatePrice() {
		long totalPrice = product.getPrice();
		for (Option option : optionList) {
			totalPrice = option.calculate(totalPrice);
		}
		return totalPrice;
	}
	
	public long getTotalPrice() {
		return totalPrice;
	}

	public long getOrderSrl() {
		return orderSrl;
	}


	public String getUserId() {
		return userId;
	}


	public Product getProduct() {
		return product;
	}


	public List<Option> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<Option> optionList) {
		this.optionList = optionList;
	}
	
	
	
}
