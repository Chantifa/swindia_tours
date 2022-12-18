package ch.swindiatours.dao;

import ch.swindiatours.Model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


public class UserDao {

    @PersistenceContext(unitName = "swindiatours")
    private EntityManager em;

    public UserDao(EntityManager em) {
        super();
        this.em = em;
    }


    public boolean userRegister(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.flush();
        em.refresh(user);
        em.getTransaction().commit();
        return true;
    }

    public User userLogin(String email, String password) {
        User user = (User) em.createNativeQuery("user.getByEmail", User.class).setParameter("email", email).getSingleResult();
        return user;
    }
}
