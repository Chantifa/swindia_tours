package ch.swindiatours.servlet;

import ch.swindiatours.dao.BookingDao;
import ch.swindiatours.Model.Booking;
import ch.swindiatours.Model.Cart;
import ch.swindiatours.Model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
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
            ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            User auth = (User) request.getSession().getAttribute("auth");
            if (cart_list != null && auth != null) {
                for (Cart c : cart_list) {
                    Booking booking = new Booking();
                    booking.setBookingId(c.getId());
                    booking.setTourId(c.getId());
                    booking.setUid(auth.getId());
                    booking.setQunatity(c.getQuantity());
                    booking.setDate(formatter.format(date));
                    EntityManagerFactory emf = Persistence.createEntityManagerFactory("swindiatours");
                    EntityManager em = emf.createEntityManager();
                    BookingDao bDao = new BookingDao(em);
                    boolean result = bDao.insertBooking(booking);
                    if (!result) break;
                }
                cart_list.clear();
                response.sendRedirect("bookings.jsp");
            } else {
                if (auth == null) {
                    response.sendRedirect("login.jsp");
                }
                response.sendRedirect("cart.jsp");
            }
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}