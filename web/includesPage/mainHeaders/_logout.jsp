<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.atl.mb.model.*"%>

<%
Users user = (Users) session.getAttribute("user");
String email = user.getEmail();
String userName = user.getFname() + user.getLname();
%>

<!-- top-header -->
<div class="top_bg">
	<div class="container">
		<div class="header_top-sec">
			<div class="top_right">
				<ul>
					<li><a href="contact_us.jsp">Contact</a></li>|
					<li><a href="track_order.jsp">Track Order</a></li>
				</ul>
			</div>
			<div class="top_left">
				<ul>
					<li class="top_link">Email:<a href="mailto:<%=email%>"><%=email%></a></li>| 
					<li class="top_link"><a href="logoutServlet">Logout</a></li>					
				</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
</div>
<!-- top-header -->

<!-- logo-cart -->
<div class="header_top">
	<div class="container">
		<div class="logo">
		 	<a href="index.jsp">Masters Books</a>			 
		</div>
		<div class="header_right">
			<div class="cart box_1">
				<a href="checkout.html">
				<h3> <div class="total">
					<span class="simpleCart_total"></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"></span> items)</div>
					<img src="images/cart1.png" alt=""/></h3>
				</a>
				<p><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>
				<div class="clearfix"> </div>
			</div>				 
		</div>
		<div class="clearfix"></div>	
	</div>
</div>
<!-- //logo-cart --><!-- header -->