package com.sda.kui.gamecollector.dao;

import com.sda.kui.gamecollector.model.Game;
import com.sda.kui.gamecollector.util.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GameDao {

    public static Game getGameById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Game game = session.get(Game.class, id);

        session.close();

        return game;

    }

    public static void insertNewGame(Game game){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(game);
        transaction.commit();
        session.close();

    }


}
