package ch.swindiatours.dao;

import ch.swindiatours.model.Booking;
import ch.swindiatours.model.Tour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            query = "insert into swindiatours.public.bookings (t_id, u_id, b_quantity, b_date) values(?,?,?,?)";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, model.getId());
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
            query = "select * from swindiatours.public.bookings where u_id=? order by swindiatours.public.bookings.b_id desc";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Booking order = new Booking();
                TourDao tourDao = new TourDao(this.con);
                int pId = rs.getInt("t_id");
                Tour tour = tourDao.getSingleProduct(pId);
                order.setBookingId(rs.getInt("b_id"));
                order.setId(pId);
                order.setName(tour.getName());
                order.setDescription(tour.getDescription());
                order.setPrice(tour.getPrice() * rs.getInt("b_quantity"));
                order.setQunatity(rs.getInt("b_quantity"));
                order.setDate(rs.getString("b_date"));
                list.add(order);
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
