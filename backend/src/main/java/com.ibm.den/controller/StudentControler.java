package com.ibm.den.Controller;

import com.ibm.den.Classes.Student;
import com.ibm.den.Services.StudentService;
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

    @GetMapping("/id")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }





}
