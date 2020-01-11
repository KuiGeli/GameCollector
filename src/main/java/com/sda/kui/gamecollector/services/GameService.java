package com.sda.kui.gamecollector.services;

import com.sda.kui.gamecollector.dao.GameDao;
import com.sda.kui.gamecollector.dao.PlatformDao;
import com.sda.kui.gamecollector.dao.PublisherDao;
import com.sda.kui.gamecollector.dao.TagDao;
import com.sda.kui.gamecollector.model.*;

import java.util.List;

public class GameService {


    GameDao gameDao = new GameDao();
    PlatformDao platformDao = new PlatformDao();
    PublisherDao publisherDao = new PublisherDao();
    TagDao tagDao = new TagDao();


    public List<Game> getAllGames() {
        List<Game> games = gameDao.getAllGames();

        for (Game game : games) {
            System.out.println(game);
        }
        return games;
    }

    public void addTagToGame(Game game, String tagName) throws Exception {
        Tag tag = new Tag();
        tag.setTag(tagName);
        boolean isDuplicate = false;

        for (Tag tag1 : tagDao.getAllTags()) {
            if (tag1.getTag().equalsIgnoreCase(tagName)){
                Tag tag2 = tagDao.;
                platform2.getGames().add(game);
                platformDao.save(platform2);
                isDuplicate = true;
                break;
            }
        }




        game.getTags().add(tag);
        gameDao.save(game);
    }

    public void addPlatformToGame(Game game, String platName) throws Exception {
        Platform platform = new Platform();
        platform.setPlatform(platName);
        int i = 0;
        for (Platform platform1 : platformDao.getAllPlatforms()) {
            if (platform1.getPlatform().equalsIgnoreCase(platName)) {
                Platform platform2 = platformDao.getByName(platName);
                platform2.getGames().add(game);
                platformDao.save(platform2);
                i++;
                break;
            }
        }
        if (i == 0) {
            game.getPlatforms().add(platform);

            gameDao.save(game);
        }
    }

    public void addPublisherToGame(Game game, String publisherName) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setPublisher(publisherName);
        boolean isDuplicate = false;

        for (Publisher publisher1 : publisherDao.getAllPublishers()) {
            if (publisher1.getPublisher().equalsIgnoreCase(publisherName)) {
                Publisher publisher2 = publisherDao.getByName(publisherName);
                publisher2.getGames().add(game);
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

    public void addStudioToGame(Game game, String studioName) throws Exception {
        Studio studio = new Studio();
        studio.setStudio(studioName);
        game.getStudios().add(studio);
        gameDao.save(game);
    }

    public void saveGame(Game game) throws Exception {
        gameDao.save(game);
    }

}
