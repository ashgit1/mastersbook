package com.atl.mb.constants;

public class MbConstants {

	public static String 
	searchByEmailId =  "select u.email, o.orderid, b.title, b.authorfname, b.authorlname, b.price "
					 + "from users u, orders o, books b, users_orders uo, orders_books ob " 
					 + "where u.email=uo.email and o.orderid=uo.orderid and o.orderid=ob.orderid and ob.bookid=b.bookid and " 
					 + "b.bookid in " 
					 + "(select bookid from orders_books where orderid in (select orderid from users_orders where email = 'adoreashish@gmail.com'))";
	
	public static String
	searchMyOrderId = "select u.email, o.orderid, b.title, b.authorfname, b.authorlname, b.price "
					+ "from users u, orders o, books b, users_orders uo, orders_books ob " 
					+ "where u.email=uo.email and o.orderid=uo.orderid and o.orderid=ob.orderid and ob.bookid=b.bookid and "
					+ "b.bookid in "
					+ "(select bookid from orders_books where orderid = 1001)";
	
}
