package com.one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneMain {
    public static void main(String[] args) {

        Subject subject = new Subject("Physics", "Science");
        Teacher teacher = new Teacher("Jenna", 20000.00, subject);

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Teacher.class).addAnnotatedClass(Subject.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(teacher);
        session.save(subject);

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
