package com.ibm.den.Classes;
import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private UUID id;
    private String name;
    private Team team;
    private String rol;
    private ArrayList<Task> tasks;

    public Student() {}


    public Student(String name, Team team, String rol, ArrayList<Task> tasks) {
        this.name = name;
        this.team = team;
        this.rol = rol;
        this.tasks = tasks;
    }

    public UUID getId() {
        return id;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team=" + team +
                ", rol='" + rol + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}