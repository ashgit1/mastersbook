package com.atl.mb.dao;


public interface RegisterDao {

	public boolean addUser(String fname, String lname, String email, String pass, String mobileNum);
}
