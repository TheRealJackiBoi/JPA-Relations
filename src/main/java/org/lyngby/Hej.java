package org.lyngby;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import org.lyngby.HibernateConfig;
import org.lyngby.Person;
import org.lyngby.Phone;


public class Hej {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
        Phone p1 = new Phone("111-222-22");
        Phone p2 = new Phone("100-222-22");

        Person steve = new Person("Steve");
        //Person benji = new Person("benji");

        steve.setPhones(p1);
        steve.setPhones(p2);

        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(steve);
            em.persist(p1);
            em.persist(p2);
            em.getTransaction().commit();
        }
    }
}
