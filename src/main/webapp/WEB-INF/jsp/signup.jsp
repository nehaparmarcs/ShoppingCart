<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h2>Register Page for Shopping Cart Application</h2>
			</div>
		</div>
	</section>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title"> sign up</h3>
					</div>
					<div class="panel-body">
						<form action="signup1" method="post">
							<fieldset>
							<div class="form-group">
									<input class="form-control" placeholder="Full Name"
										name='fname' type="text">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Email ID"
										name='email' type="text">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Contact No."
										name='contact' type="text">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="User Name"
										name='name' type="text">
								</div>

								<div class="form-group">
									<input class="form-control" placeholder="Password" name='password' type="password" value="">
								</div>

								<input class="btn btn-lg btn-success btn-block" type="submit" value="Sign Up">

							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>