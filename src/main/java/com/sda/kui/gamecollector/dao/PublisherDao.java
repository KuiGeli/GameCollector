package com.sda.kui.gamecollector.dao;

import com.sda.kui.gamecollector.model.Platform;
import com.sda.kui.gamecollector.model.Publisher;
import com.sda.kui.gamecollector.util.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class PublisherDao {


    public static void save(Publisher publisher){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(publisher);
        transaction.commit();
        session.close();

    }
    public static void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Publisher");

        query.executeUpdate();
        transaction.commit();
        session.close();
    }


}
