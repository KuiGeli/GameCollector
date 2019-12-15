package com.sda.kui.gamecollector.dao;

import com.sda.kui.gamecollector.model.Platform;
import com.sda.kui.gamecollector.model.Studio;
import com.sda.kui.gamecollector.util.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class StudioDao {


    public static void save(Studio studio) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(studio);
        transaction.commit();
        session.close();

    }
    public static void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Studio");

        query.executeUpdate();
        transaction.commit();
        session.close();
    }

}
