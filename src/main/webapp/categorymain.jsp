<%@ page import="com.narola.pharmacy.category.CategoryBean"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Categories</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/design.css" type="text/css">
<script>
function handleChange(checkbox,catId) {
    if(checkbox.checked == true){
       load_ajax(catId,"true");
    }else{
    	load_ajax(catId,"false");
   }
}
function load_ajax(catId,action)
{
	
	var xhttp;
    xhttp = new XMLHttpRequest();
    
    xhttp.open("POST", "ManagePopularCategoryAction?action="+action+"&catId="+catId, true);
    xhttp.send(); 
    
}
</script>
<link rel="stylesheet" href="resources/css/commonLayout.css">
</head>
<body>
	<jsp:include page="sidebar.jsp"></jsp:include>
	<div class="mainArea">
		<div class="headingArea">
			<h1>Categories</h1>
		</div>
		<div>
			<a href="AddCategoryForm">Add Category</a>
		</div>
		<table class="table table-borderless">
			<tr>
				<th>Category ID</th>
				<th>Category Name</th>
				<th>Created ON</th>
				<th>Updated ON</th>
				<th>Popular</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="cbean" items="${CategoryList}">
				<tr>
					<td>${cbean.getCatId()}</td>
					<td>${cbean.getCatName()}</td>
					<td>${cbean.getCreatedOn().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"))}
						${cbean.getCreatedOn().format(DateTimeFormatter.ofPattern("hh:mm:ss"))}
					</td>
					<td>${cbean.getUpdatedOn().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"))}
						${cbean.getUpdatedOn().format(DateTimeFormatter.ofPattern("hh:mm:ss"))}</td>
					<c:if test="${cbean.getPopular()=='true'}">
						<c:set var="popularStatus" value="checked"></c:set>
					</c:if>
					<c:if test="${cbean.getPopular()=='false'}">
						<c:set var="popularStatus" value=""></c:set>
					</c:if>

					<td><input type="checkbox" ${popularStatus}
						onchange='handleChange(this,${cbean.getCatId()});'></td>
					<td><a href="updateCategoryForm?catId=${cbean.getCatId()}"><span
							class="glyphicon glyphicon-pencil"></span></a></td>
					<td><a href="RemoveCategoryAction?catId=${cbean.getCatId()}"><span
							class="glyphicon glyphicon-trash Delete"></span></a></td>
				</tr>

			</c:forEach>

		</table>
		<c:if test="${not empty errMsg}">
			<h4 style="color: red">${errMsg}</h4>
		</c:if>
	</div>

</body>
</html>