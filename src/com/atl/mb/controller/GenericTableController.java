package com.atl.mb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atl.mb.constants.MbConstants;
import com.atl.mb.dao.TableDao;
import com.atl.mb.model.Books;
import com.atl.mb.model.Orders;
import com.atl.mb.model.OrdersBooks;
import com.atl.mb.model.Users;
import com.atl.mb.model.UsersOrders;

/**
 * Servlet implementation class GenericTableController
 */
//@WebServlet("/GenericTableController")
public class GenericTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Books> booksList;
	ArrayList<Users>  usersList;
	ArrayList<Orders> ordersList;
	private ArrayList<UsersOrders> userOrderList;
	private ArrayList<OrdersBooks> orderBookList;
	
	TableDao tableDao = new TableDao();
	 
	
	public GenericTableController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tableName = request.getParameter("tableName");
		System.out.println("Selected Table : " + tableName);
		
		
		try {
			if(tableName.equals(MbConstants.BOOKSTABLE)){
				booksList = tableDao.getBooksTable1();
				request.setAttribute("bookList", booksList);
			}else if(tableName.equals(MbConstants.USERSTABLE)){
				usersList = tableDao.getUsersTable();
				request.setAttribute("usersList", usersList);
			}else if(tableName.equals(MbConstants.ORDERSTABLE)){
				ordersList = tableDao.getOrdersTable();
				request.setAttribute("ordersList", ordersList);
			}else if(tableName.equals(MbConstants.USERSORDERSTABLE)){
				userOrderList = tableDao.getUsersOrdersTable();
				request.setAttribute("userOrderList", userOrderList);
			}else if(tableName.equals(MbConstants.ORDERSBOOKSTABLE)){
				orderBookList = tableDao.getOrdersBooksTable();
				request.setAttribute("orderBookList", orderBookList);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/backmodels.jsp");
		dispatcher.forward(request, response);
	
	}

}
