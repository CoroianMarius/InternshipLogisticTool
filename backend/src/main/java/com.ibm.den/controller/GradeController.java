package com.ibm.den.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ibm.den.Classes.Grade;
import com.ibm.den.Services.GradeService;

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
    @GetMapping("/{mentor_id}/{student_id}/{task_id}")
    public Grade getGradeById(@PathVariable Long mentor_id, @PathVariable Long student_id, @PathVariable Long task_id) {
        return gradeService.findByIdMentorAndIdStudentAndIdTask(mentor_id, student_id, task_id);
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
