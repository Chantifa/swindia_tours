<%@page import="java.text.DecimalFormat"%>
<%@page import="ch.swindiatours.connection.DbCon"%>
<%@page import="java.util.*"%>
<%@ page import="ch.swindiatours.Model.Cart" %>
<%@ page import="ch.swindiatours.Model.Booking" %>
<%@ page import="ch.swindiatours.Model.User" %>
<%@ page import="ch.swindiatours.dao.BookingDao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%!
	%><%
	DecimalFormat dcf = new DecimalFormat("#.##");
	request.setAttribute("dcf", dcf);
	User auth = (User) request.getSession().getAttribute("auth");
	List<Booking> booking = null;
	if (auth != null) {
	    request.setAttribute("person", auth);
	    BookingDao bookingDao  = new BookingDao(DbCon.getConnection());
		booking = bookingDao.userBookings(auth.getId());
	}else{
		response.sendRedirect("login.jsp");
	}
	ArrayList<Cart> cart_Service_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	if (cart_Service_list != null) {
		request.setAttribute("cart_Service_list", cart_Service_list);
	}
	
	%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp" %>
<title>SwIndia Tours</title>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container">
		<div class="card-header my-3">All Bookings</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Description</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			
			<%
			if(booking != null){
				for(Booking b: booking){%>
					<tr>
						<td><%=b.getDate() %></td>
						<td><%=b.getName() %></td>
						<td><%=b.getDescription() %></td>
						<td><%=b.getQunatity() %></td>
						<td><%=dcf.format(b.getPrice()) %></td>
						<td><a class="btn btn-sm btn-danger" href="cancel-booking?id=<%=b.getBookingId()%>">Cancel Booking</a></td>
					</tr>
				<%}
			}
			%>
			
			</tbody>
		</table>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>