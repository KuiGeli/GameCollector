package com.sda.kui.gamecollector.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "studios")
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studio_id")
    private int studioId;

    @Column(name = "st_name")
    private String studio;

    @ManyToMany(mappedBy = "studios")
    private List<Game> games = new ArrayList<>();


    @Override
    public String toString() {
        return studio;
    }

    public Studio(String studio, List<Game> games) {
        this.studio = studio;
        this.games = games;
    }

    public Studio(String studio) {
        this.studio = studio;
    }

    public Studio() {
    }

    public int getStudioId() {
        return studioId;
    }

    public void setStudioId(int studioId) {
        this.studioId = studioId;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
