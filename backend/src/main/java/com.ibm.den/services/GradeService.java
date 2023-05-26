package com.ibm.den.services;

import com.ibm.den.dto.GradeDto;
import com.ibm.den.entities.Grade;
import com.ibm.den.entities.Student;
import com.ibm.den.repository.*;
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

    public ArrayList<GradeDto> getGrades(String email) {
        Student student = studentRepository.findByEmail(email);
        ArrayList<Grade> grades = gradeRepository.findByStudent(student);
        ArrayList<GradeDto> gradeDtos = new ArrayList<>();
        for (Grade grade : grades) {
            gradeDtos.add(new GradeDto(grade));
        }
        return gradeDtos;
    }

    public ArrayList<ArrayList<GradeDto>> getGradesList(String email) {
        Student student = studentRepository.findByEmail(email);
        ArrayList<Student> students = studentRepository.findByTeam(student.getTeam());
        ArrayList<ArrayList<GradeDto>> gradeDtos = new ArrayList<>();
        for (Student student1 : students) {
            gradeDtos.add(getGrades(student1.getEmail()));
        }
        return gradeDtos;
    }
}
