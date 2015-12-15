package com.atl.mb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atl.mb.model.Users;
import com.atl.mb.util.DBUtil;

/**
 * Servlet implementation class LoginServlet
 */
/*@WebServlet("/loginServlet")*/
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

        //processRequest(request, response);
        String email, pass;
        String db_email, db_pass;
        boolean isLoggedIn = false;
        HttpSession userSession = request.getSession();
        PrintWriter out = response.getWriter();
        email = request.getParameter("mbemail");
        pass = request.getParameter("mbpassword");
        String message, messageDetail;
        message = "";
        messageDetail = "";
        
        String messageUrl = "/message.jsp";
        RequestDispatcher dispatchMessage =
                 request.getServletContext().getRequestDispatcher(messageUrl);
        
        try {
            
           /* pass = SecureSHA1.getSHA1(pass);*/
            out.println("email " + email + " pass " + pass);
            DBUtil con = new DBUtil();
            Connection c = con.getCon();
            String sqlGetUsers = "SELECT  `email` , `password` FROM  `users` ";

            PreparedStatement st = c.prepareStatement(sqlGetUsers);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                db_email = rs.getString("email");
                db_pass = rs.getString("password");

                if (email.equals(db_email)) {
                    message = "Your email-id exists with us!";
                    //you exist with us
                    if (pass.equals(db_pass)) {
                        isLoggedIn = true;
                        //user exists and password is matching
                        out.print("You are logged in");
                        Users user = new Users();
                        user.setEmail(email);
                        userSession.setAttribute("user", user);
                        response.sendRedirect(request.getContextPath()+"/index.jsp");
                      }
                    else {
                        isLoggedIn = false;
                        // user exsts but wrong passwotd ask to CHANGE THE PASSWORD
                        message = "Wrong Password...!";
                        messageDetail = "Password does not match with the password during registeration... Please re-login with correct password";
                        out.println("wrong password Change the password now <a href = 'changeMyPassword.jsp'>Change</a>");
                        break;
                    }
                }
                else {
                    //or there no such email YOu do not exist with us Create an account now!!
                    out.println(" no such email Register an account now!");
                    message = "Email does not exists";
                    messageDetail = "Please register with us right now to buy items on the go!";
                    isLoggedIn = false;
                }
            }
            
            if (isLoggedIn == false){
                request.setAttribute("message", message);
                request.setAttribute("messageDetail", messageDetail);
                dispatchMessage.forward(request, response);
            }
        } catch (SQLException e) {
            out.println(" Problem in the process execution...");
            //response.sendError(404);
            message = "An Error occoured during the process of login";
            messageDetail = "We are extremely sorry to have this but we had an error during your process of login please do try after some time,";
                   
            request.setAttribute("message", message);
            request.setAttribute("messageDetail", messageDetail);
            dispatchMessage.forward(request, response);
        
        } catch (Exception e) {
            out.println(" Problem in the process execution...");
            //response.sendError(404);
        }
    
	
	}

}
