<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Contact US</title>
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

<!-- Navigation-->
	<jsp:include page="includesPage/mainHeaders/_navigation.jsp"></jsp:include>
<!-- Navigation End-->

<!-- contact -->
	<!-- <div class="contact-bottom">
		<iframe src="https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d96908.54934770924!2d-73.74913540000001!3d40.62123259999999!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1sanimal+rescue+service+near+Inwood%2C+New+York%2C+NY%2C+United+States!5e0!3m2!1sen!2sin!4v1436335928062" frameborder="0" style="border:0" allowfullscreen></iframe>
	</div> -->
	<div class="contact">
		<div class="container">
			<div class="col-md-4 contact-left">
				<h3>Address</h3>
				<p>Plot # 24, BTM Layout, 1st stage, 10th main, Udipi Garden.
					<span>Bangalore, Karnataka, IND</span></p>
				<ul>
					<li>Free Phone :(+91) 987-654-3210</li>
					<li>Telephone  :(+91) 985-623-1470</li>
					<!-- <li>Fax :+1 078 4589 2456</li> -->
					<li><a href="mailto:buybooks@mastersbook.in">
							<font color="#3B5998">buybooks@mastersbook.in</font>
						</a>
					</li>
				</ul>
			</div>
			<div class="col-md-8 contact-left">
				<h3>Contact Form</h3>
				<form>
					<input type="text" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}" required="">
					<input type="email" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="">
					<input type="text" value="Telephone" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Telephone';}" required="">
					<textarea type="text"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message...';}" required="">Message...</textarea>
					<input type="submit" value="Submit" >
				</form>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //contact -->

<!-- footer -->
<jsp:include page="includesPage/mainHeaders/_footer.jsp"></jsp:include>
<!-- //footer -->
</body>
</html>