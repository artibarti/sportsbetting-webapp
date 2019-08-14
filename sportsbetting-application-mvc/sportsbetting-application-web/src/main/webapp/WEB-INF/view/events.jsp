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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
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
					<span class="text-white h4">Events</span>
				</div>
				<div class="card-body">
					<c:choose>
						<c:when test="${not empty events}">
							<table id="wagers" class="table table-hover">
								<thead>
									<tr>
										<th scope="col"></th>
										<th scope="col">#</th>
										<th scope="col">Event title</th>
										<th scope="col">Event type</th>
										<th scope="col">Start date</th>
										<th scope="col">End date</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${events}" var="event" varStatus="count">
										<tr>
											<td>
												<form action=<c:url value='${event.betsUrl}'/>
													method="get">
													<button class="btn btn-sm btn-info" type="submit">Bets</button>
												</form>
											</td>
											<th scope="row">${count.count}</th>
											<td>${event.title}</td>
											<td>${event.type}</td>
											<td>${event.validFrom}</td>
											<td>${event.validUntil}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:when>
						<c:otherwise>
							<div class="container mt-2">
								<div class="row justify-content-center">
									<div class="alert alert-info" role="alert">
										<p class="h5">No events available now.</p>
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