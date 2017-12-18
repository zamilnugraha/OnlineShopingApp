package com.sensei.DAO;

import com.sensei.model.Product;
import static java.util.Collections.list;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
public class ProductDAO {
    
    @PersistenceUnit
    EntityManagerFactory emf;
    EntityManager em;

    public ProductDAO() {
    }
    
    public List<Product> findAllProduct(){
        em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Product p");
        @SuppressWarnings("unchecked")
        List<Product> products = query.getResultList();
        return products;
    }
    
    public Product findProductById(int Id){
        em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Product p WHERE p.id =:Id ");
        query.setParameter("id", Id);
        Product product = (Product) query.getSingleResult();
        return product;
    }
    
    public List<Product> findProductBySize(String size){
        em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Product p WHERE p.category =:size ");
        query.setParameter("size", size);
        @SuppressWarnings("unchecked")
        List<Product> products = query.getResultList();
        return products;
    }
    
}
