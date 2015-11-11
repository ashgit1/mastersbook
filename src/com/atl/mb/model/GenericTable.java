package com.atl.mb.model;

public class GenericTable{

	/**
	 *  Books variable...
	 */
	private int bookId;
	private String title;
	private String authorFName;
	private String authorLName;
	private String category;
	private String description;
	private String publisher;
	private int price;
	
	/**
	 *  Orders variable...
	 */	
	private int orderId;
	private String orderDate;
	private String shipAddress;
	private int totalPrice;
	private String status;

	/**
	 *  Users variable...
	 */
	private String email;
	private String fname;
	private String lname;
	private String phone;
	
	/**
	 * Getters and setters of all models.
	 */
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getShipAddress() {
		return shipAddress;
	}
	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}