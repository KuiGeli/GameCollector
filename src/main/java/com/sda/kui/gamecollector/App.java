package com.sda.kui.gamecollector;

import com.sda.kui.gamecollector.dao.*;
import com.sda.kui.gamecollector.model.*;
import com.sda.kui.gamecollector.services.GameService;
import com.sda.kui.gamecollector.services.TagService;
import com.sda.kui.gamecollector.view.AppView;

import java.util.ArrayList;
import java.util.List;

public class App extends AppView {

    public static void main(String[] args) {
//        launch();


        GameDao gameDao = new GameDao();
        System.out.println(gameDao.getByPlatform("PS4"));

//        gameDao.deleteByName("God of War");
//        GameService gameService = new GameService();
//        Game game = new Game();
//
//        game.setName("Bloodborne");
//        game.setStatus(Status.PLAYING);
//        gameService.addPlatformToGame(game, "PS4");
//        gameService.addPublisherToGame(game, "FromSoftware");
//        gameService.addStudioToGame(game, "FromSoftware");
//        gameService.addTagToGame(game, "Horror");
//
//
//        gameDao.save(game);


    }


}
