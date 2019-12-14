package com.sda.kui.gamecollector.dao;

import com.sda.kui.gamecollector.model.Platform;
import com.sda.kui.gamecollector.model.Publisher;
import com.sda.kui.gamecollector.util.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PublisherDao {


    public static void save(Publisher publisher){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(publisher);
        transaction.commit();
        session.close();

    }


}
