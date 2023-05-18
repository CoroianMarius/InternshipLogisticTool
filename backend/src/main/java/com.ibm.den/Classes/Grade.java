package com.ibm.den.Classes;

import jakarta.persistence.*;

@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "grade_id")
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private Mentor mentor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private Task task;
    @Column
    private int value;

    @Column
    private String comment;


    public Grade() {}

    public Grade(long id, Mentor mentor, Student student, Task task, int value, String comment) {
        this.id = id;
        this.mentor = mentor;
        this.student = student;
        this.task = task;
        this.value = value;
        this.comment = comment;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
