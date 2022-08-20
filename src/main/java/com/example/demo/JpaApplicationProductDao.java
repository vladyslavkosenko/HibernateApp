package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;
@Component
public class JpaApplicationProductDao implements ProductDao {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void create(Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(product);
        transaction.commit();
        entityManager.close();
    }


    @Override
    public List<Product> readAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Product> products = entityManager.createQuery("select p from Product p", Product.class)
                .getResultList();
        entityManager.close();
        return products;
    }
}
