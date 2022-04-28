<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.narola.pharmacy.category.CategoryBean"%>
<%@ page import="com.narola.pharmacy.category.CategoryDAO"%>
<%@page import="com.narola.pharmacy.utility.Constant"%>
<!DOCTYPE html>
<html>
<head>
<script>
	function showCart() {
		$(".h-custom").show();
	}
</script>
<style>
.site-navbar {
	height: 100px;
}

button {
	background-color: white;
	border: none;
}

.hideSearch {
	display: none;
}

.showSearch {
	display: block;
}
</style>
<link
	href="https://fonts.googleapis.com/css?family=Rubik:400,700|Crimson+Text:400,400i"
	rel="stylesheet">
<link rel="stylesheet" href="resources/fonts/icomoon/style.css">

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/magnific-popup.css">
<link rel="stylesheet" href="resources/css/jquery-ui.css">
<link rel="stylesheet" href="resources/css/owl.carousel.min.css">
<link rel="stylesheet" href="resources/css/owl.theme.default.min.css">


<link rel="stylesheet" href="resources/css/aos.css">

<link rel="stylesheet" href="resources/css/style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	function getSearch() {
		//var searchdiv=document.GetElementsByClassName("searchDiv");
		$(".searchDiv").toggleClass("showSearch");
	}
</script>
</head>

<body>

	<c:if test="${not empty showCart}">
		<c:import var="cart" url="cart.jsp" />
${cart}

</c:if>
	<c:if test="${not empty showPastOrders}">
		<c:import var="pastOrders" url="yourorders.jsp" />
${pastOrders}

</c:if>
	<jsp:useBean id="categorydao"
		class="com.narola.pharmacy.category.CategoryDAO" />
	<div class="site-navbar py-2">

		<div class="container">
			<div class="d-flex align-items-center justify-content-between">
				<div class="logo">
					<div class="site-logo">
						<a href="ShowCustomerHome">Pharmeasy</a>
					</div>
				</div>
				<div class="main-nav d-none d-lg-block">
					<nav class="site-navigation text-right text-md-center"
						role="navigation">
						<ul class="site-menu js-clone-nav d-none d-lg-block">
							<li><a
								href="${pageContext.request.contextPath}${Constant.URL_CUSTOMER_HOME}">Home</a></li>
							<li><a
								href="${pageContext.request.contextPath}${Constant.URL_CUSTOMER_HOME}?query=medicine">
									Medicines</a></li>
							<li><a
								href="${pageContext.request.contextPath}${Constant.URL_CUSTOMER_HOME}?query=test">
									Tests</a></li>
							<li class="has-children"><a href="#">Categories</a>
								<ul class="dropdown">
									<c:forEach var="CatItem"
										items="${categorydao.showAllCategory()}">
										<Li style="z-index: 2"><a
											href="${pageContext.request.contextPath}${Constant.URL_CUSTOMER_HOME}?query=${CatItem.getCatId()}">
												${CatItem.getCatName()} </a></li>
									</c:forEach>
								</ul></li>

						</ul>
					</nav>
				</div>
				<button type="button" class="getSearch" onclick="getSearch();">
					<i class="glyphicon glyphicon-search"></i>
				</button>
				<div class="icons">
					<a href="ShowCartForm"> <span class="icon-shopping-bag">
							<span class="number"><i
								class="glyphicon glyphicon-shopping-cart"
								style="font-size: 24px; color: red"></i></span>
					</span>
					</a>
				</div>
				<div class="icons">
					<nav class="site-navigation" role="navigation"
						style="margin-top: 25px">
						<ul class="site-menu js-clone-nav d-none d-lg-block">
							<li class="has-children"><a
								class="icons-btn d-inline-block bag"> <span></span> <span
									class="number"><i class="glyphicon glyphicon-user"
										style="font-size: 24px; color: red"></i></span>
							</a>
								<ul class="dropdown">

									<li style="z-index: 2"><a href=""> Profile</a></li>
									<c:if test="${not empty customerDetails}">
										<li style="z-index: 2"><a href="LogoutAction"> Logout</a></li>
									</c:if>
									<c:if test="${empty customerDetails}">
										<li style="z-index: 2"><a href="LoginForm"> Login</a></li>
									</c:if>
									<c:if test="${ not empty customerDetails}">
										<li style="z-index: 2"><a href="ShowPastOrdersForm">
												Your Orders</a></li>
									</c:if>

								</ul></li>
						</ul>
					</nav>

				</div>
			</div>
			<form method="post" action="ShowCustomerHome?query=search">
				<div class="searchDiv hideSearch">
					<div class="form-outline d-flex">
						<input id="search-focus" name="searchtxt" type="text"
							class="form-control" style="width: 95%; z-index: 5"
							onkeyup="mySearch()" /> <input type="submit" name="submitbtn"
							value="&#x1F50E;">
					</div>

				</div>
			</form>
		</div>
		<div class="container">
			<br />


		</div>
	</div>

	<script src="resources/js/jquery-3.3.1.min.js"></script>
	<script src="resources/js/jquery-ui.js"></script>
	<script src="resources/js/popper.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/owl.carousel.min.js"></script>
	<script src="resources/js/jquery.magnific-popup.min.js"></script>
	<script src="resources/js/aos.js"></script>

	<script src="resources/js/main.js"></script>
	<script type="text/javascript">
		function mySearch() {

			var txtInput = document.getElementById("search-focus").value;
			window.location.href = "ShowCustomerHome?query=search&searchtxt="
					+ txtInput;
		}
	</script>
</body>
</html>