package com.ibm.den.repository;
import com.ibm.den.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    public Activity findByName(String name);
    public ArrayList<Activity> findAll();
}
