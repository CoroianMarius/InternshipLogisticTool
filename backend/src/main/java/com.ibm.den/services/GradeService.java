package com.ibm.den.Services;

import com.ibm.den.Classes.Grade;
import com.ibm.den.Classes.GradeId;
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


    public ArrayList<Grade> getAllGrades(Boolean sorted)
    {
        ArrayList<Grade> grades = new ArrayList<Grade>();
        if(sorted)
            grades=gradeRepository.findAllByValueOrderByValueDesc();
        else
            grades=gradeRepository.findAll();
        return grades;
    }

    public Grade findByIdMentorAndIdStudentAndIdTask(Long mentorId, Long studentId, Long taskId)
    {
        return gradeRepository.findByIdMentorAndIdStudentAndIdTask(mentorId, studentId, taskId);
    }
}
