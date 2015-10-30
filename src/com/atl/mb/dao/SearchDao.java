package com.atl.mb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atl.mb.model.OrderSummary;
import com.atl.mb.util.DBUtil;

public class SearchDao {
	
	private Connection dbConnection;
	private PreparedStatement pStmt;
	List<OrderSummary> ordersDetails;
	
	public SearchDao(){
		dbConnection = DBUtil.getCon();
	}
	
	public List<OrderSummary> getOrderDetails(String searchCriteria, String searchParameter){
		
		String searchQuery =  returnOrderSearchQuery(searchCriteria, searchParameter);
		System.out.println("SearchQuery : " + searchQuery);
		ordersDetails = new ArrayList<OrderSummary>();
        try {
        	
                pStmt = dbConnection.prepareStatement(searchQuery);
                //pStmt.setString(1, searchCriteria);
                ResultSet rs = pStmt.executeQuery(searchQuery);
                
                while (rs.next()) {
                	OrderSummary order = new OrderSummary();
                	order.setEmailId(rs.getString("email"));
                	order.setAuthorFName(rs.getString("authorfname"));
                	order.setAuthorLName(rs.getString("authorlname"));
                	order.setTitle(rs.getString("title"));
                	order.setOrderId(rs.getInt("orderid"));
                	order.setPrice(rs.getInt("price"));
                	ordersDetails.add(order);
                }
        } catch (SQLException e) {
                System.err.println(e.getMessage());
        }
		return ordersDetails;
		
	}
	
	public String returnOrderSearchQuery(String searchCriteria, String searchParameter ){
		String returnSearchQuery=null;
		
		if(searchCriteria.equals("EID")){
			returnSearchQuery= "select u.email, o.orderid, b.title, b.authorfname, b.authorlname, b.price "
					 + "from users u, orders o, books b, users_orders uo, orders_books ob " 
					 + "where u.email=uo.email and o.orderid=uo.orderid and o.orderid=ob.orderid and ob.bookid=b.bookid and " 
					 + "b.bookid in " 
					 + "(select bookid from orders_books where orderid in (select orderid from users_orders where email = " + "'"+searchParameter+"'" +"))";
		}else if(searchCriteria.equals("OID")){
			returnSearchQuery= "select u.email, o.orderid, b.title, b.authorfname, b.authorlname, b.price "
					+ "from users u, orders o, books b, users_orders uo, orders_books ob " 
					+ "where u.email=uo.email and o.orderid=uo.orderid and o.orderid=ob.orderid and ob.bookid=b.bookid and "
					+ "b.bookid in "
					+ "(select bookid from orders_books where orderid = " + Integer.parseInt(searchParameter) + ")";;
		}
		
		return returnSearchQuery;
	}

}
