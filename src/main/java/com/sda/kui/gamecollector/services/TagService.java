package com.sda.kui.gamecollector.services;

import com.sda.kui.gamecollector.model.Game;
import com.sda.kui.gamecollector.model.Tag;

import java.util.ArrayList;
import java.util.List;

public class TagService {


    public static void addGameToTag(Game game, Tag tag){

        List<Game> games = new ArrayList<>();

        games.add(game);

        tag.setGames(games);

    }



}
