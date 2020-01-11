package com.sda.kui.gamecollector.dao;

import com.sda.kui.gamecollector.model.Platform;
import com.sda.kui.gamecollector.model.Publisher;
import com.sda.kui.gamecollector.util.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PublisherDao {

    public List<Publisher> getAllPublishers(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Publisher");

        return query.list();

    }


    public void save(Publisher publisher){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        if (!getAllPublishers().contains(publisher)){
            session.saveOrUpdate(publisher);
            transaction.commit();
        }
        session.close();

    }
    public void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Publisher");

        query.executeUpdate();
        transaction.commit();
        session.close();
    }
    public Publisher getByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Publisher where name = ?0");
        query.setParameter(0, name);

        List<Publisher> game = query.list();

        session.close();
        return game.get(0);

    }


}
