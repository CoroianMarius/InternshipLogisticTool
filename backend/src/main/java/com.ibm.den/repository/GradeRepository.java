package com.ibm.den.Repository;

import com.ibm.den.Classes.*;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GradeRepository extends JpaRepository<Grade, GradeId> {
    public ArrayList<Grade> findAllByValueOrderByValueDesc();
    public Grade findByIdMentorAndIdStudentAndIdTask(Long mentorId, Long studentId, Long taskId);


    public ArrayList<Grade> findAll();
}
