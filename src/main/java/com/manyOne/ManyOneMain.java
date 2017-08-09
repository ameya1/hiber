package com.manyOne;

import com.onemany.Customer;
import com.onemany.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyOneMain {
    public static void main(String[] args) {

        Passenger passenger = new Passenger("Joana", "OH");
        Ticket t1 = new Ticket("NY", "NJ", passenger);
        Ticket t2 = new Ticket("SF", "LA", passenger);
        passenger.getTickets().add(t1);
        passenger.getTickets().add(t2);

        Passenger passenger2 = new Passenger("Gary", "PA");
        Ticket t3 = new Ticket("SD", "UP", passenger2);
        Ticket t4 = new Ticket("BK", "LA", passenger2);
        passenger.getTickets().add(t3);
        passenger.getTickets().add(t4);

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Passenger.class).addAnnotatedClass(Ticket.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(passenger);
        session.save(t1);
        session.save(t2);

        session.save(passenger2);
        session.save(t3);
        session.save(t4);

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
