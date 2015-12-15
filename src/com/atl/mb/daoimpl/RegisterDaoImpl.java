package com.atl.mb.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

import com.atl.mb.dao.RegisterDao;
import com.atl.mb.util.DBUtil;

public class RegisterDaoImpl implements RegisterDao{
	
	private Connection dbConnection;
	private PreparedStatement pStmt;
	boolean isRegistered;
	
	public RegisterDaoImpl(){
		dbConnection = DBUtil.getCon();
	}

	@Override
	public boolean addUser(String fname, String lname, String email, String pass,
			String mobileNum) {

		
	    System.out.println("emmail: " + email);
	    System.out.println("pass: " + pass);
	        
        String addUserSql = "INSERT INTO `users` "
                + "(`email`, `password`, `fname`, `lname`, `phone`) "
                + "VALUES (?, ?, ?, ?, ?); ";
        
        System.out.println("Reg query: " + addUserSql);

        try{
        	pStmt = dbConnection.prepareStatement(addUserSql);

        	pStmt.setString(1, email);
        	pStmt.setString(2, pass);
        	pStmt.setString(3, fname);
        	pStmt.setString(4, lname);
        	pStmt.setString(5, mobileNum);

             int i = pStmt.executeUpdate();

             if (i == 1) {
                 isRegistered = true;
             } else {
                 isRegistered = false;
             }
        }
        catch (SQLIntegrityConstraintViolationException ex) {
            // user exsts but wrong passwotd ask to CHANGE THE PASSWORD
            /*messageDetail = ex.getMessage();
            message = "You have been registered earlier please try your right password again, else change your password...";
            out.print(" nOT Success!!" + ex);
            request.setAttribute("message", message);
            request.setAttribute("messageDetail", messageDetail);
            dispatchMessage.forward(request, response);*/
        	System.out.println(ex.getMessage());
        }catch(Exception ex){
        	System.out.println(ex.toString());
        }
		return isRegistered;
	}
}
