<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src='https://www.google.com/recaptcha/api.js'></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Login Form</title>
</head>

<body>

	<div class="row">
		<div class="col-md-6 mx-auto">
			<div class="card rounded-0">
				<div class="card-header">
					<h3 class="mb-0">Sign In</h3>
				</div>
				<div class="card-body">
					<form:form action="processLogin" modelAttribute="adminUser"
						method="POST">
						<div class="form-group">
							<form:label path="yourmartId">Yourmart Id</form:label>
							<form:input path="yourmartId" class="form-control rounded-0" />
						</div>
						<div class="form-group">
							<form:label path="password">Password</form:label>
							<form:password path="password" class="form-control rounded-0" />
						</div>
						<div class="g-recaptcha" data-sitekey="6LeFv3gUAAAAANfWrmEI-B8BwJBDP3mlqg_TzBja"></div>
						<form:button id="login" name="login" class="btn btn-primary float-right">Login</form:button>
					</form:form>
				</div>
				<table>
					<tr>
						<td style="font-style: italic; color: red;">${message}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>

</html>
