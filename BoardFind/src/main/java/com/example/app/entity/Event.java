package com.example.app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> games;
    @ManyToMany(fetch=FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(name = "event_users", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<User> players;
    private double latitude;
    private double longitude;
    private String description;
    private String date;
    private User owner;
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

    public User getOwner(){
        return owner;
    }
    public void setOwner(User owner){
        this.owner = owner;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public double getLatitude(){
        return latitude;
    }
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    public double getLongitude(){
        return longitude;
    }
    public void setLongitude( double longitude){
        this.longitude = longitude;
    }

    public String getName(){
        return name;
    }
    public void setName( String name){
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getGames() {
        return games;
    }

    public void setGames(List<String> games) {
        this.games = games;
    }

    public void setGames(String gamesData) {
        String[] array = gamesData.split(",");
        for (String g:array) {
            this.games.add(g);
        }
    }

    public List<User> getPlayers() {
        return players;
    }

    public void setPlayers(List<User> players) {
        this.players = players;
    }

}
