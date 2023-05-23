package com.ibm.den.dto;

import com.ibm.den.entities.Mentor;
import com.ibm.den.entities.Student;
import com.ibm.den.entities.Task;

import java.util.Objects;

public class GradeDto
{
    private long id;
    private Mentor mentor;
    private Student student;
    private Task task;
    private int value;
    private String comment;

    public GradeDto(long id, Mentor mentor, Student student, Task task, int value, String comment) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GradeDto gradeDto)) return false;
        return getId() == gradeDto.getId() && getValue() == gradeDto.getValue() && Objects.equals(getMentor(), gradeDto.getMentor()) && Objects.equals(getStudent(), gradeDto.getStudent()) && Objects.equals(getTask(), gradeDto.getTask()) && Objects.equals(getComment(), gradeDto.getComment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMentor(), getStudent(), getTask(), getValue(), getComment());
    }

    @Override
    public String toString() {
        return "GradeDto{" +
                "id=" + id +
                ", mentor=" + mentor +
                ", student=" + student +
                ", task=" + task +
                ", value=" + value +
                ", comment='" + comment + '\'' +
                '}';
    }
}
