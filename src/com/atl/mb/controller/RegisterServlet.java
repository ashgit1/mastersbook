package com.atl.mb.controller;

import java.io.IOException;
import java.io.PrintWriter;
/*import java.sql.SQLIntegrityConstraintViolationException;*/
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.atl.mb.dao.RegisterDao;
import com.atl.mb.daoimpl.RegisterDaoImpl;
import com.atl.mb.model.Users;
import com.atl.mb.util.EmailValidator;

/**
 * Servlet implementation class RegisterServlet
 */
/*@WebServlet("/RegisterServlet")*/
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    RegisterDao regDao;   
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
    
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	processRequest(request, response);
	}

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String fname, lname, email, pass, passAgain, mobileNum, message, messageDetail;
        message = null;
        messageDetail = null;
        boolean isRegistered = false;
        PrintWriter out = response.getWriter();
        HttpSession userSession = request.getSession();
    
        String messageUrl = "/message.jsp";
        RequestDispatcher dispatchMessage = request.getServletContext().getRequestDispatcher(messageUrl);
        
        fname = request.getParameter("regFname");
        lname = request.getParameter("regLname");
        email = request.getParameter("regEmail");		
        pass  = request.getParameter("regPass");		
        passAgain = request.getParameter("regPassAgain");
        mobileNum = request.getParameter("regMobile");
        
        EmailValidator validator = new EmailValidator();
        boolean isEmailValid = validator.validate(email);
        
        try {
        
            if ((request.getParameter("regEmail") != null) || (request.getParameter("regEmail") != null)){
                if (isEmailValid) {
                    if (pass.length() > 7) {
                        if (pass.equals(passAgain)) {
                        	
                        	// The user is registered and a session is set...
                        	// calls the addUser method...
                        	regDao = new RegisterDaoImpl();
                        	isRegistered = regDao.addUser(fname, lname, email, pass, mobileNum);
                        	if(isRegistered){
                        		System.out.println("You are registered ");
                                Users user = new Users();
                                user.setEmail(email);
                                userSession.setAttribute("user", user);
                                response.sendRedirect(request.getContextPath());
                        	}else{
                        		out.println("You are not registered");
                        	}
                        } //Else both passwords do not match
                        else {
                            isRegistered = false;
                            message = "Passwords do not match";
                            messageDetail = "Please provide a matching passwords";
                            out.print(" nOT Success!  both passwords do not match!");

                        }
                    } //or the paasword length is less than 7
                    else {
                        isRegistered = false;
                        message = "Password length is less than 7 characters";
                        messageDetail = "Please provide a passwords that has password length of minimum of seven alphanumeric characters";
                        out.print(" nOT Success!! the paasword length is less than 7");
                    }
                } //or email is wrong
                else {
                    isRegistered = false;
                    message = "No email address typed";
                    messageDetail = "Please provide a valid email address";
                    out.print(" nOT Success!! email is wrong");
                }
            }
            else {
                isRegistered = false;
                message = "Please enter values";
                messageDetail = "Please provide an email address. Your account currently is not registered";
            }
            
            if (isRegistered == false) {
                request.setAttribute("message", message);
                request.setAttribute("messageDetail", messageDetail);
                dispatchMessage.forward(request, response);
            }

            //try ends here
        } /*catch (SQLIntegrityConstraintViolationException ex) {
            // user exsts but wrong passwotd ask to CHANGE THE PASSWORD
            messageDetail = ex.getMessage();
            message = "You have been registered earlier please try your right password again, else change your password...";
            out.print(" nOT Success!!" + ex);
            request.setAttribute("message", message);
            request.setAttribute("messageDetail", messageDetail);
            dispatchMessage.forward(request, response);
        }*/ catch (Exception ex) {
            messageDetail = ex.getMessage();
            message = "There was a problem in registering your account please do retry again later...";
            out.print(" nOT Success!!" + ex);
            request.setAttribute("message", message);
            request.setAttribute("messageDetail", messageDetail);
            dispatchMessage.forward(request, response);
            response.sendError(404);
        }
    }
}
