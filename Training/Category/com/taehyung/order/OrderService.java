package com.taehyung.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.taehyung.file.FileOrderData;
import com.taehyung.file.FileOrderReader;
import com.taehyung.option.OptionRepository;
import com.taehyung.product.ProductRepository;

public class OrderService {
	OptionRepository optionRepository;
	ProductRepository productRepository;
	FileOrderReader fileOrderReader;
	
	Map<Long,Order> orderMap;
	Map<String,List<Order>> userOrderMap;
	
	public OrderService() {
		optionRepository = new OptionRepository();
		productRepository = new ProductRepository();
		fileOrderReader = new FileOrderReader();
		orderMap = new HashMap<>();
		userOrderMap = new HashMap<>();
	}
	
	public void readFileOrder(String filePath) throws IOException {
		List<FileOrderData> dataList = fileOrderReader.readOrderLine(filePath);
		for (FileOrderData data : dataList) {
			generateOrder(data);
		}
	}
	
	private void generateOrder(FileOrderData data) {
		long orderSrl = data.getOrderSrl();
		String userId = data.getUserId();
		String productCode = data.getProductCode();
		List<String> optionCodeList = data.getOptionCodeList();
		
		Order order = new Order(
							orderSrl, 
							userId, 
							productRepository.getProduct(productCode), 
							optionRepository.getOptionList(optionCodeList)
						);
		putOrderMap(orderSrl, order);
		putUserOrderMap(userId,order);
	}
	
	private void putOrderMap(long orderSrl,Order order) {
		orderMap.put(orderSrl, order);
	}
	
	private void putUserOrderMap(String userId,Order order) {
		List<Order> orderList = userOrderMap.get(userId);
		if(orderList==null) {
			orderList = new ArrayList<>();
			orderList.add(order);
			userOrderMap.put(userId, orderList);
		}
		else {
			orderList.add(order);
		}
	}
	
	public Order getOrderPriceByOrderSrl(long orderSrl) {
		return orderMap.get(orderSrl);
	}
	
	public List<Order> getOrderPriceByOrderSrl(String userId) {
		return userOrderMap.get(userId);
	}
}
