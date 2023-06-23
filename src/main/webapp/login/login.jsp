<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login to TODO List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h1>Login Form</h1>
		<form action="<%= request.getContextPath()%>/login" method="post">
			<div class="form-group">
				<label for="username">Username:</label>
				<input type="text" class="form-control" id="username" placeholder="Enter username..." name="username" required="required" />
			</div>
			
			<div class="form-group">
				<label for="password">Password:</label>
				<input type="password" class="form-control" id="password" name="password" required="required" />
			</div>
			
			<button type="submit" class="btn btn-primary mt-2 mb-2">Login</button>
		</form>
		New user? Then <a href="<%=request.getContextPath()%>/register/register.jsp">Register</a>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>