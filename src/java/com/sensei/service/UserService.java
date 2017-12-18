package com.sensei.service;

import com.sensei.model.User;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
@Transactional
public class UserService {

    static final Logger logger = Logger.getLogger(UserService.class.getName());

    @PersistenceUnit
    EntityManagerFactory emf;
    private EntityManager em;

    @Transactional
    public void saveUser(User users) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(users);
        em.getTransaction().commit();
        em.close();
    }

    public void editUser(User user) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    public User findByUsername(String userName) {
        User user = new User();
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery("SELECT u FROM User u WHERE u.username =:userName");
            query.setParameter("userName", userName);
            user = (User) query.getSingleResult();
        } catch (NoResultException nre) {
            logger.severe("Username tidak ada");
        }
        return user;
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

}
