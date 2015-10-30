package com.atl.mb.model;

public class OrderSummary {

	private String	emailId;
	private int   	orderId;
	private String	title;
	private String	authorFName;
	private String	authorLName;
	private int		price;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorFName() {
		return authorFName;
	}
	public void setAuthorFName(String authorFName) {
		this.authorFName = authorFName;
	}
	public String getAuthorLName() {
		return authorLName;
	}
	public void setAuthorLName(String authorLName) {
		this.authorLName = authorLName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
