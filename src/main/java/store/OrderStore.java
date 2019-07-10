package store;

import entities.Order;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderStore {

    public static Order getOrder(int orderId) {
        Session session = StoreFactory.getFactorySingleton().openSession();
        Transaction transaction = null;

        Order order = null;

        try {
            transaction = session.beginTransaction();
            order = session.get(Order.class, orderId);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                System.out.println("Transaction resulted in rollback: " + e.getMessage());
            }
        } finally {
            session.close();
        }

        return order;
    }

    public static void updateOrder(Order order) {
        Session session = StoreFactory.getFactorySingleton().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(order);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                System.out.println("Transaction resulted in rollback: " + e.getMessage());
            }
        } finally {
            session.close();
        }
    }

    public static Integer addOrder(Order order) {
        Session session = StoreFactory.getFactorySingleton().openSession();
        Transaction transaction = null;
        Integer orderId = -1;

        try {
            transaction = session.beginTransaction();
            orderId = (Integer)session.save(order);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                System.out.println("Transaction resulted in rollback: " + e.getMessage());
            }
        } finally {
            session.close();
        }

        return orderId;
    }

    public static void deleteOrder(int orderId) {
        Session session = StoreFactory.getFactorySingleton().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Order order = session.get(Order.class, orderId);
            session.delete(order);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                System.out.println("Transaction resulted in rollback: " + e.getMessage());
            }
        } finally {
            session.close();
        }
    }

    // TODO: integrate methods later
    public static void updateTotal(int orderId, double total) {
        Order order = getOrder(orderId);
        order.setTotal(total);
        updateOrder(order);
    }

    // TODO: integrate methods later
    public static void updateCollectMethod(int orderId, String collectMethod) {
        Order order = getOrder(orderId);
        order.setCollectMethod(collectMethod);
        updateOrder(order);
    }
}
