package com.ibm.den.Classes;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table()
public class Team {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private Student leader;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = false)
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
