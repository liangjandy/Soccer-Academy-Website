package com.example.homework2.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "player")
public class Player {

    private static int currentID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    final private int id;
    private String name;
    private char gender;
    private int birthYear;

    @ManyToOne
    private Team team;

    private int age;

    public Player(String name, char gender, int birthYear, Team team) {
        this.id = currentID++;
        this.name = name;
        this.gender = gender;
        this.birthYear = birthYear;
        this.team = team;
        this.age = LocalDate.now().getYear() - birthYear;

        team.addPlayer(this);
    }

    public Player(String name, char gender, int birthYear) {
        this.id = currentID++;
        this.name = name;
        this.gender = gender;
        this.birthYear = birthYear;
        this.age = LocalDate.now().getYear() - birthYear;
        this.team = null;
    }

    public Player() {
        this.id = currentID++;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setTeam(Team team) {
        if (team == null) {
            this.team = null;
        }
        else {
            this.team = team;
            team.addPlayer(this);
        }
    }

    public Team getTeam() {
        return this.team;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public char getGender() {
        return gender;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
        this.age = LocalDate.now().getYear() - birthYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getTeamString() {
        if (this.team == null) {
            return "TBD";
        }
        else {
            return Integer.toString(team.getId());
        }
    }
}
