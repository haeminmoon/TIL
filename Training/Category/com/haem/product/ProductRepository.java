package com.haem.product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
	Map<String,Product> productData;

	public ProductRepository() {
		init();
	}
	private void init() {
		productData = new HashMap<>();
		productData.put("H",new Product("H", 900000, "고급 게이밍", "고사양 고급 PC"));
		productData.put("M",new Product("M", 550000, "중급 게이밍", "중사양 중급 PC"));
		productData.put("L",new Product("L", 350000, "알뜰 게이밍", "알뜰사양 알뜰 PC"));
	}
	public Product getProduct(String code) {
		return productData.get(code);
	}
	
}
