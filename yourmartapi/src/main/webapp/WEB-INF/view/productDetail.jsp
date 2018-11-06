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

			<div class="col-7">
				<h3>Seller Details</h3>

				<table class="table">
					<tbody>
						<tr>
							<th>ID</th>
							<td>${product.productCode}</td>
						</tr>
						<tr>
							<th>Name</th>
							<td>${product.productName }</td>
						</tr>
						<tr>
							<th>Dimensions</th>
							<td>${product.dimensions}</td>
						</tr>
						<tr>
							<th>MRP</th>
							<td>${product.mrp}</td>
						</tr>
						<tr>
							<th>SSP</th>
							<td>${product.ssp}</td>
						</tr>
						<tr>
							<th>YMP</th>
							<td>${product.ymp}</td>
						</tr>
						<tr>
							<th>Category</th>
							<td><c:forEach items="${categories}" var="category">
											<c:out value="${category.categoryName}" />
										</c:forEach></td>
						</tr>
						<tr>
							<th>Status</th>
							<td>${product.status}</td>
						</tr>
						<tr>
							<th>Seller name</th>
							<td>${product.seller.ownerName}</td>
						</tr>
						<tr>
							<th>Seller Company</th>
							<td>${product.seller.companyName}</td>
						</tr>
					</tbody>
				</table>
				<p>${product.shortDescription }</p>
				<p>${product.longDescription }</p>
			</div>
			<div class="col-5">
			<img src="${product.primaryImagePath}" class="img-fluid" alt="Responsive image">
			</div>

			
	</div>
</body>
</html>