package ch.swindiatours.servlet;

import ch.swindiatours.connection.DbCon;
import ch.swindiatours.dao.BookingDao;
import ch.swindiatours.model.Booking;
import ch.swindiatours.model.Cart;
import ch.swindiatours.model.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@WebServlet("/cart-check-out")
public class CheckOutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            ArrayList<Cart> cart_Service_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            User auth = (User) request.getSession().getAttribute("auth");
            if (cart_Service_list != null && auth != null) {
                for (Cart c : cart_Service_list) {
                    Booking bookings = new Booking();
                    bookings.setId(c.getId());
                    bookings.setUid(auth.getId());
                    bookings.setQunatity(c.getQuantity());
                    bookings.setDate(formatter.format(date));

                    BookingDao bDao = new BookingDao(DbCon.getConnection());
                    boolean result = bDao.insertBooking(bookings);
                    if (!result) break;
                }
                cart_Service_list.clear();
                response.sendRedirect("bookings.jsp");
            } else {
                if (auth == null) {
                    response.sendRedirect("login.jsp");
                }
                response.sendRedirect("cart.jsp");
            }
        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
