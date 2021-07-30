<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="vi">
<head>

<!-- Meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">

<title>Kho EBook</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet"
	href="<c:url value="/assets/user/bootstrap/css/bootstrap.min.css" ></c:url>">

<!-- Customizable CSS -->
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/main.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/assets/user/bootstrap-select/css/bootstrap-select.min.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/assets/user/fontawesome/css/all.min.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/assets/user/owl/owl.carousel.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/assets/user/owl/owl.transitions.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/assets/user/animate/animate.min.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/assets/user/jquery-ui/jquery-ui.min.css"></c:url>">

<!-- Demo Purpose Only. Should be removed in production -->
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/config.css"></c:url>">


<link href="<c:url value="/assets/user/css/green.css"></c:url>"
	rel="alternate stylesheet" title="Green color">
<link href="<c:url value="/assets/user/css/pink.css"></c:url>"
	rel="alternate stylesheet" title="Pink color">
<link href="<c:url value="/assets/user/css/blue.css"></c:url>"
	rel="alternate stylesheet" title="Blue color">
<link href="<c:url value="/assets/user/css/red.css"></c:url>"
	rel="alternate stylesheet" title="Red color">
<link href="<c:url value="/assets/user/css/orange.css"></c:url>"
	rel="alternate stylesheet" title="Orange color">
<link href="<c:url value="/assets/user/css/dark-green.css"></c:url>"
	rel="alternate stylesheet" title="Dark Green color">
<!-- Demo Purpose Only. Should be removed in production : END -->
<!-- Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500italic,500,700,700italic,900,900italic"
	rel='stylesheet' type='text/css'>

<!-- Icons/Glyphs -->
<link rel="stylesheet"
	href="<c:url value="/assets/user/elegant-fonts/css/elegant-fonts.css"></c:url>">

<!-- Favicon -->
<link rel="shortcut icon"
	href="<c:url value="/assets/user/images/favicon.ico"></c:url>">

</head>
<body>

	<div class="wrapper">
		<!-- ============================================================= HEADER ============================================================= -->
		<%@include file="/views/layouts/user/header.jsp"%>
		<!-- ============================================================= HEADER : END ============================================================= -->
		<div class="content">

			<decorator:body />

			<a class="scrollup hidden-xs hidden-sm" href="#"
				style="display: none;"><img
				src="<c:url value="/assets/user/images/top-scroll.png"></c:url>"
				alt=""></a>
		</div>

		<!-- ============================================================= FOOTER ============================================================= -->
		<%@include file="/views/layouts/user/footer.jsp"%>
		<!-- ============================================================= FOOTER : END ============================================================= -->
	</div>
	<!-- /.wrapper -->
	<!-- For demo purposes – can be removed on production -->

	<div class="config open">
		<div class="config-options">
			<h4>Colors</h4>
			<ul class="list-unstyled">
				<li><a class="changecolor green-text" href="#"
					title="Green color">Green</a></li>
				<li><a class="changecolor pink-text" href="#"
					title="Pink color">Pink</a></li>
				<li><a class="changecolor blue-text" href="#"
					title="Blue color">Blue</a></li>
				<li><a class="changecolor red-text" href="#" title="Red color">Red</a></li>
				<li><a class="changecolor orange-text" href="#"
					title="Orange color">Orange</a></li>
				<li><a class="changecolor dark-green-text" href="#"
					title="Dark Green color">Dark Green</a></li>
			</ul>
		</div>
		<a class="show-theme-options" href="#"><i class="fas fa-cog"></i></a>
	</div>
	<!-- For demo purposes – can be removed on production : End -->
	<!-- JavaScripts placed at the end of the document so the pages load faster -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

	<script
		src="<c:url value="/assets/user/jquery/jquery-1.12.1.min.js"></c:url>"></script>
	<script
		src="<c:url value="/assets/user/bootstrap/js/bootstrap.min.js"></c:url>"></script>
	<script
		src="<c:url value="/assets/user/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"></c:url>"></script>
	<script src="<c:url value="/assets/user/echo/echo.min.js"></c:url>"></script>
	<script
		src="<c:url value="/assets/user/jquery-easing/jquery.easing.min.js"></c:url>"></script>
	<script
		src="<c:url value="/assets/user/owl/owl.carousel.min.js"></c:url>"></script>
	<script src="<c:url value="/assets/user/wow/wow.min.js"></c:url>"></script>
	<script
		src="<c:url value="/assets/user/bootstrap-select/js/bootstrap-select.min.js"></c:url>"></script>
	<script
		src="<c:url value="/assets/user/jquery-ui/jquery-ui.min.js"></c:url>"></script>
	<script src="<c:url value="/assets/user/js/scripts.js"></c:url>"></script>

	<!-- For demo purposes – can be removed on production -->

	<script
		src="<c:url value="/assets/user/js/switchstylesheet.js"></c:url>"></script>

	<script>
		$(document).ready(function() {
			$(".changecolor").switchstylesheet({
				seperator : "color"
			});
			$('.show-theme-options').click(function() {
				$(this).parent().toggleClass('open');
				return false;
			});
		});

		$(window).bind("load", function() {
			$('.show-theme-options').delay(2000).trigger('click');
		});
	</script>
	<!-- For demo purposes – can be removed on production : End -->

</body>
</html>