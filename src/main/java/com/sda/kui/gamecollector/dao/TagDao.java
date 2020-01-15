package com.sda.kui.gamecollector.dao;

import com.sda.kui.gamecollector.model.Tag;
import com.sda.kui.gamecollector.util.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TagDao {



    public void save(Tag tag) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(tag);
        transaction.commit();
        session.close();

    }

    public void deleteAll() {
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

        List<Tag> tags = query.list();

        session.close();
        return tags;
    }

    public Tag getByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Tag where tag = ?0");
        query.setParameter(0, name);

        List<Tag> game = query.list();

        session.close();
        return game.get(0);

    }

}