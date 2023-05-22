package com.ibm.den.Services;

import com.ibm.den.Classes.Grade;
import com.ibm.den.Repository.*;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class GradeService {

    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    private final MentorRepository mentorRepository;

    public GradeService(GradeRepository gradeRepository, StudentRepository studentRepository, MentorRepository mentorRepository)
    {
        this.gradeRepository=gradeRepository;
        this.studentRepository=studentRepository;
        this.mentorRepository=mentorRepository;
    }


    public ArrayList<Grade> getAllGrades()
    {
        return gradeRepository.findAll();
    }

    public Grade findByIdMentorAndIdStudentAndIdTask(Long mentorId, Long studentId, Long taskId)
    {
        return gradeRepository.findAllByMentor_idAndStudent_idAndTask_Id(mentorId, studentId, taskId);
    }

    public Grade createGrade(Grade grade) {
        Grade currentGrade = gradeRepository.save(grade);
        return currentGrade;
    }

    public Grade updateGrade(Long mentorId, Long studentId, Long taskId, Grade grade) {
        Grade currentGrade = gradeRepository.findAllByMentor_idAndStudent_idAndTask_Id(mentorId, studentId, taskId);
        currentGrade.setComment(grade.getComment());
        currentGrade.setTask(grade.getTask());
        currentGrade.setMentor(grade.getMentor());
        currentGrade.setValue(grade.getValue());
        currentGrade.setStudent(grade.getStudent());
        return gradeRepository.save(currentGrade);
    }

    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}
