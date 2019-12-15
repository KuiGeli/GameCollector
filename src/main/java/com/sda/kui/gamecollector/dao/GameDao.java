package com.sda.kui.gamecollector.dao;

import com.sda.kui.gamecollector.model.Game;
import com.sda.kui.gamecollector.model.Status;
import com.sda.kui.gamecollector.util.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GameDao {

    public Game getGameById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Game game = session.get(Game.class, id);

        session.close();

        return game;

    }

    public void save(Game game) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(game);
        transaction.commit();
        session.close();

    }

    public Game getByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Game where name = ?0");
        query.setParameter(0, name);

        List<Game> game = query.list();

        session.close();
        return game.get(0);

    }

    public List<Game> getByStatus(Status status){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Game where status = ?1");
        query.setParameter(1, status);

        List<Game> games = query.list();

        session.close();
        return games;
    }


    public List<Game> getAllGames(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Game");

        return query.list();

    }

    public static void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Game");

        query.executeUpdate();
        transaction.commit();
        session.close();
    }

}
