package com.ibm.den.dto;

import com.ibm.den.entities.Task;
import com.ibm.den.entities.Team;

import java.util.ArrayList;
import java.util.Objects;

public class StudentDto {
    private Long id;
    private String name;
    private String password;
    private Team team;
    private boolean leader;
    private String email;
    private ArrayList<Task> tasks;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean isLeader() {
        return leader;
    }

    public void setLeader(boolean leader) {
        this.leader = leader;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public StudentDto(Long id, String name, String password, Team team, boolean leader, String email, ArrayList<Task> tasks) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.team = team;
        this.leader = leader;
        this.email = email;
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentDto that)) return false;
        return isLeader() == that.isLeader() && Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getTeam(), that.getTeam()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getTasks(), that.getTasks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPassword(), getTeam(), isLeader(), getEmail(), getTasks());
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", team=" + team +
                ", leader=" + leader +
                ", email='" + email + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
