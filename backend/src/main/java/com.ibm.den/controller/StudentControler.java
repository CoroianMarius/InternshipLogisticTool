package com.ibm.den.controller;

import com.ibm.den.dto.StudentDto;
import com.ibm.den.entities.Student;
import com.ibm.den.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/student")
public class StudentControler {

    private final StudentService studentService;

    @Autowired
    public StudentControler(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public ArrayList<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/leaders")
    public ArrayList<StudentDto> getLeaders() {
        return studentService.getLeaders();
    }

    @PostMapping("{email}")
    public StudentDto createStudent(@RequestBody StudentDto student,@PathVariable String email) {
        return studentService.createStudent(student,email);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{email}")
    public void deleteStudent(@PathVariable String email) {
        studentService.deleteStudent(email);
    }





}
