//package com.cs545.waa.namastenepalsupermarket.model;
//
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//
//public class App {
//
//    private static final SessionFactory sessionFactory;
//
//    static {
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        ServiceRegistry serviceRegistry
//                = new StandardServiceRegistryBuilder().applySettings(
//                        configuration.getProperties()).build();
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//    }
//
//    public static void fillDataBase() {
//        Session session = null;
//        Transaction tx = null;
//
//        try {
//            session = sessionFactory.openSession();
//            tx = session.beginTransaction();
//
//            Address a=new Address();
//            Person p=new Person();
//            Category c=new Category();
//            Order o=new Order();
//            State s=new State();
//
////            session.persist(a);
////            session.persist(c);
////            session.persist(o);
////            session.persist(p);
////            session.persist(s);
//                        
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//                e.printStackTrace(System.err);
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }
//    
//    public static void main(String[] args) {
//        // Hibernate placeholders
//        Session session = null;
//        Transaction tx = null;
//
//        // fill the database
//        fillDataBase();
//
//        // a) Flights leaving USA capacity > 500
//        try {
//            session = sessionFactory.openSession();
//            tx = session.beginTransaction();
//            
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//                e.printStackTrace(System.err);
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }    
//   }
//}
