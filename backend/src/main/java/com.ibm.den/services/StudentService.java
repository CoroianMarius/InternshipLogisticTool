package com.ibm.den.services;

import com.ibm.den.dto.StudentDto;
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
    public void deleteStudent(String email) {
        Student s = studentRepository.findByEmail(email);
        studentRepository.delete(s);
    }

    public Student updateStudent(Long id, Student student) {
        Student currentStudent = studentRepository.findById(id).orElse(null);
        currentStudent.setName(student.getName());
        currentStudent.setEmail(student.getEmail());
        currentStudent.setLeader(student.getLeader());
        currentStudent.setTeam(student.getTeam());
        return studentRepository.save(currentStudent);
    }

    public StudentDto createStudent(StudentDto student,String email,String password) {
        Student leader = studentRepository.findByEmail(email);
        Student currentStudent = new Student();
        currentStudent.setName(student.getName());
        currentStudent.setEmail(student.getEmail());
        currentStudent.setLeader(student.getLeader());
        currentStudent.setTeam(leader.getTeam());
        currentStudent.setPassword(password);
        studentRepository.save(currentStudent);
        return new StudentDto(currentStudent);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public ArrayList<Student> getAllStudents() {
        return (ArrayList<Student>) studentRepository.findAll();
    }

    public ArrayList<StudentDto> getLeaders() {
        ArrayList<Student> students = studentRepository.findByLeader(true);
        ArrayList<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            studentDtos.add(new StudentDto(student));
        }
        return studentDtos;
    }
}
