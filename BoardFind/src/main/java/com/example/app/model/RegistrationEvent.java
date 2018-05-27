package com.example.app.model;

import com.example.app.entity.User;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class RegistrationEvent {
    @Size(min = 5, max = 100, message = "Event name too short")
    private String name;
    private List<String> games = new ArrayList<>();
    private List<User> players = new ArrayList<>();
    private double latitude;
    private double longitude;
    private String description;
    private User owner;
    private String date;
    private String gamesToParse;
    private String usersToParse;

    public String getGamesToParse() {
        return gamesToParse;
    }

    public void setGamesToParse(String gamesToParse) {
        this.gamesToParse = gamesToParse;
    }

    public String getUsersToParse() {
        return usersToParse;
    }

    public void setUsersToParse(String usersToParse) {
        this.usersToParse = usersToParse;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public List<User> getPlayers() {
        return players;
    }

    public void setPlayers(List<User> players) {
        this.players = players;
    }

    public List<String> getGames() {
        return games;
    }

    public void setGames(String gamesData) {
        String[] array = gamesData.split(",");
        for (String g:array) {
            this.games.add(g);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
