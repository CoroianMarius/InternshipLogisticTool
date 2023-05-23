package com.ibm.den.dto;

import com.ibm.den.entities.Student;

import java.util.Objects;

public class TaskDto {
    private Long id;
    private Student student;
    private boolean attendance;
    private String description;

    public TaskDto(Long id, Student student, boolean attendance, String description) {
        this.id = id;
        this.student = student;
        this.attendance = attendance;
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

    public boolean isAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskDto taskDto)) return false;
        return isAttendance() == taskDto.isAttendance() && Objects.equals(getId(), taskDto.getId()) && Objects.equals(getStudent(), taskDto.getStudent()) && Objects.equals(getDescription(), taskDto.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStudent(), isAttendance(), getDescription());
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "id=" + id +
                ", student=" + student +
                ", attendance=" + attendance +
                ", description='" + description + '\'' +
                '}';
    }
}
