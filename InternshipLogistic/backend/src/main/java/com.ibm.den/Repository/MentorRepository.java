package com.ibm.den.Repository;
import com.ibm.den.Classes.*;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
    public ArrayList<Mentor> findAll();

}
