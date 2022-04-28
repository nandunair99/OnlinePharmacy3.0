<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home Page</title>
<link rel="stylesheet" href="resources/css/commonLayout.css">
</head>
<body>
	<c:import var="sidebar" url="sidebar.jsp" />
	${sidebar}
	<div class="mainArea">
		<div class="headingArea">
			<h1>Dashboard</h1>
		</div>
	</div>
</body>
</html>