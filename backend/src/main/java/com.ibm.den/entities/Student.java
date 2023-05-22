package com.ibm.den.entities;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
    @Column(nullable = false)
    private boolean leader;
    @Column(nullable = false)
    //efort in plus
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = false)
    private ArrayList<Task> tasks;

    @Column(nullable = false)
    private String email;


    public Student() {
    }

    public Student(String name, Team team, Boolean leader, ArrayList<Task> tasks) {
        this.name = name;
        this.team = team;
        this.leader = leader;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Boolean getLeader() {
        return leader;
    }

    public void setLeader(Boolean role) {
        this.leader = leader;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLeader() {
        return leader;
    }

    public void setLeader(boolean leader) {
        this.leader = leader;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team=" + team +
                ", role='" + leader + '\'' +
                ", tasks=" + tasks +
                '}';
    }


}