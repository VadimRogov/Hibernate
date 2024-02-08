package com.example;

import com.example.entity.Cart;
import com.example.entity.Item;
import com.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class HibernateApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        LOGGER.info("Session created");
        session.beginTransaction();

        Cart cart = new Cart();
        Item item1 = new Item();
        Item item2 = new Item();

        Set<Item> list = new HashSet<>();
        cart.setItems(list);
        cart.getItems().add(item1);
        cart.getItems().add(item2);

        session.save(cart);
        session.save(item1);
        session.save(item2);

        session.getTransaction().commit();
        LOGGER.info("Cart ID={}", cart.getId());
        LOGGER.info("item1 ID={}, Foreign Key Cart ID={}", item1.getId(), item1.getId());
        LOGGER.info("item2 ID={}, Foreign Key Cart ID={}", item2.getId(), item2.getId());
    }

}
