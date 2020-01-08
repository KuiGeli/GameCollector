package com.sda.kui.gamecollector.services;

import com.sda.kui.gamecollector.dao.GameDao;
import com.sda.kui.gamecollector.model.*;

import java.util.List;

public class GameService {


    GameDao gameDao = new GameDao();



    public List<Game> getAllGames(){
        List<Game> games = gameDao.getAllGames();

        for (Game game : games){
            System.out.println(game);
        }
        return games;
    }

    public void addTagToGame(Game game, String tagName){
        Tag tag = new Tag();
        tag.setTag(tagName);
        game.getTags().add(tag);
        gameDao.save(game);
    }

    public void addPlatformToGame(Game game, String platName){
        Platform platform = new Platform();
        platform.setPlatform(platName);
        game.getPlatforms().add(platform);
        gameDao.save(game);

    }

    public void addPublisherToGame(Game game, String publisherName){
        Publisher publisher = new Publisher();
        publisher.setPublisher(publisherName);
        game.getPublishers().add(publisher);
        gameDao.save(game);
    }

    public void addStudioToGame(Game game, String studioName){
        Studio studio = new Studio();
        studio.setStudio(studioName);
        game.getStudios().add(studio);
        gameDao.save(game);
    }

}
