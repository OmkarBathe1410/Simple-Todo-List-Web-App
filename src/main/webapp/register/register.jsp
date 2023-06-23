<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register to TODO List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container">
		<h1>User Registration</h1>
		<div class="col-md-6 col-md-offset-3">
			<form action="<%=request.getContextPath()%>/register" method="post">
				<div class="form-group">
					<label for="firstname">First Name:</label>
					<input type="text" class="form-control" id="firstname" placeholder="Enter first name..." name="firstName" required="required" />
				</div>
				
				<div class="form-group">
					<label for="lastname">Last Name:</label>
					<input type="text" class="form-control" id="lastname" placeholder="Enter last name..." name="lastName" required="required" />
				</div>
				
				<div class="form-group">
					<label for="username">User Name:</label>
					<input type="text" class="form-control" id="username" placeholder="Enter user name..." name="username" required="required" />
				</div>
				
				<div class="form-group">
					<label for="password">Password:</label>
					<input type="password" class="form-control" id="password" name="password" required="required" />
				</div>
				
				<button type="submit" class="btn btn-primary mt-2 mb-2">Register</button>
			</form>
			Already have an account? Then <a href="<%=request.getContextPath()%>/login/login.jsp">Login now</a>
		</div>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>


