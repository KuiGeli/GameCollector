package com.sda.kui.gamecollector.services;

import com.sda.kui.gamecollector.model.Game;
import com.sda.kui.gamecollector.model.Tag;

public class TagService {


    public void addGameToTag(Game game, Tag tag){

        tag.getGames().add(game);

    }





}
