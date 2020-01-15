package com.sda.kui.gamecollector.dao;

import com.sda.kui.gamecollector.model.Game;
import com.sda.kui.gamecollector.model.Platform;
import com.sda.kui.gamecollector.util.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PlatformDao {

    public  List<Platform> getAllPlatforms(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Platform");

        List<Platform> platforms = query.list();

        session.close();
        return platforms;

    }

    public  void save(Platform platform){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(platform);
        transaction.commit();

        session.close();

    }
    public void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Platform");

        query.executeUpdate();
        transaction.commit();
        session.close();
    }
    public Platform getByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Platform where platform = ?0");
        query.setParameter(0, name);

        List<Platform> platform = query.list();

        session.close();
        return platform.get(0);

    }

}
