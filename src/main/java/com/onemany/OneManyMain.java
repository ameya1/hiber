package com.onemany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneManyMain {
    public static void main(String[] args) {

        Order o1 = new Order("soap", 10, 100.0);
        Order o2 = new Order("book", 20, 200.0);

        Customer customer = new Customer("Natasha", "NYC");
        customer.getOrders().add(o1);
        customer.getOrders().add(o2);

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Order.class).addAnnotatedClass(Customer.class);
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(customer);
        session.save(o1);
        session.save(o2);
        tx.commit();
        session.close();
        factory.close();
    }
}
