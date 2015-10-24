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

	public List<Books> getAllBooks() {
        List<Books> booksList = new ArrayList<Books>();

        String query = "SELECT * FROM Books ORDER BY BOOKID";
        try {
                Statement stmt = dbConnection.createStatement();
                ResultSet rs = stmt.executeQuery(query);
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

}