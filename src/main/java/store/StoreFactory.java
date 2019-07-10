package store;

import entities.Order;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreFactory {
    private static SessionFactory factorySingleton;

    public static void initializeSession() {
        try {
            factorySingleton = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Could not set up new session factory: " + e);
        }
    }

    public static SessionFactory getFactorySingleton() {
        if (factorySingleton == null) {
            System.out.println("Store factory singleton is not initialized");
        }

        return factorySingleton;
    }
}
