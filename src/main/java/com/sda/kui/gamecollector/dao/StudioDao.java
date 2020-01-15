package com.sda.kui.gamecollector.dao;

import com.sda.kui.gamecollector.model.Platform;
import com.sda.kui.gamecollector.model.Studio;
import com.sda.kui.gamecollector.util.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudioDao {


    public void save(Studio studio) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(studio);
        transaction.commit();
        session.close();

    }
    public void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Studio");

        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public void deleteByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Studio where studio = ?0");
        query.setParameter(0, name);

        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public Studio getByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Studio where studio = ?0");
        query.setParameter(0, name);

        Studio studio = (Studio) query.getSingleResult();
        session.close();
        return studio;
    }

    public List<Studio> getAllStudios(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Studio");

        List<Studio> studios = query.list();

        session.close();
        return studios;
    }

}
