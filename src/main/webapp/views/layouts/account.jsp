<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Login</title>

<!-- Custom fonts for this template-->
<link
	href="<c:url value="/assets/admin/vendor/fontawesome-free/css/all.min.css"></c:url>"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<c:url value="/assets/admin/css/sb-admin-2.min.css"></c:url>"
	rel="stylesheet">

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<decorator:body />

	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="<c:url value="/assets/admin/vendor/jquery/jquery.min.js"></c:url>"></script>
	<script
		src="<c:url value="/assets/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></c:url>"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value="/assets/admin/vendor/jquery-easing/jquery.easing.min.js"></c:url>"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value="/assets/admin/js/sb-admin-2.min.js"></c:url>"></script>

</body>

</html>
