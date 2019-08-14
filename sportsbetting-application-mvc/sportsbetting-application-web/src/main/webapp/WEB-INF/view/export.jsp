<%@page import="com.epam.training.sportsbetting.domain.Wager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="container-fluid">

		<div class="row justify-content-center m-3">
			<div class="card border-info w-100">
				<div class="card-header bg-info text-center">
					<span class="text-white h4">Export your data here</span>
				</div>
				<div class="card-body">
					<form:form method="post" action="/download/playerinfo"
						modelAttribute="exportConfig">
						<div class="row">
							<div class="col">
								<div class="input-group mb-1">
									<div class="input-group-prepend">
										<div class="input-group-text">Start date</div>
									</div>
									<form:input path="startDate" type="date" class="form-control"
										id="startDate" placeholder="Start date" />
								</div>
							</div>
							<div class="col text-center">
								<div class="input-group mb-1">
									<div class="input-group-prepend">
										<div class="input-group-text">End date</div>
									</div>
									<form:input path="endDate" type="date" class="form-control"
										id="endDate" placeholder="End date" />
								</div>
							</div>
						</div>
						<div class="row float-right mr-auto">
							<button type="submit" class="btn btn-info mt-2">Export</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>