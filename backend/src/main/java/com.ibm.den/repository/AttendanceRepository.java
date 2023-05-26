package com.ibm.den.repository;

import com.ibm.den.entities.Attendance;
import com.ibm.den.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    ArrayList<Attendance> findByStudent(Student student);
}
