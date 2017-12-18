/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mxc.dao;

import id.co.mxc.model.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Repository
@Transactional
public class ProductDao {
    
    @PersistenceUnit
    EntityManagerFactory emf;
    EntityManager em;

    public ProductDao() {
    }
    
    public List<Product> findAllProduct(){
        em = emf.createEntityManager();
        Query query = em.createQuery("Select p from Product p");
        List<Product> products = query.getResultList();
        return products;
    }
    
    public Product findById(int Id){
        em = emf.createEntityManager();
        Query query = em.createQuery("Select p from Product p where p.id=:id");
        query.setParameter("id", Id);
        Product product = (Product) query.getSingleResult();
        return product;
    }
    
    public List<Product> findBySize(String size){
        em = emf.createEntityManager();
        Query query = em.createQuery("Select p from Product p where p.productCategory=:size");
        query.setParameter("size", size);
        List<Product> products = query.getResultList();
        return products;
    }
}
