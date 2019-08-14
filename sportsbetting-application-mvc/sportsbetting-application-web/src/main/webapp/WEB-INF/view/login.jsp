<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="welcome.jsp" />
	<div class="container mt-4 mb-3">
		<div class="row justify-content-left ml-5">
			<a href="/register" class="text-primary font-weight-bold h4">Register</a>&nbsp;
			<p class="h4 font-weight-bold">to start!</p>
		</div>
	</div>
	<form name="login" action="/login" method="post">
		<div class="container">
			<div class="row justify-content-left ml-5">
				<div class="card border-primary">
					<div class="card-header bg-primary">
						<span class="text-white font-weight-bold h5">Login</span>
					</div>
					<div class="card-body">
						<c:if test="${param.error != null}">
							<div class="text-danger">Login failed, try again</div>
						</c:if>
						<input type="text" name="username" class="form-control mb-2" placeholder="username" />
						<input type='password' name='password' class="form-control mb-2" placeholder="password" />
						<input name="submit" type="submit" class="btn btn-primary mt-2" value="Login" />
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
