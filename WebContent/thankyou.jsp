<%@ page import="java.util.Date" %>
<%@ page import="ch.swindiatours.Model.User" %>
<%@ page import="ch.swindiatours.Model.Booking" %>
<%@ page import="ch.swindiatours.dao.BookingDao" %>
<%@ page import="java.util.List" %>
<%@ page import="jakarta.persistence.EntityManagerFactory" %>
<%@ page import="jakarta.persistence.Persistence" %>
<%@ page import="jakarta.persistence.EntityManager" %><%--
  Created by IntelliJ IDEA.
  User: chant
  Date: 30/11/2022
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%	User auth = (User) request.getSession().getAttribute("auth");%>
<html>
<head>
    <%@include file="head.jsp"%>
    <title>SwIndia Tours</title>
</head>
<body>
<%@include file="navbar.jsp"%>
<% Date date = new Date(); %>
<% User user = new User(); %>
<% Booking booking = new Booking(); %>
<h1 align="center">Confirmation Page</h1>
<h3><%= user.getName() %>, thank you for booking with us <%= date %>!</h3>
<%
    String bookingString = booking.toString();
%>
<p><%= bookingString %>
    <%EntityManagerFactory emf = Persistence.createEntityManagerFactory("swindiatours");
    EntityManager em = emf.createEntityManager();%>
        <% BookingDao bookingDao = new BookingDao(em);
          List<Booking> bookings = bookingDao.userBookings(user.getId());
          while (bookings.iterator().hasNext())   {
             Booking b = bookings.iterator().next();
          }
            %>

<table>
    <c:forEach items="${bookings}" var="item">
        <tr>
            <td><c:out value="${item}" /></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
