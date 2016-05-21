package com.taehyung.command;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.taehyung.order.Order;
import com.taehyung.order.OrderService;

public class CommandRunner {
	public void start()  {
		OrderService orderService = new OrderService();
		try {
			orderService.readFileOrder("./src/test.txt");
		} catch (IOException e) {
			System.out.println("파일 NOT FOUND");
		}
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.주문번호 조회 , 2.user 주문 리스트 조회 3.종료");
			String number = scan.next();
			if(number.equals("1")) {
				System.out.println("주문번호 입력");
				String orderSrl = scan.next();
				printOrderPrice(orderService.getOrderPriceByOrderSrl(Long.parseLong(orderSrl)));
			}
			else if(number.equals("2")) {
				System.out.println("userId 입력 : ");
				String userId = scan.next();
				printUserTotalOrderPrice(orderService.getOrderPriceByOrderSrl(userId));
			}
			else if(number.equals("3")) {
				break;
			}
			else {
				System.out.println("잘못입력 하셨습니다.");
			}
		
		}
	}
	
	private void printOrderPrice(Order order) {
		if(order==null) {
			System.out.println("주문번호가 없음");
		}
		else {
			System.out.println(order.getOrderSrl()+ " : "+ order.getTotalPrice());
		}
	}
	private void printUserTotalOrderPrice(List<Order> orderList) {
		if(orderList==null) {
			System.out.println("id가 존재하지 않음");
			return;
		}
		long orderTotalPrice = 0;
		for (Order order : orderList ) {
			printOrderPrice(order);
			orderTotalPrice+=order.getTotalPrice();
		}
		System.out.println("총 주문액 : " + orderTotalPrice);
	}
}
