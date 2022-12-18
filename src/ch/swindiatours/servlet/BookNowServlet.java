package ch.swindiatours.servlet;

import ch.swindiatours.Model.Booking;
import ch.swindiatours.Model.Cart;
import ch.swindiatours.Model.User;
import ch.swindiatours.dao.BookingDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@WebServlet("/book-now")
public class BookNowServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            User auth = (User) request.getSession().getAttribute("auth");

            if (auth != null) {
                String tourId = request.getParameter("id");
                int tourQuantiy = Integer.parseInt(request.getParameter("quantity"));
                if (tourQuantiy <= 0) {
                    tourQuantiy = 1;
                }
                Booking booking = new Booking();
                booking.setTourId(Integer.parseInt(tourId));
                booking.setUid(auth.getId());
                booking.setQunatity(tourQuantiy);
                booking.setDate(formatter.format(date));
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("swindiatours");
                EntityManager em = emf.createEntityManager();
                BookingDao bookingDao = new BookingDao(em);
                boolean result = bookingDao.insertBooking(booking);
                if (result) {
                    ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
                    if (cart_list != null) {
                        for (Cart c : cart_list) {
                            if (c.getId() == Integer.parseInt(tourId)) {
                                cart_list.remove(c);
                                break;
                            }
                        }
                    }
                    response.sendRedirect("bookings.jsp");
                } else {
                    out.println("booking failed");
                }
            } else {
                response.sendRedirect("login.jsp");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}