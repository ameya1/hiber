package com.manymany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyManyMain {
    public static void main(String[] args) {
        Employee e1 = new Employee("Sansa", 20000.0);
        Dept d1 = new Dept("RND", 6);
        Dept d2 = new Dept("Finance", 7);
        e1.getDepts().add(d1);
        e1.getDepts().add(d2);

        d1.getEmployees().add(e1);
        d2.getEmployees().add(e1);

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Dept.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(e1);
        session.save(d1);
        session.save(d2);

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
