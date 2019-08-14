<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="/home">SportsBetting</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="/home">Home<span 
				class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link" href="/events">Events</a></li>
			<li class="nav-item"><a class="nav-link" href="/export">Export</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">Language</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="#">English</a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-warning" href="#"
				id="navbarDropdown" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">Admin</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="/database/populate">Populate</a> <a
						class="dropdown-item" href="/database/clear">Clear</a>
				</div></li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<a class="btn btn-outline-light my-2 my-sm-0" href="<c:url value="/logout" />">Logout</a>
		</form>
	</div>
</nav>
