<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="welcome.jsp"/>
	<div class="container mt-4 mb-3">
		<div class="row justify-content-left ml-5">
			<a href="login" class="text-primary font-weight-bold h4">Login</a>&nbsp;
			<p class="h4 font-weight-bold">if you have an account!</p>
		</div>
	</div>
	<form:form method="POST" modelAttribute="playerRegisterDto">
		<div class="container">
			<div class="row justify-content-left ml-5">
				<div class="card border-primary">
					<div class="card-header bg-primary">
						<span class="text-white font-weight-bold h5">Register</span>
					</div>
					<div class="card-body">
						<spring:bind path="name">
							<form:input path="name" type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Name"/>
							<form:errors path="name" cssClass="text-danger"></form:errors>
						</spring:bind>
						<spring:bind path="emailAddress">
							<form:input path="emailAddress" type="email" class="form-control mt-2" id="email" aria-describedby="emailHelp" placeholder="Email"/>
							<form:errors path="emailAddress" cssClass="text-danger"></form:errors>
						</spring:bind>
						<spring:bind path="password">						
							<form:input path="password" type="password" class="form-control mt-2" id="password" aria-describedby="passwordHelp" placeholder="Password"/>
							<form:errors path="password" cssClass="text-danger"></form:errors>
						</spring:bind>
						<spring:bind path="matchingPassword">						
							<form:input path="matchingPassword" type="password" class="form-control mt-2" id="password" aria-describedby="passwordHelp" placeholder="Repeat password"/>
							<form:errors path="matchingPassword" cssClass="text-danger"></form:errors>
						</spring:bind>
						<br>
						<button id="registerButton" type="submit" class="btn btn-primary mt-2">Register</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</body>

</html>