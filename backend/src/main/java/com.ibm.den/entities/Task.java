package com.ibm.den.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "task")
public class Task extends BaseEntity{

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
