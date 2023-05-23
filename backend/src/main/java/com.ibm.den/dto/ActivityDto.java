package com.ibm.den.dto;

import com.ibm.den.entities.Student;
import com.ibm.den.entities.Task;

import java.util.ArrayList;
import java.util.Objects;

public class ActivityDto {
    private int id;
    private String name;
    private ArrayList<Task> tasks;
    private ArrayList<Student> students;


    public ActivityDto(int id, String name, ArrayList<Task> tasks, ArrayList<Student> students) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
        this.students = students;
    }

    public int getId() {
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

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActivityDto that)) return false;
        return getId() == that.getId() && Objects.equals(getName(), that.getName()) && Objects.equals(getTasks(), that.getTasks()) && Objects.equals(getStudents(), that.getStudents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getTasks(), getStudents());
    }

    @Override
    public String toString() {
        return "ActivityDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tasks=" + tasks +
                ", students=" + students +
                '}';
    }
}

