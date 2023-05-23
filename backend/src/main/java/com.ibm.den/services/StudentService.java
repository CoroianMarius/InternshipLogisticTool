package com.ibm.den.services;

import com.ibm.den.entities.Student;
import com.ibm.den.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student student) {
        Student currentStudent = studentRepository.findById(id).orElse(null);
        currentStudent.setName(student.getName());
        currentStudent.setEmail(student.getEmail());
        currentStudent.setLeader(student.getLeader());
        currentStudent.setTeam(student.getTeam());
        return studentRepository.save(currentStudent);
    }

    public Student createStudent(Student student) {
        Student currentStudent = studentRepository.save(student);
        return currentStudent;
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public ArrayList<Student> getAllStudents() {
        return (ArrayList<Student>) studentRepository.findAll();
    }
}
