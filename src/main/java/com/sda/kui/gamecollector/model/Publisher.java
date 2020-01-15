package com.sda.kui.gamecollector.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private int publisherId;

    @Column(name = "publisher_name")
    private String publisher;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "publishers")
    private List<Game> games = new ArrayList<>();

    @Override
    public String toString() {
        return publisher;
    }

    public Publisher(String publisher, List<Game> games) {
        this.publisher = publisher;
        this.games = games;
    }

    public Publisher(String publisher) {
        this.publisher = publisher;
    }

    public Publisher() {
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
