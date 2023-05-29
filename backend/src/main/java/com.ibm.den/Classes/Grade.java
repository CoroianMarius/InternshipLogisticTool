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
        this.id = new GradeId(mentor.getId(),student.getId(),task.getid());
        this.mentor = mentor;
        this.student = student;
        this.task = task;
        this.value = value;
        this.comment = comment;
    }
}
