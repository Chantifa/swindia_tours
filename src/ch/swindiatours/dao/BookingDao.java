package ch.swindiatours.dao;

import ch.swindiatours.model.Booking;
import ch.swindiatours.model.Tour;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDao {
    private Connection con;

    private String query;
    private PreparedStatement pst;
    private ResultSet rs;


    public BookingDao(Connection con) {
        super();
        this.con = con;
    }

    public boolean insertBooking(Booking model) {
        boolean result = false;
        try {
            query = "insert into bookings (b_id,t_id, u_id, b_quantity, b_date) values(?,?,?,?)";
            pst = this.con.prepareStatement(query);
            pst.setInt(1,model.getId());
            pst.setInt(2, model.getUid());
            pst.setInt(3, model.getQunatity());
            pst.setString(4, model.getDate());
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


    public List<Booking> userBookings(int id) {
        List<Booking> list = new ArrayList<>();
        try {
            query = "select * from bookings where u_id=? order by bookings.b_id desc";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking();
                TourDao tourDao = new TourDao(this.con);
                int tourId = rs.getInt("t_id");
                Tour tour = tourDao.getSingleTour(tourId);
                booking.setBookingId(booking.getBookingId());
                booking.setTourId(tourId);
                booking.setName(tour.getName());
                booking.setDescription(tour.getDescription());
                booking.setPrice(tour.getPrice() * rs.getInt("b_quantity"));
                booking.setQunatity(rs.getInt("b_quantity"));
                booking.setDate(rs.getString("b_date"));
                list.add(booking);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void cancelBooking(int id) {
        //boolean result = false;
        try {
            query = "delete from swindiatours.public.bookings where b_id=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            //result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
    }
}
