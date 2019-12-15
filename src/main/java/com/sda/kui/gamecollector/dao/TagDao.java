package com.sda.kui.gamecollector.dao;

import com.sda.kui.gamecollector.model.Tag;
import com.sda.kui.gamecollector.util.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TagDao {

    public static void save(Tag tag) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(tag);
        transaction.commit();
        session.close();

    }

    public static void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Tag");

        query.executeUpdate();
        transaction.commit();
        session.close();

    }

    public List<Tag> getAllTags(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Tag");

        return query.list();


    }

}