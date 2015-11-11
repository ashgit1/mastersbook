<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*,com.atl.mb.model.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Back Models</title>

<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css">  
<script type="text/javascript" charset="utf8" src="//code.jquery.com/jquery-1.11.3.min.js"></script> 
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>

<link rel="stylesheet" href="css/main.css">
<script src="js/tableToExcel.js"></script>

<script>
$(document).ready( function () {
	$('#table_id').DataTable();
} );

function checkTableClicked(){
	if($('input:radio:checked').length > 0){
		return true;
	}else{
		alert('Please select a model to continue');
		return false;
	}
}
</script>
</head>
<body>
<center>

<form method="post" action="/mastersbook/GetTable">
SELECT MODEL TO BE BACKED UP: <br><br>
<input type="radio" name="tableName" value="users"/>Users
<input type="radio" name="tableName" value="books"/>Books
<input type="radio" name="tableName" value="orders"/>Orders
<input type="radio" name="tableName" value="users_orders"/>Users_Orders
<input type="radio" name="tableName" value="orders_books"/>Orders_books
<!-- <label for="search">Type:</label> -->
<input type="submit" value="Get the Model" onclick="return checkTableClicked();" />
</form>

<hr>
<br>

<table id="table_id" class="display" cellspacing="0" width="100%" border="1">
<%
List<Books> booksList   			= new ArrayList<Books>();
List<Users> usersList   			= new ArrayList<Users>();
List<Orders> ordersList 			= new ArrayList<Orders>();
List<UsersOrders> usersOrdersList 	= new ArrayList<UsersOrders>();
List<OrdersBooks> ordersBooksList 	= new ArrayList<OrdersBooks>();

booksList  		= (ArrayList)request.getAttribute("bookList");
usersList  		= (ArrayList)request.getAttribute("usersList");
ordersList 		= (ArrayList)request.getAttribute("ordersList");
usersOrdersList = (ArrayList)request.getAttribute("userOrderList");
ordersBooksList = (ArrayList)request.getAttribute("orderBookList");

if(booksList!=null && booksList.size()>0 ){
%>
<!-- <h2 align="center">Books</h2> -->
<thead>
<tr>
<th>Book Id</th>
<th>Title</th>
<th>Author FirstName</th>
<th>Author Last Name</th>
<th>Category</th>
<th>Description</th>
<th>Publisher</th>
<th>Price</th>
</tr>
</thead>
<%
for(Books book : booksList){
%>
<tbody>
<tr>
<td><%= book.getBookId() %></td>
<td><%= book.getTitle()%></td>
<td><%= book.getAuthorFName() %></td>
<td><%= book.getAuthorLName() %></td>
<td><%= book.getCategory() %></td>
<td><%= book.getDescription() %></td>
<td><%= book.getPublisher() %></td>
<td><%= book.getPrice() %></td>
</tr>
</tbody>
<%
}
}else if(usersList!=null && usersList.size()>0 ){
%>
<!-- <h2 align="center">Users</h2> -->
<thead>
<tr>
<th>Email</th>
<th>First Name</th>
<th>Last Name</th>
<th>Contact</th>
</tr>
</thead>
<%
for(Users user : usersList){
%>
<tbody>
<tr>
<td><%= user.getEmail() %></td>
<td><%= user.getFname() %></td>
<td><%= user.getLname() %></td>
<td><%= user.getPhone() %></td>
</tr>
<tbody>
<%
}
}else if(ordersList!=null && ordersList.size()>0 ){
%>
<!-- <h2 align="center">Orders</h2> -->
<thead>
<tr>
<th>Order Id</th>
<th>Order Date</th>
<th>Shipping Adress</th>
<th>Total Price</th>
<th>Order Status</th>
</tr>
<thead>
<%
for(Orders order : ordersList){
%>
<tbody>
<tr>
<td><%= order.getOrderId() %></td>
<td><%= order.getOrderDate() %></td>
<td><%= order.getShipAddress() %></td>
<td><%= order.getTotalPrice() %></td>
<td><%= order.getStatus() %></td>
</tr>
<tbody>
<%
}

}else if(usersOrdersList!=null && usersOrdersList.size()>0 ){
%>
<!-- <h2 align="center">Orders</h2> -->
<thead>
<tr>
<th>Email Id</th>
<th>Order Id</th>
</tr>
<thead>
<%
for(UsersOrders userOrder : usersOrdersList){
%>
<tbody>
<tr>
<td><%= userOrder.getEmail() %></td>
<td><%= userOrder.getOrderId() %></td>
</tr>
<tbody>
<%
}

}else if(ordersBooksList!=null && ordersBooksList.size()>0 ){
%>
<!-- <h2 align="center">Orders</h2> -->
<thead>
<tr>
<th>Order Id</th>
<th>Book Id</th>
</tr>
<thead>
<%
for(OrdersBooks orderbook : ordersBooksList){
%>
<tbody>
<tr>
<td><%= orderbook.getOrderId() %></td>
<td><%= orderbook.getBookId() %></td>
</tr>
<tbody>
<%
}

}else{
%>
<h3>Please select a model to search</h3>
<%}%>

<!-- This ends for Orders table -->
</table>

<input type="button" class="button-export"
onclick="tableToExcel('table_id','Table Export')" value="Export to Excel" >

</center>
</body>
</html>