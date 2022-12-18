package ch.swindiatours.servlet;

import ch.swindiatours.Model.Cart;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/remove-from-cart")
public class RemoveFromCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String bookId = request.getParameter("id");
            if (bookId != null) {
                ArrayList<Cart> cart_Service_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
                if (cart_Service_list != null) {
                    for (Cart c : cart_Service_list) {
                        if (c.getId() == Integer.parseInt(bookId)) {
                            cart_Service_list.remove(cart_Service_list.indexOf(c));
                            break;
                        }
                    }
                }
                response.sendRedirect("cart.jsp");

            } else {
                response.sendRedirect("cart.jsp");
            }

        }
    }

}
