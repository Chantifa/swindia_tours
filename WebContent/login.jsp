<%@page import="java.util.*"%>
<%@ page import="ch.swindiatours.model.Cart" %>
<%@ page import="ch.swindiatours.model.User" %>
<%@ page import="ch.swindiatours.model.User" %>
<%@ page import="ch.swindiatours.model.Cart" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
	User auth = (User) request.getSession().getAttribute("auth");
	if (auth != null) {
		response.sendRedirect("index.jsp");
	}
	ArrayList<Cart> cart_Service_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	if (cart_Service_list != null) {
		request.setAttribute("cart_Service_list", cart_Service_list);
	}
	%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<title>SwIndia Tours</title>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Login</div>
			<div class="card-body">
				<form action="login" method="post">
					<div class="form-group">
						<label>Email address</label> 
						<input type="email" name="login-email" class="form-control" placeholder="Enter email">
					</div>
					<div class="form-group">
						<label>Password</label> 
						<input type="password" name="login-password" class="form-control" placeholder="Password">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
</body>
</html>