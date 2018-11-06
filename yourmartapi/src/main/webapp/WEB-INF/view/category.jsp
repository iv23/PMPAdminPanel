<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>YourMart Admin</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<script>

var openModal = (id, name) => {
	document.getElementById("modal-title").innerHTML = "Edit category: "+name;
	document.getElementById("category-name").value = name;
	document.getElementById("category-id").value = id;
	$("#myModal").modal();
};
	</script>
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

	<c:if test="${not empty error}">
		<div class="alert alert-danger" role="alert">${error}</div>
	</c:if>
	<table class="table">
		<thead>
			<th scope="col">Id</th>
			<th scope="col">Name</th>
			<th scope="col"></th>
		</thead>
		<tbody>
			<c:forEach var="category" items="${categories}">
				<tr>
					<td>${category.categoryId}</td>
					<td>${category.categoryName}</td>
					<td>
						<form action="/category/delete" method="POST">
							<input type="hidden" name="id" value="${category.categoryId}"> <input
								type="submit" value="DELETE">
						</form>
					</td>
					<td>
						<button onclick="openModal(${category.categoryId}, '${category.categoryName}')">Edit</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div id="myModal" class="modal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 id="modal-title" class="modal-title">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="/category/edit" method="POST">
					<input id="category-id" type="hidden" name="id">
					<div class="modal-body">
						New Category Name: <input id="category-name" type="text"
							name="categoryName">
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">Save
							changes</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<form action="/category/add" method="POST">
		<input type="text" name="category"> <input type="submit"
			value="Add Category">
	</form>
</body>
</html>
