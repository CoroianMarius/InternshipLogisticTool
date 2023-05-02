package com.ibm.den.Repository;
import com.ibm.den.Classes.*;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public ArrayList<Student> findAll();
}
