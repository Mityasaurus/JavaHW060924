package org.example.dao;

import org.example.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserDAO {
    private SessionFactory factory;

    public UserDAO() {
        factory = new Configuration().configure("hibernate.cfg.xml")
//                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

    @Deprecated
    public Integer saveUser(User user){
        Session session = factory.getCurrentSession();
        Integer saved = null;
        try{
            Transaction transaction = session.beginTransaction();
            saved = (Integer) session.save(user);
            transaction.commit();
        }
        finally {
            session.close();
        }

        return saved;
    }

    public User saveMerge(User user){
        Session session = factory.getCurrentSession();
        User saved = null;
        try{
            Transaction transaction = session.beginTransaction();
            saved = session.merge(user);
            transaction.commit();
        }
        finally {
            session.close();
        }

        return saved;
    }

    public User findById(Integer id){
        Session session = factory.getCurrentSession();
        User user;
        try{
            session.beginTransaction();
            user = session.get(User.class, id);
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
        return user;
    }

    public User save(User user){
        Session session = factory.openSession();
        User saved = null;
        try{
            Transaction transaction = session.beginTransaction();
            saved = session.merge(user);
            transaction.commit();
        }
        finally {
            session.close();
        }

        return saved;
    }

    public User update(User user){
        Session session = factory.openSession();
        User updated = null;
        try{
            Transaction transaction = session.beginTransaction();
            updated = session.merge(user);
            transaction.commit();
        }
        finally {
            session.close();
        }

        return updated;
    }

    public void delete(Integer id){
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User toDelete = this.findById(id);
            if (toDelete != null)
                session.remove(toDelete);
            transaction.commit();
        }
    }

    public List<User> getAll(){
        List<User> users = null;
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            users = session.createQuery("FROM " + User.class.getName(), User.class).list();
            transaction.commit();
        }

        return users;
    }
}
