package com.atl.mb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
/*import javax.servlet.annotation.WebServlet;*/
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.atl.mb.dao.SearchDao;
import com.atl.mb.model.OrderSummary;

/**
 * Servlet implementation class SearchOrder
 */
/*@WebServlet("/SearchOrder")*/
public class SearchOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    final static Logger logger = Logger.getLogger(SearchOrderController.class);   
    SearchDao searchDao = new SearchDao();
    List<OrderSummary> orderList;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String searchCriteria  = request.getParameter("searchCriteria");
		String searchParameter = request.getParameter("searchParameter"); 
		
		logger.info("searchCriteria : " + searchCriteria);
		logger.info("searchParameter : " + searchParameter);
		System.out.println("searchParameter : " + searchParameter);
		System.out.println("searchCriteria : " + searchCriteria);
		
		orderList = searchDao.getOrderDetails(searchCriteria, searchParameter);
		request.setAttribute("orderList", orderList); 
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/searchorder.jsp");
		dispatcher.forward(request, response);
	}

}
