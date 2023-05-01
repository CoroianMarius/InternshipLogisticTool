package com.ibm.den.Classes;

import jakarta.persistence.*;

@Entity
@Table()
public class Mentor {
    @Override
    public String toString() {
        return "Mentor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    public Mentor() {
    }

    public Mentor(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getStudentId() {
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
}

