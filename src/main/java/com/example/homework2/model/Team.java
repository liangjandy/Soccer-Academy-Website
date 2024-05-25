package com.example.homework2.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {
    private static int teamID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String uniformColor;
    char gender;
    int minAge;
    int maxAge;

    @OneToMany
    private List<Player> players;

    int numberOfPlayers = 0;

    public Team(int id, String uniformColor, char gender, int minAge, int maxAge) {
        players = new ArrayList<>();
        this.id = id;
        this.uniformColor = uniformColor;
        this.gender = gender;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public Team(String uniformColor, char gender, int minAge, int maxAge) {
        players = new ArrayList<>();
        this.id = teamID++;
        this.uniformColor = uniformColor;
        this.gender = gender;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public Team() {
        this.id = teamID++;
        this.players = new ArrayList<Player>();
    }

    public int getId() {
        return id;
    }

    public String getUniformColor() {
        return uniformColor;
    }

    public char getGender() {
        return gender;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
        this.numberOfPlayers++;
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
        this.numberOfPlayers--;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public List<Player> getPlayers() {
        return this.players;
    }
}
