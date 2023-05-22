package com.ibm.den.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private Student leader;

    @OneToMany(mappedBy = "team")
    private List<Student> students;

    public Team() {
    }

    public Team(Student leader, List<Student> students) {
        this.leader = leader;
        this.students = students;
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", leader=" + leader +
                ", students=" + students +
                '}';
    }
}
