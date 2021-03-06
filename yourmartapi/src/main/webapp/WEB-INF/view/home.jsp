<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>YourMart Admin</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>

<script>
var init = () => {
	var x = new URL(window.location.href);
	if (x.searchParams.get('filter')) {
		document.getElementById('filter').value = x.searchParams.get('filter');
	}
	if (x.searchParams.get('search')) {
		document.getElementById('search').value = x.searchParams.get('search');
	}
	if (x.searchParams.get('sortDirection')) {
		document.getElementById('sortDirection').value = x.searchParams.get('sortDirection');
	}
	if (x.searchParams.get('sort')) {
		document.getElementById('sort').value = x.searchParams.get('sort');
	}
	var num =(x.searchParams.get('page')) ? (x.searchParams.get('page'))-1: 0; 
	document.getElementsByClassName("page-item")[num].classList.add('active');
};
var goPage = (i) => {
	var x = new URL(window.location.href);
	x.searchParams.set('page', i);
	location.href = x.href;
};
	</script>
</head>
<body onload="init()">

	<!--  navbar begins -->
	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#"> <img src="#" width="30"
			height="30" class="d-inline-block align-top" alt=""> YourMart
			Admin
		</a>
		<ul class="nav justify-content-end">
			<li class="nav-item"><a class="nav-link active" href="/home">Sellers</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/products">Products</a></li>
			<li class="nav-item"><a class="nav-link" href="/category">Categories</a></li>
			<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
			</li>
		</ul>
	</nav>

	<!-- Navbar ends -->
	<div class="container mt-3">
		<div class="row">
			<div class="col-4">

				<form method="GET" action="/home">
					<div class="form-group">
						<label for="filter">Filter Status By</label> <select
							class="custom-select" name="filter" id="filter">
							<option value="">All</option>
							<option value="PENDING">PENDING</option>
							<option value="APPROVED">"APPROVED"</option>
							<option value="REJECTED">REJECTED</option>
						</select>
					</div>

					<div class="form-group">
						<label for="sort">Sort By</label> <select class="custom-select"
							name="sort" id="sort">
							<option value="id">ID</option>
							<option value="createdAt">Creation Time</option>
						</select>
					</div>

					<div class="form-group">
						<label for="sortDirection">Sort Order</label> <select
							class="custom-select" name="sortDirection" id="sortDirection">
							<option value="asc">Ascending</option>
							<option value="desc">Descending</option>
						</select>
					</div>

					<div class="form-group">
						<label for="search">Search Query</label><input class="form-control"
							id="search" type="text" name="search" value="">
					</div>
					<div class="text-center">
						<input type="submit" value="Apply Filter and Sort"
							class="btn btn-primary">
					</div>
				</form>
			</div>
			<div class="col-8">


				<!-- Table for sellers -->
				<form action="actions" method="POST">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Company</th>
								<th scope="col">Owner</th>
								<th scope="col">GST no.</th>
								<th scope="col">Telephone Number</th>
								<th scope="col">Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${sellers}" var="seller">
								<tr>
									<td><c:if test="${seller.status eq 'NEED_APPROVAL'}">
											<input type="checkbox" name="selectedSeller"
												value="${seller.sellerId}">
										</c:if> <a href="seller/${seller.sellerId}"><c:out value="${seller.sellerId}" /></a></td>
									<td><c:out value="${seller.companyName}" /></td>
									<td><c:out value="${seller.ownerName}" /></td>
									<td><c:out value="${seller.gstNumber}" /></td>
									<td><c:out value="${seller.telephone}" /></td>
									<td><c:if test="${seller.status eq 'NEED_APPROVAL'}">
											<span class="badge badge-pill badge-warning">Pending</span>
										</c:if> <c:if test="${seller.status eq 'APPROVED'}">
											<span class="badge badge-pill badge-success">Approved</span>
										</c:if> <c:if test="${seller.status eq 'REJECTED'}">
											<span class="badge badge-pill badge-danger">Rejected</span>
										</c:if></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<input type="submit" name="action" value="approve" /> <input
						type="submit" name="action" value="reject" />

				</form>
				<nav>
					<ul class="pagination">
						<c:forEach var="i" begin="1" end="${noPages}">
							<li class="page-item"><a class="page-link"
								onclick="goPage(${i})">${i}</a></li>
						</c:forEach>
					</ul>
				</nav>
			</div>
		</div>
	</div>



</body>
</html>