<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="com.atl.mb.util.DBUtil"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MB Register</title>
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

<jsp:include page="includesPage/mainHeaders/_header.jsp"></jsp:include>
<jsp:include page="includesPage/mainHeaders/_navigation.jsp"></jsp:include>

<!-- Message block -->
<%

        if ((request.getAttribute("message") == null) || (request.getAttribute("messageDetails") == null)){
        // if email session is set, Dont show the message redirect to index
        //response.sendRedirect("/mastersbook/index.jsp");
        }
%>
<center>
<div style="padding: 10px;" class="grid_7 push_5 BigRed">
	<h1>
		<%
			out.print(request.getAttribute("message"));
		%>
	</h1>
	<h5 style="padding: 10px;">
		<%
			out.print(request.getAttribute("messageDetail"));
		%>
	</h5>
</div>
<a href="mbregister.jsp">--> Register</a>	
</center>
	
<!-- Message block ends -->

<jsp:include page="includesPage/mainHeaders/_footer.jsp"></jsp:include>
</body>
</html>