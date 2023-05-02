package com.ibm.den.Services;

import com.ibm.den.Classes.Student;
import com.ibm.den.Repository.StudentRepository;
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
        currentStudent.setRole(student.getRole());
        currentStudent.setTeam(student.getTeam());
        currentStudent.setTasks(student.getTasks());
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
