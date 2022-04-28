<%@ page import="com.narola.pharmacy.category.CategoryBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category</title>

<link rel="stylesheet" href="resources/css/commonLayout.css">
</head>
<body>

	<c:import var="sidebar" url="sidebar.jsp" />
	${sidebar}
	<div class="mainArea">
		<div class="headingArea">
			<h1>Add Category</h1>
		</div>


		<div>
			<form name="addForm" method="post" action="${pageContext.request.contextPath}${Constant.URL_CATEGORY_ADD_ACTION}">
				<table>

					<tr>
						<td>
							<div class="form-group">
								<label for="catNametxt">Category Name:</label> <input
									type="text" class="form-control"
									placeholder="Enter Category Name..." name="catNametxt"
									id="catNametxt">
							</div>
						</td>
					</tr>
					<tr>
						<td colspan=2><c:if test="${not empty errMsg}">
								<h4 style="color: red">
									<c:out value="${errMsg}"></c:out>
								</h4>
							</c:if>
					</tr>
					<tr>
						<td colspan=2><input type="submit" value="Add Category">
						</td>
					</tr>


				</table>
			</form>
			<p>
				<a href="ShowAllCategory">Go Back</a>
			</p>
		</div>
	</div>
</body>
</html>