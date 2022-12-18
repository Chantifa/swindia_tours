package ch.swindiatours.dao;

import ch.swindiatours.Model.Cart;
import ch.swindiatours.Model.Tour;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class TourDao {
    @PersistenceContext(unitName = "swindiatours")
    private EntityManager em;


    public TourDao(EntityManager em) {
        super();
        this.em = em;
    }


    public List<Tour> getAllTours() {
        List<Tour> tourList = em.createNativeQuery("tour.findAll", Tour.class).getResultList();
        return tourList;
    }

    public Tour getSingleTour(int id) {
        Tour row = null;
        return (Tour) em.createNativeQuery("tour.findById", Tour.class).setParameter("id", id).getSingleResult();
    }

    public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0;
        if (cartList.size() > 0) {
            for (Cart item : cartList) {
                double price = (double) em.createNativeQuery("tour.findByPrice", Tour.class).setParameter("id", item.getId()).getSingleResult();
                sum += price * item.getQuantity();
            }
        }
        return sum;
    }


    public List<Cart> getCartTours(ArrayList<Cart> cartList) {
        List<Cart> book = new ArrayList<>();
        if (cartList.size() > 0) {
            for (Cart item : cartList) {
                book = em.createNativeQuery("tour.findAll", Tour.class).setParameter("id", item.getId()).getResultList();
            }
        }
        return book;
    }
}
