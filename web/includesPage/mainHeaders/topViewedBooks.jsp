<%-- 
    Document   : topViewedBooks
    Author     : Ashish
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.atl.mb.util.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>

<style type="text/css">
.prodGrid {
	margin: 10px;
	margin-right: -12px;
	margin-left: 36px;
}
</style>
<center>
<a href="products.jsp">
	<h2 class="heading">Top Most Viewed Books</h2>
	<hr/>
</a>
</center>
<div class="clear"></div>
<%
	String sqlTopMostBooks = "SELECT * " + " FROM  `books` b"
			+ " INNER JOIN  `books_images` bi" + " USING (  `title` ) group by `title` order by `title` desc "
			+ " LIMIT 0,6 ";

	ArrayList<String> topMost = new ArrayList<String>();
	topMost.clear();
	Connection c = new DBUtil().getCon();
	Statement st = c.createStatement();
	ResultSet rs = st.executeQuery(sqlTopMostBooks);
	String title, bookid, category, description, publisher, imageName, price;
	int i = 1;
%> 
 <div class="banner-bottom">
		<div class="container">
			<div class="product-one">
 <%
 while (rs.next()){ 
     
      price = rs.getString("price");
      imageName = rs.getString("imagename");
      bookid = rs.getString("bookid");
      title = rs.getString("title");
      category = rs.getString("category");
      description = rs.getString("description");
      publisher = rs.getString("publisher");
      %>
				<div class="col-md-2 product-left"> 
					<div class="p-one simpleCart_shelfItem jwe">							
							<a href="view_product.jsp?id=<%= bookid %>">
								<img src="<%= imageName %>" alt="<%= title %>" class="img-responsive" />
								<div class="mask">
									<span>Quick View</span>
								</div>
							</a>
						<div class="product-left-cart">
							<div class="product-left-cart-l">
								<p><a class="item_add" href="#"><i></i> 
								<span class=" item_price">Rs. <%= price %></span></a></p>
							</div>
							<div class="product-left-cart-r">
								<a href="#"> </a>
							</div>
							<div class="clearfix"> </div>
						</div>
					</div>
				</div>
		<%}%>		
			</div>	
		</div>
</div>    
 <% 
 if (i == 0){
%>
	<div class="clear"></div>
	<div id="productList" class="grid_3 prodGrid">
		<a href="view_product.jsp"><img src="images/textures/linen.png" /></a>
		<p id="info">
			<a href="view_product.jsp?id="><span class="blue">No
					Product Added in Database</span></a><br /> <br /> <span class="red">Rs.
				0</span>
		</p>
	</div>
	<%
}
%>
