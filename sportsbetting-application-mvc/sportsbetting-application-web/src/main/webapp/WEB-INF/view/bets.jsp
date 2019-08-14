<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.List"%>
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

	<div class="container-fluid mt-2">

		<div class="row justify-content-center m-3">
			<div class="card border-dark w-100">
				<div class="card-header bg-dark text-left">
					<span class="text-white h4">Betting options for ${event.title}</span>
				</div>
			</div>
		</div>
	</div>

	<div class="container-fluid mt-2">
		<div class="row justify-content-center m-3">
			<div class="card border-info w-100">
				<div class="card-header bg-info">
					<span class="text-white h5">Select a type to place your bet!</span>
				</div>
				<div class="card-body">
					<table id="wagers" class="table table-hover">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Description</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${not empty bets}">
								<c:forEach items="${bets}" var="bet" varStatus="count">
									<tr>
										<th scope="row">${count.count}</th>
										<td>${bet.description}</td>
										<td class="w-25 text-right">
											<form action=<c:url value='${bet.outcomesUrl}'/> method="get">
												<button class="btn btn-sm btn-success" type="submit">Bet now!</button>
											</form>
										</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>