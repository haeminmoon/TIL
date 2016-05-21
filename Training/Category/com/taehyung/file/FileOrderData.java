package com.taehyung.file;

import java.util.List;

public class FileOrderData {
	long orderSrl;
	String userId;
	String productCode;
	List<String> optionCodeList;
	public FileOrderData(long orderSrl, String userId, String productCode,
			List<String> optionCodeList) {
		super();
		this.orderSrl = orderSrl;
		this.userId = userId;
		this.productCode = productCode;
		this.optionCodeList = optionCodeList;
	}

	public long getOrderSrl() {
		return orderSrl;
	}
	
	public void setOrderSrl(long orderSrl) {
		this.orderSrl = orderSrl;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getProductCode() {
		return productCode;
	}
	
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	public List<String> getOptionCodeList() {
		return optionCodeList;
	}
	
	public void setOptionCodeList(List<String> optionCodeList) {
		this.optionCodeList = optionCodeList;
	}
}
