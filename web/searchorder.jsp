<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,com.atl.mb.model.OrderSummary"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>
<center>

<form method="post" action="/mastersbook/SearchOrder">
Search Your Orders By : <br>
<input type="radio" name="searchCriteria" value="EID"/>Email ID
<input type="radio" name="searchCriteria" value="OID"/>Order Id
<!-- <label for="search">Type:</label> -->
<input type="text" name="searchParameter" size="30" />
<input type="submit" value="Submit the search" />
</form>

<hr>

<table align="center" border="2">
<%
List<OrderSummary> orderList=new ArrayList<OrderSummary>();
orderList = (ArrayList)request.getAttribute("orderList");
if(orderList!=null && orderList.size()>0 ){
%>
<h2 align="center">OrderList</h2>
<tr>
<th>Email</th>
<th>OrderId</th>
<th>Title</th>
<th>Author FirstName</th>
<th>Author Last Name</th>
<th>Price</th>
</tr>
<%
for(OrderSummary order : orderList){
%>
<tr>
<td><%=order.getEmailId() %></td>
<td><%=order.getOrderId() %></td>
<td><%=order.getTitle() %></td>
<td><%=order.getAuthorFName() %></td>
<td><%=order.getAuthorLName() %></td>
<td><%=order.getPrice() %></td>
</tr>
<%
}
}else{
%>
<h3>Cannot Find Any Order for the given Search</h3>
<%}%>

</table>

</center>
</body>
</html>