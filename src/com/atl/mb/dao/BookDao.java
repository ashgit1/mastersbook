package com.atl.mb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.atl.mb.model.Books;
import com.atl.mb.util.DBUtil;

public class BookDao {
	
	private Connection dbConnection;
	private PreparedStatement pStmt;
	
	public BookDao(){
		dbConnection = DBUtil.getCon();
	}
	
	public void addBook(Books book) {
        String insertQuery = "INSERT INTO books(bookid, title, authorfname, authorlname, " +
                        "category, description, publisher, price) VALUES (?,?,?,?,?,?,?,?)";
        try {
                pStmt = dbConnection.prepareStatement(insertQuery);
                pStmt.setInt(1, book.getBookId());
                pStmt.setString(2, book.getTitle());
                pStmt.setString(3, book.getAuthorFName());
                pStmt.setString(4, book.getAuthorLName());
                pStmt.setString(5, book.getCategory());
                pStmt.setString(6, book.getDescription());
                pStmt.setString(7, book.getPublisher());
                pStmt.setInt(8, book.getPrice());
                
                pStmt.executeUpdate();
        } catch (SQLException e) {
                System.err.println(e.getMessage());
        }
}

	public List<Books> getAllBooks(String title, String authorFname, int startPageIndex, int numRecordsPerPage) {
        List<Books> booksList = new ArrayList<Books>();

        String fetchBooksQuery=null;
        try {
        	
        if(title.equals("") && authorFname.equals("ALL")){
        	System.out.println("hello");
        	fetchBooksQuery = "SELECT * FROM Books ORDER BY BOOKID limit " +startPageIndex + ", " + numRecordsPerPage;
        	pStmt = dbConnection.prepareStatement(fetchBooksQuery);
        }else if(title!="" && !authorFname.equals("ALL")){
        	System.out.println("title:: " + title + ", name:: " +authorFname);
        	fetchBooksQuery = "select * from Books where title like '%" +title+ "%' and authorfname='"+authorFname+"'" +
        			          " ORDER BY BOOKID limit " +startPageIndex + ", " + numRecordsPerPage;
        	pStmt = dbConnection.prepareStatement(fetchBooksQuery);
        	//pStmt.setString(1, "%" + title + "%");//pStmt.setString(2, authorFname);
        	System.out.println("query:: " +fetchBooksQuery);
        }else if(title!="" && authorFname.equals("ALL")){
        	System.out.println("title::: " + title + ", name::: " +authorFname);
        	fetchBooksQuery="select * from books where bookid in (select bookid from books where title LIKE '%"+title+"%')" +
        			" ORDER BY BOOKID limit " +startPageIndex + ", " + numRecordsPerPage;
        	System.out.println("query::: " +fetchBooksQuery);
        }else if(title.equals("") && !authorFname.equals("ALL")){
        	System.out.println("title:::: " + title + ", name:::: " +authorFname);
        	fetchBooksQuery = "select * from books where bookid in (select bookid from books where authorfname='"+authorFname+"')" +
        			" ORDER BY BOOKID limit " +startPageIndex + ", " + numRecordsPerPage;
        	System.out.println("query:::: " +fetchBooksQuery);
        }
        
                ResultSet rs = pStmt.executeQuery(fetchBooksQuery);
                while (rs.next()) {
                	Books book = new Books();
                	book.setBookId(rs.getInt("bookid"));
                    book.setTitle(rs.getString("title"));
                    book.setAuthorFName(rs.getString("authorfname"));
                    book.setAuthorLName(rs.getString("authorlname"));
                    book.setCategory(rs.getString("category"));
                    book.setDescription(rs.getString("description"));
                    book.setPublisher(rs.getString("publisher"));
                    book.setPrice(rs.getInt("price"));
                	booksList.add(book);
                }
        } catch (SQLException e) {
                System.err.println(e.getMessage());
        }
        return booksList;
	}
	
	public void updateBook(Books book)  {
        String updateQuery = "UPDATE books SET title = ?, authorfname = ?, authorlname = ?, " +
                        "category = ?, description = ?, publisher = ?, price = ?  WHERE bookid = ?";
        try {
                pStmt = dbConnection.prepareStatement(updateQuery);             
                pStmt.setString(1, book.getTitle());
                pStmt.setString(2, book.getAuthorFName());
                pStmt.setString(3, book.getAuthorLName());
                pStmt.setString(4, book.getCategory());
                pStmt.setString(5, book.getDescription());
                pStmt.setString(6, book.getPublisher());
                pStmt.setInt(7, book.getPrice());
                pStmt.setInt(8, book.getBookId());
                pStmt.executeUpdate();

        } catch (SQLException e) {
                System.err.println(e.getMessage());
        }
	}
	
	public void deleteBook(int bookid) {
        String deleteQuery = "DELETE FROM books WHERE bookid = ?";
        try {
                pStmt = dbConnection.prepareStatement(deleteQuery);
                pStmt.setInt(1, bookid);
                pStmt.executeUpdate();
        } catch (SQLException e) {
                System.err.println(e.getMessage());
        }
	}

	public int getUserCount(String title, String authorFname) {
		
		String countQuery = "select count(*) as count from books";
		int count=0;
		
		try {
		if(title.equals("") && authorFname.equals("ALL")){
        	countQuery = "select count(*) as count from books";
        	pStmt = dbConnection.prepareStatement(countQuery);
        }else if(title!="" && !authorFname.equals("ALL")){
        	countQuery = "select count(*) as count from books where title like '%" +title+ "%' and authorfname='"+authorFname+"'";
        	pStmt = dbConnection.prepareStatement(countQuery);
        }else if(title!="" && authorFname.equals("ALL")){
        	countQuery="select count(*) as count from books where bookid in (select bookid from books where title LIKE '%"+title+"%')";
        }else if(title.equals("") && !authorFname.equals("ALL")){
        	countQuery = "select count(*) as count from books where bookid in (select bookid from books where authorfname='"+authorFname+"')";
        }
		
			 Statement stmt = dbConnection.createStatement();
             ResultSet rs = stmt.executeQuery(countQuery);
             
		   while (rs.next()) {
		   count=rs.getInt("count");
		  }
		 } catch (SQLException e) {
		  e.printStackTrace();
		 }
		 return count;
		
	}

}