<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
		<form:form method="post" action="/player/update"
			modelAttribute="playerDetails">
			<div class="row justify-content-center m-3">
				<div class="card border-dark w-100">
					<div class="card-header bg-dark">
						<span class="text-white h6">Account details</span>
					</div>
					<div class="card-body">
						<c:if test="${errorMessage != null}">
							<div class="text-center h5 text-danger">${errorMessage}</div>
						</c:if>
						<div class="input-group mb-1">
							<div class="input-group-prepend">
								<div class="input-group-text">Name</div>
							</div>
							<form:input path="name" type="text" class="form-control"
								id="name" placeholder="Name" />
						</div>
						<form:errors path="name" cssClass="text-danger"></form:errors>
						<div class="input-group mb-1">
							<div class="input-group-prepend">
								<div class="input-group-text">Date of Birth</div>
							</div>
							<form:input path="birth" type="date" class="form-control"
								id="birth-date" placeholder="Date of Birth" readonly="readonly" />
						</div>
						<form:errors path="birth" cssClass="text-danger"></form:errors>
						<div class="input-group mb-1">
							<div class="input-group-prepend">
								<div class="input-group-text">Account number</div>
							</div>
							<form:input path="accountNumber" type="text" class="form-control"
								id="account-number" placeholder="Account number" />
						</div>
						<form:errors path="accountNumber" cssClass="text-danger"></form:errors>
						<div class="input-group mb-1">
							<div class="input-group-prepend">
								<label class="input-group-text" for="currency">Currency</label>
							</div>
							<form:select path="currency" items="${currencies}"
								class="custom-select" id="currency" />
						</div>
						<div class="input-group mb-1">
							<div class="input-group-prepend">
								<div class="input-group-text">Balance</div>
							</div>
							<form:input path="balance" type="text" class="form-control"
								id="balance" placeholder="Balance" />
						</div>
						<form:errors path="balance" cssClass="text-danger"></form:errors>
						<div>
							<button type="submit" class="btn btn-info mt-2">Save</button>
						</div>
					</div>
				</div>
			</div>
		</form:form>
		<div class="row justify-content-center m-3">
			<div class="card border-dark w-100">
				<div class="card-header bg-dark">
					<span class="text-white h6">Wagers</span>
				</div>
				<div class="card-body">
					<c:choose>
						<c:when test="${not empty wagers}">
							<table id="wagers" class="table table-hover">
								<thead>
									<tr>
										<th scope="col"></th>
										<th scope="col">#</th>
										<th scope="col">Event title</th>
										<th scope="col">Event type</th>
										<th scope="col">Bet</th>
										<th scope="col">Outcome value</th>
										<th scope="col">Outcome odd</th>
										<th scope="col">Wager amount</th>
										<th scope="col">Winner</th>
										<th scope="col">Processed</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${wagers}" var="wager" varStatus="count">
										<tr>
											<td>
												<form action=<c:url value='${wager.removeUrl}'/>
													method="get">
													<c:if test="${wager.processed}">
														<button disabled class="btn btn-sm btn-dark" type="submit">Remove</button>
													</c:if>
													<c:if test="${not wager.processed}">
														<button class="btn btn-sm btn-dark" type="submit">Remove</button>
													</c:if>
												</form>
											</td>
											<th scope="row">${count.count}</th>
											<td>${wager.eventTitle}</td>
											<td>${wager.eventType}</td>
											<td>${wager.betDescription}</td>
											<td>${wager.outcomeValue}</td>
											<td>${wager.outcomeOdd}</td>
											<td>${wager.amount}</td>
											<td>${wager.winner}</td>
											<td>${wager.processed}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:when>
						<c:otherwise>
							<div class="container mt-2">
								<div class="row justify-content-center">
									<div class="alert alert-info" role="alert">
										<p class="h5">You do not have active wagers right now.</p>
										<hr>
									</div>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</body>
</html>