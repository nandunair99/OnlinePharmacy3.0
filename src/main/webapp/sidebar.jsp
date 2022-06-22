<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
hr {
	margin-top: 0px;
	margin-bottom: 0px;
}

.inner-container {
	text-align: center;
	width: 240px;
}

.sidebar a {
	font-size: 20px;
	color: black;
	border: 5px solid #33B2FF;
	background-color: transparent;
	width: 100%;
	text-align: center;
	height: 100px;
	display: table-cell;
	vertical-align: middle;
	text-decoration: none;
	min-width: 240px
}

/* Sidebar */
.sidebar {
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
	padding: 58px 0 0; /* Height of navbar */
	box-shadow: 0 2px 5px 0 rgb(0 0 0/ 5%), 0 2px 10px 0 rgb(0 0 0/ 5%);
	width: 240px;
	background-color: #33B2FF;
	text-align: center;
	overflow: auto;
	/* height:auto; */
}

a:hover, a:active {
	background-color: #33B2FF;
	color: white;
}
</style>
<script>
	
</script>
</head>
<body>
	<div class="headingArea">
		<h1>Dashboard</h1>
	</div>
	<header>
		<!-- Sidebar -->

		<div class="container vertical-menu nav nav-pills sidebar"
			role="tablist" aria-orientation="vertical">
			<div class="inner-container">
				<a href="${pageContext.request.contextPath}/ShowAdminHome">Home</a>
			</div>
			<hr>
			<div class="inner-container">
				<a href="${pageContext.request.contextPath}/ShowAllCategory">Categories</a>
			</div>
			<hr>
			<div class="inner-container">
				<a href="${pageContext.request.contextPath}/medicine/ShowAllMedicine">Medicines</a>
			</div>
			<hr>
			<div class="inner-container">
				<a href="${pageContext.request.contextPath}/test/ShowAllTest">Tests</a>
			</div>
			<hr>
			<div class="inner-container">
				<a href="${pageContext.request.contextPath}/ShowAllOrdersForm">Orders</a>
			</div>
			<hr>







		</div>


	</header>
	<!--Main Navigation-->
</body>
</html>