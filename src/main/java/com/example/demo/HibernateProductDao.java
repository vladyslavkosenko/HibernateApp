package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HibernateProductDao implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(product);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Product> readAll() {
        Session session = sessionFactory.openSession();
        List<Product> products = session.createQuery("select p from Product p", Product.class).list();
        session.close();
        return products;
    }
}
