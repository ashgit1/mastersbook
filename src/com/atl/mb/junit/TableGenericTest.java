package com.atl.mb.junit;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.atl.mb.dao.TableDao;
import com.atl.mb.model.Books;
import com.atl.mb.model.Orders;
import com.atl.mb.model.Users;

public class TableGenericTest {

	final static Logger logger = Logger.getLogger(TableGenericTest.class);
	
	public static void main(String[] args) throws Exception {

		TableDao td = new TableDao(); 
		ArrayList<Books>  bookObj;
		ArrayList<Users>  userObj;
		ArrayList<Orders> orderObj;
		
		bookObj =  td.getBooksTable();
		for(Books b : bookObj){
			System.out.println("Name: " + b.getTitle());
		}
		System.out.println("Books Count : " + bookObj.size());
		System.out.println("++++++++++++++++++++++++++++++++++++");
		
		userObj = td.getUsersTable();
		for(Users u : userObj){
			System.out.println("Name: " + u.getEmail());
		}
		System.out.println("Users Count : " + userObj.size());
		System.out.println("++++++++++++++++++++++++++++++++++++");
		
		orderObj = td.getOrdersTable();
		for(Orders o : orderObj){
			System.out.println("Order Id: " + o.getOrderId());
		}
		System.out.println("Orders Count : " + orderObj.size());
		System.out.println("++++++++++++++++++++++++++++++++++++");
	
	}

}
