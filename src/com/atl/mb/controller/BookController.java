package com.atl.mb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atl.mb.dao.BookDao;
import com.atl.mb.model.Books;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
	BookDao dao = new BookDao();

    /**
     * Default constructor. 
     */
    public BookController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
        if ( action != null) 
        {
        	List<Books> booksList = new ArrayList<Books>();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            response.setContentType("application/json");
            
            if (action.equals("list")) 
            {
            	try
                {                                                                       
                // Fetch Data from Books Table
            	booksList = dao.getAllBooks();
                //Return in the format required by jTable plugin
                JSONROOT.put("Result", "OK");
                JSONROOT.put("Records", booksList);
                // Convert Java Object to Json
                String jsonArray = gson.toJson(JSONROOT);
                System.out.println(jsonArray);

                response.getWriter().print(jsonArray);
                }
                catch(Exception ex){
                        JSONROOT.put("Result", "ERROR");
                        JSONROOT.put("Message", ex.getMessage());
                        String error = gson.toJson(JSONROOT);
                        response.getWriter().print(error);
                }    
            }
            if (action.equals("create") || action.equals("update")) {
            	try{
            	        Books book = new Books();
            	        if (request.getParameter("bookId") != null) {
            	                int bookId = Integer.parseInt(request.getParameter("bookId"));
            	                book.setBookId(bookId);
            	        }

            	        if (request.getParameter("title") != null) {
            	                String title = request.getParameter("title");
            	                book.setTitle(title);
            	        }

            	        if (request.getParameter("authorFName") != null) {
            	                String authorFName = request.getParameter("authorFName");
            	                book.setAuthorFName(authorFName);
            	        }
            	        if (request.getParameter("authorLName") != null) {
            	                String authorLName = request.getParameter("authorLName");
            	                book.setAuthorLName(authorLName);
            	        }

            	        if (request.getParameter("category") != null) {
        	                String category = request.getParameter("category");
        	                book.setCategory(category);
        	        }
            	        if (request.getParameter("description") != null) {
        	                String description = request.getParameter("description");
        	                book.setDescription(description);
        	        }
            	        if (request.getParameter("publisher") != null) {
        	                String publisher = request.getParameter("publisher");
        	                book.setPublisher(publisher);
        	        }
            	        if (request.getParameter("price") != null) {
        	                int price = Integer.parseInt(request.getParameter("price"));
        	                book.setPrice(price);
        	        }

            	        if (action.equals("create")) {
            	                // Create new record
            	                dao.addBook(book);
            	        } else if (action.equals("update")) {
            	                // Update existing record
            	                dao.updateBook(book);
            	        }

            	        // Return in the format required by jTable plugin
            	        JSONROOT.put("Result", "OK");
            	        JSONROOT.put("Record", book);

            	        // Convert Java Object to Json
            	        String jsonArray = gson.toJson(JSONROOT);
            	        response.getWriter().print(jsonArray);
            	} catch (Exception ex) {
            	        JSONROOT.put("Result", "ERROR");
            	        JSONROOT.put("Message", ex.getMessage());
            	        String error = gson.toJson(JSONROOT);
            	        response.getWriter().print(error);
            	}
            	}
            
            if (action.equals("delete")) {
            	try{
            	        // Delete record
            	        if (request.getParameter("bookId") != null) {
            	                int bookId = Integer.parseInt(request.getParameter("bookId"));
            	                dao.deleteBook(bookId);

            	                // Return in the format required by jTable plugin
            	                JSONROOT.put("Result", "OK");

            	                // Convert Java Object to Json
            	                String jsonArray = gson.toJson(JSONROOT);
            	                response.getWriter().print(jsonArray);
            	        }
            	} catch (Exception ex) {
            	        JSONROOT.put("Result", "ERROR");
            	        JSONROOT.put("Message", ex.getMessage());
            	        String error = gson.toJson(JSONROOT);
            	        response.getWriter().print(error);
            	}
            	}
        }
	}

}
