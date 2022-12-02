package ch.swindiatours.services;

import ch.swindiatours.Entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class UserService {
    @PersistenceContext(unitName = "swindiatours")
    private EntityManager em;

    public boolean userRegister(User user){
        em.getTransaction().begin();
        em.persist(user);
        em.flush();
        em.refresh(user);
        em.getTransaction().commit();
        return true;
     }

    public User userLogin(String email, String password){
            return em.createNamedQuery("user.getByEmail", User.class).setParameter("email",email ).getSingleResult();
        }
}
