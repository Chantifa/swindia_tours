<%@page import="ch.swindiatours.connection.DbCon" %>
<%@page import="java.util.*" %>
<%@page import="java.text.DecimalFormat" %>
<%@ page import="ch.swindiatours.model.Cart" %>
<%@ page import="ch.swindiatours.model.User" %>
<%@ page import="ch.swindiatours.model.Cart" %>
<%@ page import="ch.swindiatours.dao.TourDao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%
    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf", dcf);
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("person", auth);
    }
    ArrayList<Cart> cart_Service_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartTour = null;
    if (cart_Service_list != null) {
        TourDao tourDao = new TourDao(DbCon.getConnection());
        cartTour = tourDao.getCartTours(cart_Service_list);
        double total = tourDao.getTotalCartPrice(cart_Service_list);
        request.setAttribute("total", total);
        request.setAttribute("cart_Service_list", cart_Service_list);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="head.jsp" %>
    <title>SwIndia Tours</title>
    <style type="text/css">

        .table tbody td {
            vertical-align: middle;
        }

        .btn-incre, .btn-decre {
            box-shadow: none;
            font-size: 25px;
        }
    </style>
</head>
<body>
<%@include file="navbar.jsp" %>

<div class="container my-3">
    <div class="d-flex py-3"><h3>Total Price: CHF ${(total>0)?dcf.format(total):0} </h3> <a class="mx-3 btn btn-primary"
                                                                                            href="cart-check-out">Check
        Out</a></div>
    <table class="table table-light">
        <thead>
        <tr>
            <th scope="col">Tour</th>
            <th scope="col">Description</th>
            <th scope="col">Price</th>
            <th scope="col">Buy Now</th>
            <th scope="col">Cancel</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (cart_Service_list != null) {
                for (Cart c : cartTour) {
        %>
        <tr>
            <td><%=c.getName()%>
            </td>
            <td><%=c.getDescription()%>
            </td>
            <td><%= dcf.format(c.getPrice())%>
            </td>
            <td>
                <form action="book-now" method="post" class="form-inline">
                    <input type="hidden" name="id" value="<%= c.getId()%>" class="form-input">
                    <div class="form-group d-flex justify-content-between">
                        <a class="btn bnt-sm btn-incre" href="quantity-inc-dec?action=inc&id=<%=c.getId()%>"><i
                                class="fas fa-plus-square"></i></a>
                        <input type="text" name="quantity" class="form-control" value="<%=c.getQuantity()%>" readonly>
                        <a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id=<%=c.getId()%>"><i
                                class="fas fa-minus-square"></i></a>
                    </div>
                    <button type="submit" class="btn btn-primary btn-sm" href="booking.jsp">Buy</button>
                </form>
            </td>
            <td><a href="remove-from-cart?id=<%=c.getId() %>" class="btn btn-sm btn-danger">Remove</a></td>
        </tr>

        <%
                }
            }%>
        </tbody>
    </table>
</div>

<%@include file="footer.jsp" %>
</body>
</html>