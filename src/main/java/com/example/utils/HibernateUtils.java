package com.example.utils;

import com.example.entity.Cart;
import com.example.entity.Item;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

    public static SessionFactory getSessionFactory() {

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Cart.class)
                .addAnnotatedClass(Item.class)
                .buildMetadata();

        return metadata.buildSessionFactory();
    }
}
