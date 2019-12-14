package com.sda.kui.gamecollector.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pl_id")
    private int plId;

    @Column
    private String platform;

    @ManyToMany(mappedBy = "platforms")
    private List<Game> games = new ArrayList<>();

    @Override
    public String toString() {
        return "Platform{" +
                "platform='" + platform + '\'' +
                '}';
    }

    public Platform(String platform, List<Game> games) {
        this.platform = platform;
        this.games = games;
    }

    public Platform(String platform) {
        this.platform = platform;
    }

    public Platform() {
    }

    public int getPlId() {
        return plId;
    }

    public void setPlId(int plId) {
        this.plId = plId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
