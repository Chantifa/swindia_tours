package ch.swindiatours.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class BookingService {

    @PersistenceContext(unitName = "swindiatours")
    private EntityManager em;

}
