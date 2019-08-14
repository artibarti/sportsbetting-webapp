<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="menu.jsp" />

	<div class="container-fluid mt-2">

		<div class="row justify-content-center m-3">
			<div class="card border-primary w-100">
				<div class="card-header bg-info text-center">
					<div class="text-white h4">
						<p class="text-white font-weight-bold h3">Good luck boi</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container-fluid mt-2">
		<div class="row justify-content-center m-3">
			<div class="card border-info w-100">
				<div class="card-header bg-info">
					<span class="text-white h5">Select a type to place your bet!</span>
					<span class="float-right text-white h5">Balance: ${balance}</span>
				</div>
				<div class="card-body">
					<table id="wagers" class="table table-hover">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Outcome</th>
								<th scope="col">Odd</th>
								<th scope="col">Amount</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${not empty outcomes}">
								<c:forEach items="${outcomes}" var="outcome" varStatus="count">
									<form:form method="post" action='${outcome.saveWagerUrl}' modelAttribute="wager">
										<tr>
											<th scope="row">${count.count}</th>
											<td>${outcome.outcomeValue}</td>
											<td>${outcome.odd}</td>
											<td><spring:bind path="amount">
													<div class="form-group row">
														<div class="col-10">
															<form:hidden path="outcomeOddId" value="${outcome.id}"/>
															<form:input path="amount" class="form-control"
																type="number" min="1" max="${balance}" value="1"
																id="amount" />
														</div>
													</div>
												</spring:bind> <form:errors path="amount" cssClass="text-danger"></form:errors>
											</td>
											<td>
												<button class="btn btn-sm btn-success" type="submit">Save wager</button>
											</td>
										</tr>
									</form:form>
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