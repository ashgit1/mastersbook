<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,com.atl.mb.model.OrderSummary"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script>

function checkSearchParameter(){

	var searchParameter = document.getElementById('searchParameterID');
	if($('input:radio:checked').length == 0){
		alert('Please select a search criteria to continue');
		return false;
	}else if(searchParameter.value==""){
		alert('Please enter search criteria');
		searchParameter.focus();
		return false;
	}else if(searchParameter.value!=""){
		if(checkValueBasedOnSelection(searchParameter.value)==false){
			return false;
		}
	}
}

function checkValueBasedOnSelection(value){
	
	//alert("value id check : " + value);
	var searchParameter  = document.getElementById("searchParameterID");
	
	if(document.getElementById('eid').checked) {
			//alert(" eid is selected...");
			if(checkEmail(value)==false){
				return false;	
			}
		}else if(document.getElementById('oid').checked) {
			//alert(" oid is selected...");
			if(num_req(searchParameter,"Please enter valid Order Id")==false){
				searchParameter.value="";
				searchParameter.focus();
				return false;
				}
		}
}

function num_req(field,alertmsg)
{
		with(field)
		{
			if(isNaN(value)==true)
				{
				alert(alertmsg);
				return false;
				}
			else
				{
				return true;
				}
		} 
}

function checkEmail(value){
	
	  var email=value;
	  var searchParameter  = document.getElementById("searchParameterID");
	  //alert("in check email : " + email);
	  var atpos=email.indexOf("@");
	  var dotpos=email.lastIndexOf(".");
		if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length){
	  		alert("Not a valid e-mail address!!! Please enter a valid e-mail address");
	  		searchParameter.focus();
	  		return false;
	  	}
	}

</script>
</head>
<body>
<center>

<form method="post" action="/mastersbook/SearchOrder">
Search Your Orders By : <br>
<input type="radio" name="searchCriteria" id="eid" value="EID"/>Email ID
<input type="radio" name="searchCriteria" id="oid" value="OID"/>Order Id
<!-- <label for="search">Type:</label> -->
<input type="text" name="searchParameter" id="searchParameterID" size="30" />
<input type="submit" value="Submit the search" onclick="return checkSearchParameter();"/>
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