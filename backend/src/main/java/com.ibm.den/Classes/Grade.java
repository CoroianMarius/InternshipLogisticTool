package com.ibm.den.Classes;

import jakarta.persistence.*;

@Entity
@Table()
public class Grade {
    @EmbeddedId
    private GradeId id;

    @OneToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;
    @Column
    private int value;

    @Column
    private String comment;


    public Grade() {}

    public Grade(Mentor mentor,Student student,Task task, int value, String comment) {
        this.id.setMentor_id(mentor.getId());
        this.id.setStudent_id(student.getId());
        this.id.setTask_id(task.getId());
        this.mentor = mentor;
        this.student = student;
        this.task = task;
        this.value = value;
        this.comment = comment;
    }

    public GradeId getId() {
        return id;
    }

    public void setId(GradeId id) {
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
