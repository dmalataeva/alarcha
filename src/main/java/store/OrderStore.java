package store;

import entities.Order;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.OrderRepository;

import java.util.Optional;

@Service
public class OrderStore {

    private static Logger logger = LoggerFactory.getLogger(OrderStore.class);

    @Autowired
    private static OrderRepository orderRepository;

    public static Order getOrder(int orderId) {
        //Session session = StoreFactory.getFactorySingleton().openSession();
        //Transaction transaction = null;

        Order order = new Order();
        order.setOrderId(orderId);

        Optional<Order> res = orderRepository.findById(orderId);
        logger.info("Order res: " + res);
        return res.orElse(null);

        /*try {
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

        return order;*/
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
