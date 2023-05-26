package com.ibm.den.dto;

import com.ibm.den.entities.Student;
import com.ibm.den.entities.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TeamDto {
    private String activityName;
    private List<StudentDto> students;

    public TeamDto() {
    }

    public TeamDto(String activityName, List<StudentDto> students) {
        this.activityName = activityName;
        this.students = students;
    }

    public TeamDto(Team team, ArrayList<Student> students) {
        this.activityName = team.getActivity().getName();
        for (Student student : students) {
            this.students.add(new StudentDto(student));
        }
    }
}
