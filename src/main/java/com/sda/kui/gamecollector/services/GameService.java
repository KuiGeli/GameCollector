package com.sda.kui.gamecollector.services;

import com.sda.kui.gamecollector.dao.*;
import com.sda.kui.gamecollector.model.*;

import java.util.List;

public class GameService {


    GameDao gameDao = new GameDao();
    PlatformDao platformDao = new PlatformDao();
    PublisherDao publisherDao = new PublisherDao();
    TagDao tagDao = new TagDao();
    StudioDao studioDao = new StudioDao();


    public List<Game> getAllGames() {
        List<Game> games = gameDao.getAllGames();

        for (Game game : games) {
            System.out.println(game);
        }
        return games;
    }

    public void addTagToGame(Game game, String tagName) {
        Tag tag = new Tag();
        tag.setTag(tagName);
        boolean isDuplicate = false;

        for (Tag tag1 : tagDao.getAllTags()) {
            if (tag1.getTag().equalsIgnoreCase(tagName)){
                Tag tag2 = tagDao.getByName(tagName);
                tag2.getGames().add(game);
                game.getTags().add(tag2);
                tagDao.save(tag2);
                isDuplicate = true;
                break;
            }
        }
        if(!isDuplicate) {
            game.getTags().add(tag);
            gameDao.save(game);
        }
    }

    public void addPlatformToGame(Game game, String platName)  {
        Platform platform = new Platform();
        platform.setPlatform(platName);
        boolean isDuplicate = false;
        for (Platform platform1 : platformDao.getAllPlatforms()) {
            if (platform1.getPlatform().equalsIgnoreCase(platName)) {
                Platform platform2 = platformDao.getByName(platName);
                platform2.getGames().add(game);
                game.getPlatforms().add(platform2);
                platformDao.save(platform2);
                isDuplicate = true;
                break;
            }
        }
        if (!isDuplicate) {
            game.getPlatforms().add(platform);
            gameDao.save(game);
        }
    }

    public void addPublisherToGame(Game game, String publisherName)  {
        Publisher publisher = new Publisher();
        publisher.setPublisher(publisherName);
        boolean isDuplicate = false;

        for (Publisher publisher1 : publisherDao.getAllPublishers()) {
            if (publisher1.getPublisher().equalsIgnoreCase(publisherName)) {
                Publisher publisher2 = publisherDao.getByName(publisherName);
                publisher2.getGames().add(game);
                game.getPublishers().add(publisher2);
                publisherDao.save(publisher2);
                isDuplicate = true;
                break;
            }
        }

        if (!isDuplicate) {
            game.getPublishers().add(publisher);
            gameDao.save(game);
        }
    }

    public void addStudioToGame(Game game, String studioName)  {
        Studio studio = new Studio();
        studio.setStudio(studioName);
//        game.getStudios().add(studio);
        boolean isDuplicate = false;

        for (Studio studio1 : studioDao.getAllStudios()){
            if (studio1.getStudio().equalsIgnoreCase(studioName)){
                Studio studio2 = studioDao.getByName(studioName);
                studio2.getGames().add(game);
                game.getStudios().add(studio2);
                studioDao.save(studio2);
                isDuplicate = true;
                break;
            }
        }

        if(!isDuplicate) {
            game.getStudios().add(studio);
            gameDao.save(game);
        }
    }

    public void saveGame(Game game) {
        gameDao.save(game);
    }

}
