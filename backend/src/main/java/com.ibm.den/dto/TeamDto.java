package com.ibm.den.dto;

import com.ibm.den.entities.Student;

import java.util.List;
import java.util.Objects;

public class TeamDto {
    private Long id;
    private Student leader;
    private List<Student> students;

    @Override
    public String toString() {
        return "TeamDto{" +
                "id=" + id +
                ", leader=" + leader +
                ", students=" + students +
                '}';
    }

    public TeamDto(Long id, Student leader, List<Student> students) {
        this.id = id;
        this.leader = leader;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamDto teamDto)) return false;
        return Objects.equals(getId(), teamDto.getId()) && Objects.equals(getLeader(), teamDto.getLeader()) && Objects.equals(getStudents(), teamDto.getStudents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLeader(), getStudents());
    }
}
