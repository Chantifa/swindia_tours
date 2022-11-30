<%@ page import="java.util.Date" %>
<%@ page import="ch.swindiatours.model.User" %>
<%@ page import="ch.swindiatours.model.Booking" %>
<%@ page import="ch.swindiatours.dao.BookingDao" %>
<%@ page import="ch.swindiatours.connection.DbCon" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: chant
  Date: 30/11/2022
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp" %>
    <title>SwIndia Tours</title>
</head>
<body>
<%@include file="navbar.jsp" %>
<% Date date = new Date(); %>
<% User user = new User(); %>
<% Booking booking = new Booking(); %>
<h1 align="center">Confirmation Page</h1>
<h3><%= user.getName() %>, thank you for booking with us <%= date %>!</h3>
<%
    String bookingString = booking.toString();
%>
<p><%= bookingString %>
        <% BookingDao bookingDao = new BookingDao(DbCon.getConnection());
          List<Booking> bookings = bookingDao.userBookings(user.getId());
          while (bookings.iterator().hasNext()) %>
        {
            <div><% bookings.iterator().next(); %></div>
</body>
</html>
