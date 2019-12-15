package com.sda.kui.gamecollector;

import com.sda.kui.gamecollector.dao.*;
import com.sda.kui.gamecollector.model.*;
import com.sda.kui.gamecollector.services.TagService;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
//
//        Studio frontier = new Studio("Frontier Developments");
//        Publisher frontier1 = new Publisher("Frontier Developments");
//        Platform pc = new Platform("PC");
//
//        List<Studio> studios = new ArrayList<>();
//        studios.add(frontier);
//        List<Publisher> publishers = new ArrayList<>();
//        publishers.add(frontier1);
//        List<Platform> platforms = new ArrayList<>();
//        platforms.add(pc);
//
//        Game elite = new Game();
//        elite.setName("Elite Dangerous");
//        elite.setPlatforms(platforms);
//        elite.setPublishers(publishers);
//        elite.setStudios(studios);
//        elite.setStatus(Status.PLAYING);
//        List<Game> games = new ArrayList<>();
//        games.add(elite);
//
//
//
//
////        PlatformDao.save(pc);
////        PublisherDao.save(frontier1);
////        StudioDao.save(frontier);
//        GameDao.insertNewGame(elite);
        //asdasdasdasd


//
//        Tag tag = new Tag();
//
//        tag.setTag("Space Simulator");
//
//        TagService.addGameToTag(GameDao.getGameById(14), tag);
//
//        TagDao.save(tag);

        System.out.println(GameDao.getGameById(14));


    }


}
