<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="com.atl.mb.util.DBUtil"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Masters Books</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Pendent Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery-1.10.2.min.js"></script>
<!-- //js -->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/menu_jquery.js"></script>
<script src="js/simpleCart.min.js"> </script>
<link href='//fonts.googleapis.com/css?family=Monda:400,700' rel='stylesheet' type='text/css'>
</head>
	
<body>

<!-- header -->
	<%-- <jsp:include page="includesPage/mainHeaders/_header.jsp"></jsp:include> --%>

	<%
		if (session.getAttribute("user") == null) {// THen new user, show join now
	%>
	<jsp:include page="includesPage/mainHeaders/_header.jsp"></jsp:include>
	<%
		} else {
	%>
	<jsp:include page="includesPage/mainHeaders/_logout.jsp"></jsp:include>
	<%
		}
	%>
<!-- //header -->
<jsp:include page="includesPage/mainHeaders/_navigation.jsp"></jsp:include>

<!-- Product page begins -->
<!-- single-page -->
<div class="single">
<div class="container">
<%
            String id = request.getParameter("id");
			String title, bookid, category, description, publisher, imageName, price, authorfname, authorlname, imageid;
            if (request.getParameter("id") == null) {
                response.sendRedirect("products.jsp");
            }else {
            Connection c = new DBUtil().getCon();
            Statement st = c.createStatement();
            String getProductQuery = "SELECT * FROM  `books` b INNER JOIN `books_images` bi USING (`title`) WHERE  `bookid` ="+id+" GROUP BY  `title` ";
            ResultSet rs = st.executeQuery(getProductQuery);
            rs.next();
            bookid = rs.getString("bookid");
            //int product_hits = rs.getInt("hits");
            title = rs.getString("title");
            category = rs.getString("category");
            publisher = rs.getString("publisher");
            price = rs.getString("price");
            description = rs.getString("description");
            imageName = rs.getString("imagename");
            authorfname = rs.getString("authorfname");
            authorlname = rs.getString("authorlname");
            imageid = rs.getString("imageid");
        %>
<div class="single-page">					 
		<div class="flexslider details-lft-inf">
			<ul class="slides">
			<%
                String getImages = "SELECT `imagename` FROM  `books` INNER JOIN  `books_images` USING (`title`) WHERE  `bookid` = " + bookid + " LIMIT 1,4";
                rs.close();
                rs = st.executeQuery(getImages);/* 
                int img_number = 1;
                rs.next(); */
                // GET THE REST OF THE Books IMAGES
                while (rs.next()) {
                	imageName = rs.getString("imagename");
                %>
				<li data-thumb="<%= imageName %>">
					<img src="<%= imageName %>" />
				</li>
			<%
			}%>
			</ul>
		</div>
			<!-- FlexSlider -->
			  <script defer src="js/jquery.flexslider.js"></script>
			<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

			<script>
			// Can also be used with $(document).ready()
			$(window).load(function() {
			  $('.flexslider').flexslider({
				animation: "slide",
				controlNav: "thumbnails"
			  });
			});
			</script>
		<div class="details-left-info">
			<h3><%= title %></h3>
				<h4>by <%= authorfname %> <%= authorlname %></h4>
			<div class="simpleCart_shelfItem">
				<p><span class="item_price qwe">Rs <%= price %></span> <a href="#">Click for offer</a></p>
				<div class="flower-type">
					<p>Publisher  :: <a href="#"><%= publisher %></a></p>
					<p>Category  :: <a href="#"><%= category %></a></p>
				</div>
				
				<p class="qty">Qty ::</p><input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
				<div class="single-but item_add">
					<input type="submit" value="add to cart">
				</div>
			</div>
			
			<p class="desc"><%= description %></p>
		</div>
		<div class="clearfix"></div>				 	
	</div>
<% }
 %>
 </div>
 </div>
<!-- Product Page Ends -->
	
<jsp:include page="includesPage/mainHeaders/_footer.jsp"></jsp:include>

</body>
</html>