package com.atl.mb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="books") 
public class Books {
	
	@Id 
	@Column(name="bookId", nullable = false)
	private int bookId;
	
	@Column(name="title", nullable = false)
	private String title;
	
	@Column(name="authorFName", nullable = false)
	private String authorFName;
	
	@Column(name="authorLName", nullable = false)
	private String authorLName;

	@Column(name="category", nullable = false)
	private String category;

	@Column(name="description", nullable = false)
	private String description;

	@Column(name="publisher", nullable = false)
	private String publisher;

	@Column(name="price", nullable = false)
	private int price;

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
	
}
