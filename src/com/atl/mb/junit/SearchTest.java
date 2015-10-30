package com.atl.mb.junit;

import java.util.List;

import com.atl.mb.dao.SearchDao;
import com.atl.mb.model.OrderSummary;

public class SearchTest {

	static List<OrderSummary> ordersDetails, ordersDetails2;
	 
	public static void main(String[] args) {
		
		SearchDao searchDao = new SearchDao();
		ordersDetails = searchDao.getOrderDetails("EID","adoreashish@gmail.com");
		
		for (OrderSummary order : ordersDetails){
			System.out.println(order.getOrderId());
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		ordersDetails2 = searchDao.getOrderDetails("OID", "1001");
		
	}

}
