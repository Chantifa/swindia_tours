package ch.swindiatours.dao;

import ch.swindiatours.Model.Booking;
import ch.swindiatours.Model.Tour;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class BookingDao {

    @PersistenceContext(unitName = "swindiatours")
    private EntityManager em;

    public BookingDao(EntityManager em) {
        super();
        this.em = em;
    }


    public boolean insertBooking(Booking booking) {
        em.getTransaction().begin();
        em.persist(booking);
        em.flush();
        em.refresh(booking);
        em.getTransaction().commit();
        return true;
    }


    public List<Booking> userBookings(int id) {
        List<Booking> list = new ArrayList<>();
        Booking booking = new Booking();
        TourDao tourDao = new TourDao(em);
        int quantity = em.createNativeQuery("boooking.getQuantityByBookingId", Booking.class).setParameter("bid", booking.getBookingId()).getFirstResult();
        int tourId = em.createNativeQuery("booking.findById", Booking.class).setParameter("tid", id).getFirstResult();
        Tour tour = tourDao.getSingleTour(tourId);
        booking.setBookingId(booking.getBookingId());
        booking.setTourId(tourId);
        booking.setName(tour.getName());
        booking.setDescription(tour.getDescription());
        booking.setPrice(tour.getPrice() * (quantity));
        booking.setQunatity(booking.getQunatity());
        booking.setDate(em.createNativeQuery("booking.getBookingDate", Booking.class).setParameter("date", booking.getDate()).toString());
        list.add(booking);
        return list;
    }

    public void cancelBooking(int id) {
        //boolean result = false;
        em.remove(id);
    }
}
