package com.ibm.den.Classes;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.annotation.processing.Generated;
import java.beans.ConstructorProperties;
import java.util.ArrayList;

@Entity
@Table()
public class Student
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
    @Column(nullable = false)
    private String role;
    @Column(nullable = false)
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = false)
    private ArrayList<Task> tasks;

    public Student() {
    }

    public Student(String name, Team team, String role, ArrayList<Task> tasks) {
        this.name = name;
        this.team = team;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
                ", role='" + role + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}