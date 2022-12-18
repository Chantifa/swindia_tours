<%@page import="java.util.*"%>
<%@ page import="ch.swindiatours.Model.Tour" %>
<%@ page import="ch.swindiatours.Model.Cart" %>
<%@ page import="ch.swindiatours.dao.TourDao" %>
<%@ page import="ch.swindiatours.connection.DbCon" %>
<%@ page import="ch.swindiatours.Model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("person", auth);
    }
    TourDao td = new TourDao(DbCon.getConnection());
    List<Tour> tour = td.getAllTours();
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if (cart_list != null) {
        request.setAttribute("cart_list", cart_list);
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
    <div class="card-header my-3">All Tours</div>
    <div class="row">
        <%
            if (!tour.isEmpty()) {
                for (Tour t: tour) {
        %>
        <div class="col-md-3 my-3">
            <div class="card w-100">
                <img class="card-img-top" src="img/<%=t.getImage() %>"
                     alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title"><%=t.getName() %></h5>
                    <h6 class="price">Price: CHF<%=t.getPrice() %></h6>
                    <h6 class="category">Description: <%=t.getDescription() %></h6>
                    <div class="mt-3 d-flex justify-content-between">
                        <a class="btn btn-dark" href="add-to-cart?id=<%=t.getId()%>">Add to Cart</a> <a
                            class="btn btn-primary" href="book-now?quantity=1&id=<%=t.getId()%>">Buy Now</a>
                    </div>
                </div>
            </div>
        </div>
        <%
                }
            } else {
                //print no tours
            }
        %>

    </div>
</div>

<%@include file="footer.jsp"%>
</body>
</html>