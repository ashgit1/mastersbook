<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<!-- Navigation-->
	<jsp:include page="includesPage/mainHeaders/_navigation.jsp"></jsp:include>
<!-- Navigation End-->

<!-- cate -->
	<div class="cate">
		<div class="container">
			<div class="cate-left">
				<h3>Books<span>Our Catelog</span></h3>
			</div>
			<div class="cate-right">
				<!-- slider -->
				<ul id="flexiselDemo1">			
					<li>
						<div class="sliderfig-grid">
							<img src="images/slider/book1.jpg" alt=" " class="img-responsive" />
						</div>
					</li>
					<li>
						<div class="sliderfig-grid">
							<img src="images/slider/book2.jpg" alt=" " class="img-responsive" />
						</div>
					</li>
					<li>
						<div class="sliderfig-grid">
							<img src="images/slider/book3.jpg" alt=" " class="img-responsive" />
						</div>
					</li>
					<li>
						<div class="sliderfig-grid">
							<img src="images/slider/book4.jpg" alt=" " class="img-responsive" />
						</div>
					</li>
					</ul>
					<script type="text/javascript">
							$(window).load(function() {
								$("#flexiselDemo1").flexisel({
									visibleItems: 4,
									animationSpeed: 1000,
									autoPlay: true,
									autoPlaySpeed: 3000,    		
									pauseOnHover: true,
									enableResponsiveBreakpoints: true,
									responsiveBreakpoints: { 
										portrait: { 
											changePoint:480,
											visibleItems: 3
										}, 
										landscape: { 
											changePoint:640,
											visibleItems:4
										},
										tablet: { 
											changePoint:768,
											visibleItems: 3
										}
									}
								});
								
							});
					</script>
					<script type="text/javascript" src="js/jquery.flexisel.js"></script>
			</div>
<!-- //slider -->
			<div class="clearfix"> </div>
		</div>
	</div>
	<br>
<!-- //cate -->
<!-- welcome -->
	<div class="welcome">
		<div class="container">
			<div class="welcome-info">
				<h3>Welcome To Our Store!</h3>
				<p class="non">We offer books at cheap price<span>Return Facility Guaranteed.</span></p>
				<p class="rep">First purchase from Us and then return.</p>
				<div class="buy wel">
					<a href="about_us.jsp">Read More</a>
				</div>
			</div>
		</div>
	</div>
	<br><br>
<!-- //welcome -->

<!-- banner-bottom -->
	<jsp:include page="includesPage/mainHeaders/topViewedBooks.jsp"></jsp:include>
<!-- banner-bottom -->

<!-- footer -->
<jsp:include page="includesPage/mainHeaders/_footer.jsp"></jsp:include>
<!-- //footer -->
</body>
</html>