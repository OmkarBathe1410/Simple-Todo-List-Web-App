<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Item | TODO List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container col-md-5">
		<div class="card my-4">
			<div class="card-body">
				<form action="insert" method="post">
					<fieldset class="form-group mb-2">
						<label for="title">Title</label>
						<input type="text" class="form-control" name="title" minlength="7" required="required" />
					</fieldset>
					<input type="hidden" name="username" value="<c:out value='${username}'/>" />
					<fieldset class="form-group mb-2">
						<label for="status">Status</label>
						<select class="form-control" name="isDone">
							<option value="false">Active</option>
							<option value="true">Completed</option>
						</select>
					</fieldset> 
			
					<fieldset class="form-group mb-2">
						<label for="date">Date</label>
						<input type="date" class="form-control" name="targetDate" required="required" />
					</fieldset>
			
					<button type="submit" class="btn btn-primary">Add &#43;</button>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>