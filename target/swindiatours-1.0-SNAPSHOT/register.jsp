<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include  file="head.jsp" %>
	<title>SwIndia Tours</title>
</head>
<body>
<header>
<!--Navigation bar-->
<%@include file="navbar.jsp" %>

</header>
<!-- Hauptteil der Seite -->
<main>
	<section class="vh-100 gradient-custom">
		<div class="container py-5 h-100">
			<div class="row justify-content-center align-items-center h-100">
				<div class="col-12 col-lg-9 col-xl-7">
					<div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
						<div class="card-body p-4 p-md-5">
							<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">register</h3>
							<form name="registerForm" action="register" onsubmit="return validateInput()" method="post" autocomplete="on">
								<div class="row">
									<div class="col-md-6 mb-4">
										<div class="form-outline">
											<input type="text" id="name" class="form-control form-control-lg" name="name" required/>
											<label class="form-label" for="name">name</label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="mb-4 pb-2 pb-md-0 ">
										<div class="form-outline">
											<input type="email" id="email" class="form-control form-control-lg" name="email" required/>
											<label class="form-label" for="email">email</label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-6 mb-4">
										<div class="form-outline">
											<input type="password" class="form-control form-control-lg" id="password" name="password" required/>
											<label for="password" class="form-label">password</label>
										</div>
									</div>
									<div class="col-md-6 mb-4">
										<div class="form-outline">
											<input type="password" class="form-control form-control-lg" id="repeatepassword" name="repeatepassword" required/>
											<label for="repeatepassword" class="form-label">confirm password</label>
										</div>
									</div>
									<div id ="message"></div>
								</div>

								<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
									<button type="submit" class="btn btn-primary btn-lg">register</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</main>

<!-- Footer am schluss der Seite -->
<%@include file="footer.jsp"%>
</body>
<script>
	function validateInput(){
		var password = document.forms["registerForm"]["password"].value;
		var repeatepassword = document.forms["registerForm"]["repeatepassword"].value;
		var message = document.getElementById("message");

		console.log(password);
		console.log(repeatepassword);
		if (password === repeatepassword) {
			message.innerHTML=" ";
		}else{
			message.innerHTML = "Not same password!!";
			return false;
		}
	}
</script>
</html>
