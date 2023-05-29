package com.ibm.den.controller;

import com.ibm.den.dto.StudentDto;
import com.ibm.den.entities.Student;
import com.ibm.den.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/student")




public class  StudentControler {

    private final StudentService studentService;

    @Autowired
    public StudentControler(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/leaders")
    //returns all the leaders
    public ArrayList<StudentDto> getLeaders() {
        return studentService.getLeaders();
    }

    @PostMapping("{emailLeader}")
    //creates new student, you pass the email of his team leader
    public StudentDto createStudent(@RequestBody StudentDto student,@PathVariable String emailLeader) {
        return studentService.createStudent(student,emailLeader);
    }

    @DeleteMapping("/{emailStudent}")
    //you got this bro
    public void deleteStudent(@PathVariable String emailStudent) {
        studentService.deleteStudent(emailStudent);
    }





}
