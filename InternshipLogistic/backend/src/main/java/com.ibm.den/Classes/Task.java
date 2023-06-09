package com.ibm.den.Classes;

import jakarta.persistence.*;

@Entity
@Table()
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @Column
    private String description;

    public Task() {
    }

    public Task(Student student, String description) {
        this.student = student;
        this.description = description;
    }

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + id +
                ", student=" + student +
                ", description='" + description + '\'' +
                '}';
    }
}
