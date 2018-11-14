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
</head>
<body>
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
				<h3>Seller Details</h3>

				<table class="table">
					<tbody>
						<tr>
							<th>ID</th>
							<td>${seller.sellerId}</td>
						</tr>
						<tr>
							<th>Company</th>
							<td>${seller.companyName}</td>
						</tr>
						<tr>
							<th>Owner</th>
							<td>${seller.ownerName}</td>
						</tr>
						<tr>
							<th>Address</th>
							<td>${seller.address.addressLine1}</td>
						</tr>
						<tr>
							<th>Email</th>
							<td>${seller.email}</td>
						</tr>
						<tr>
							<th>Telephone No.</th>
							<td>${seller.telephone}</td>
						</tr>
						<tr>
							<th>Email</th>
							<td>${seller.gstNumber}</td>
						</tr>
						<tr>
							<th>Registered On</th>
							<td>${seller.createdAt}</td>
						</tr>
						<tr>
							<th>Status</th>
							<td>${seller.status}</td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>
	</div>
</body>
</html>