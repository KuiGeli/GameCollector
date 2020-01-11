package com.sda.kui.gamecollector.dao;

import com.sda.kui.gamecollector.model.*;
import com.sda.kui.gamecollector.util.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class GameDao {

    PlatformDao platformDao = new PlatformDao();
    PublisherDao publisherDao = new PublisherDao();
    TagDao tagDao = new TagDao();

    public Game getGameById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Game game = session.get(Game.class, id);

        session.close();

        return game;

    }

    public void save(Game game)throws Exception {
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
    public List<Game> getByPlatform(String platform) {

        List<Platform> platformList = platformDao.getAllPlatforms();
        List<Game> gamesByPlatforms = new ArrayList<>();

        for (Platform platform1 : platformList){
            if(platform1.getPlatform().equalsIgnoreCase(platform)){
                gamesByPlatforms.addAll(platform1.getGames());
            }
        }

        return gamesByPlatforms;
    }

    public List<Game> getByPublisher(String publisher) {

        List<Publisher> publisherList = publisherDao.getAllPublishers();
        List<Game> gamesByPublisher = new ArrayList<>();

        for (Publisher publisher1 : publisherList){
            if(publisher1.getPublisher().equalsIgnoreCase(publisher)){
                gamesByPublisher.addAll(publisher1.getGames());
            }
        }

        return gamesByPublisher;
    }

    public List<Game> getByTag(String tag) {

        List<Tag> tagList = tagDao.getAllTags();
        List<Game> gamesByTags = new ArrayList<>();

        for (Tag tag1 : tagList){
            if(tag1.getTag().equalsIgnoreCase(tag)){
                gamesByTags.addAll(tag1.getGames());
            }
        }

        return gamesByTags;
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

    public void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Game");

        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public void deleteByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Game where name = ?0");
        query.setParameter(0, name);

        query.executeUpdate();
        transaction.commit();
        session.close();
    }


}
