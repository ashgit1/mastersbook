package com.atl.mb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.atl.mb.constants.MbConstants;
import com.atl.mb.model.Books;
import com.atl.mb.model.Orders;
import com.atl.mb.model.OrdersBooks;
import com.atl.mb.model.Users;
import com.atl.mb.model.UsersOrders;
import com.atl.mb.util.DBUtil;

public class TableDao {
	
	private Connection dbConnection;
	//private PreparedStatement pStmt;
	private Statement stmt;
	private ResultSet rs ;
	private ArrayList<Books>  bookObj;
	private ArrayList<Users>  userObj;
	private ArrayList<Orders> orderObj;
	private ArrayList<UsersOrders> userOrderObj;
	private ArrayList<OrdersBooks> orderBookObj;
	
	public TableDao(){
		dbConnection = DBUtil.getCon();
	}
	
	public ArrayList<Books> getBooksTable() throws Exception{
		
		String tableQuery = "select * from " + MbConstants.BOOKSTABLE;
		try{
			stmt = dbConnection.createStatement();
            rs   = stmt.executeQuery(tableQuery);
            bookObj = new ArrayList<Books>();
            	while(rs.next()){
            		Books book = new Books();
            		book.setBookId(rs.getInt("bookid"));
            		book.setTitle(rs.getString("title"));
            		book.setAuthorFName(rs.getString("authorfname"));
            		book.setAuthorLName(rs.getString("authorlname"));
            		book.setCategory(rs.getString("category"));
            		book.setDescription(rs.getString("description"));
            		book.setPublisher(rs.getString("publisher"));
            		book.setPrice(rs.getInt("price"));
            		bookObj.add(book);
                }
		}catch(SQLException e){
			e.printStackTrace();
			dbConnection.close();
		}finally{
			stmt.close();
		}
		
		return bookObj;		
	}
	
	public ArrayList<Users> getUsersTable() throws Exception{
		
		String tableQuery = "select * from " + MbConstants.USERSTABLE;
		try{
			stmt = dbConnection.createStatement();
            rs   = stmt.executeQuery(tableQuery);
            userObj = new ArrayList<Users>();
            	while(rs.next()){
            		Users user = new Users();
            		user.setEmail(rs.getString("email"));
            		user.setFname(rs.getString("fname"));
            		user.setLname(rs.getString("lname"));
            		user.setPhone(rs.getString("phone"));
            		userObj.add(user);
                }
		}catch(SQLException e){
			e.printStackTrace();
			dbConnection.close();
		}finally{
			stmt.close();
		}
		return userObj;		
	}
	
	public ArrayList<Orders> getOrdersTable() throws Exception{
		
		String tableQuery = "select * from " + MbConstants.ORDERSTABLE;
		try{
			stmt = dbConnection.createStatement();
            rs   = stmt.executeQuery(tableQuery);
            orderObj = new ArrayList<Orders>();
            	while(rs.next()){
            		Orders order = new Orders();
            		order.setOrderId(rs.getInt("orderid"));
            		order.setOrderDate(rs.getString("orderdate"));
            		order.setShipAddress(rs.getString("shipaddress"));
            		order.setTotalPrice(rs.getInt("totalprice"));
            		order.setStatus(rs.getString("status"));
            		orderObj.add(order);
                }
		}catch(SQLException e){
			e.printStackTrace();
			dbConnection.close();
		}finally{
			stmt.close();
		}
		return orderObj;		
	}
	
public ArrayList<UsersOrders> getUsersOrdersTable() throws Exception{
		
		String tableQuery = "select * from " + MbConstants.USERSORDERSTABLE;
		try{
			stmt = dbConnection.createStatement();
            rs   = stmt.executeQuery(tableQuery);
            userOrderObj = new ArrayList<UsersOrders>();
            	while(rs.next()){
            		UsersOrders userorder = new UsersOrders();
            		userorder.setEmail(rs.getString("email"));
            		userorder.setOrderId(rs.getInt("orderid"));
            		userOrderObj.add(userorder);
                }
		}catch(SQLException e){
			e.printStackTrace();
			dbConnection.close();
		}finally{
			stmt.close();
		}
		return userOrderObj;		
	}

public ArrayList<OrdersBooks> getOrdersBooksTable() throws Exception{
	
	String tableQuery = "select * from " + MbConstants.ORDERSBOOKSTABLE;
	try{
		stmt = dbConnection.createStatement();
        rs   = stmt.executeQuery(tableQuery);
        orderBookObj = new ArrayList<OrdersBooks>();
        	while(rs.next()){
        		OrdersBooks orderBook = new OrdersBooks();
        		orderBook.setBookId(rs.getInt("bookid"));
        		orderBook.setOrderId(rs.getInt("orderid"));
        		orderBookObj.add(orderBook);
            }
	}catch(SQLException e){
		e.printStackTrace();
		dbConnection.close();
	}finally{
		stmt.close();
	}
	return orderBookObj;		
}
}