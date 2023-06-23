<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TODO List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div>
		<div class="container">
			<a href="<%=request.getContextPath()%>/add?username=<c:out value='${username}'/>" class="btn btn-primary mb-2">Add item &#43;</a>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Title</th>
						<th>Date</th>
						<th>Done</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="todoItem" items="${todoList}">
						<tr>
							<td><c:out value="${todoItem.title}" /></td>
							<td><c:out value="${todoItem.targetDate}" /></td>
							<td><c:out value="${todoItem.isDone}" /></td>
							<td><a href="delete?=id=<c:out value='${todoItem.id}' />&username=<c:out value='${username}'/>">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>