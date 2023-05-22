package com.ibm.den.Classes;

import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "activity_id")
    private int id;

    @Column
    private String name;

    @Column
    @OneToMany()
    @JoinColumn(name = "task_id")
    private ArrayList<Task> tasks;

    @Column
    @OneToMany()
    @JoinColumn(name = "student_id")
    private ArrayList<Student> students;


}
