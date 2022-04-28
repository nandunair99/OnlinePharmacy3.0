<%@ page import="com.narola.pharmacy.category.CategoryBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Update Form</title>
<link rel="stylesheet" href="resources/css/commonLayout.css">
</head>
<body>
	<jsp:include page="sidebar.jsp"></jsp:include>
	<div class="mainArea">
		<div class="headingArea">
			<h1>Update Category</h1>
		</div>
		<c:if test="${not empty CategoryBean}">

			<c:set var="cbean" value="${CategoryBean}" />
		</c:if>
		<c:if test="${empty CategoryBean}">

		</c:if>
		<div>
			<form name="updateForm" method="post"
				action="${pageContext.request.contextPath}${Constant.URL_CATEGORY_UPDATE_ACTION}?catId=${cbean.getCatId()}">
				<table>
					<tr>
						<td>
							<div class="form-group">
								<label for="catIdtxt">Category ID:</label> <input type="text"
									class="form-control" name="catIdtxt" id="catIdtxt"
									value="${cbean.getCatId()}" placeholder="Enter Category ID.."
									disabled>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="form-group">
								<label for="catNametxt">Category Name:</label>
								<c:set var="isErrorParam" value="${isError}" />
								<c:if test="${empty isErrorParam || isErrorParam==false}">
									<input class="form-control" type="text" name="catNametxt"
										id="catNametxt" value="${cbean.getCatName()}"
										placeholder="Enter Category Name...">
								</c:if>
								<c:if test="${not empty isErrorParam && isErrorParam==true}">
									<input class="form-control" type="text" name="catNametxt"
										id="catNametxt" placeholder="Enter Category Name...">
								</c:if>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan=2><c:if test="${not empty errMsg}">
								<h4 style="color: red">${errMsg}</h4>
							</c:if></td>
					</tr>
					<tr>
						<td colspan=2><input type="submit" value="Update Category">
						</td>
					</tr>
				</table>
			</form>
			<p>
				<a href="ShowAllCategory">Go back</a>
			</p>
		</div>

	</div>
</body>
</html>