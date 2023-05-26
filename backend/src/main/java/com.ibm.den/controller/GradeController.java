package com.ibm.den.controller;

import com.ibm.den.dto.GradeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ibm.den.entities.Grade;
import com.ibm.den.services.GradeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    // GET /api/grade
    @GetMapping("")
    public List<Grade> getAllGrades(){
        return gradeService.getAllGrades();
    }

    // GET /api/grade/{mentor_id}/{student_id}/{task_id}
    @GetMapping("/{email}")
    public ArrayList<GradeDto> getGrades(@PathVariable String email) {
        return gradeService.getGrades(email);
    }

    @GetMapping("/list{email}")
    public ArrayList<ArrayList<GradeDto>> getGradesList(@PathVariable String email) {
        return gradeService.getGradesList(email);
    }


    // POST /api/grade
    @PostMapping("")
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.createGrade(grade);
    }

    // PUT /api/grade/{mentor_id}/{student_id}/{task_id}
    @PutMapping("/{mentor_id}/{student_id}/{task_id}")
    public Grade updateGrade(@PathVariable Long mentor_id, @PathVariable Long student_id, @PathVariable Long task_id, @RequestBody Grade grade) {
        return gradeService.updateGrade(mentor_id, student_id, task_id, grade);
    }

    // DELETE /api/grade/{mentor_id}/{student_id}/{task_id}
    @DeleteMapping("/{grade_id}")
    public void deleteGrade(@PathVariable Long grade_id) {
        gradeService.deleteGrade(grade_id);
    }
}
