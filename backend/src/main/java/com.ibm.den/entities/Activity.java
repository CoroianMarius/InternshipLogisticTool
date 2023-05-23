package com.ibm.den.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private String name;

    @Column
    @OneToMany(mappedBy = "id")
    private List<Task> tasks;

    @Column
    @OneToMany(mappedBy = "id")
    private List<Team> teams;

    public Activity(String name) {
        this.name = name;
    }

    public Activity(long id, String name, List<Task> tasks, List<Team> teams) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
        this.teams = teams;
    }

    public Activity() {
    }


    public void addTeam(Team team) {
        teams.add(team);
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
