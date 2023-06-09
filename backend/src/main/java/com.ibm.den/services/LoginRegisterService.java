package com.ibm.den.services;

import com.ibm.den.entities.Activity;
import com.ibm.den.entities.Mentor;
import com.ibm.den.entities.Student;
import com.ibm.den.entities.Team;
import com.ibm.den.entities.connection.LoginRequest;
import com.ibm.den.entities.connection.LoginResponse;
import com.ibm.den.entities.connection.RegisterTeam;
import com.ibm.den.repository.ActivityRepository;
import com.ibm.den.repository.MentorRepository;
import com.ibm.den.repository.StudentRepository;
import com.ibm.den.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class LoginRegisterService {

    @Autowired
    private final TeamRepository teamRepository;
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final ActivityRepository activityRepository;
    @Autowired
    private final MentorRepository mentorRepository;

    public LoginRegisterService(TeamRepository teamRepository, StudentRepository studentRepository, ActivityRepository activityRepository, MentorRepository mentorRepository){
        this.teamRepository = teamRepository;
        this.studentRepository = studentRepository;
        this.activityRepository = activityRepository;
        this.mentorRepository = mentorRepository;
    }
    public ArrayList<Activity> activities(){
        System.out.println("hola");
        return activityRepository.findAll();

    }

    public LoginResponse login(LoginRequest a)
    {
        Mentor m = mentorRepository.findByNameAndPassword(a.getEmail(), a.getPassword());
        Student s = studentRepository.findByEmailAndPassword(a.getEmail(), a.getPassword());
        if(m!=null)
            return LoginResponse.MENTOR;
        else if(s!=null)
            if (s.getLeader())
                return LoginResponse.LEADER;
            else
                return LoginResponse.STUDENT;
        else
            return LoginResponse.NOT_FOUND;
    }

    public void register(RegisterTeam a)
    {
        Student s = new Student();
        s.setName(a.getLeader());
        s.setEmail(a.getEmail());
        s.setLeader(true);
        Team t = new Team();
        t.setActivity(activityRepository.findByName(a.getActivity()));
        t.setConfirmed(false);
        s.setTeam(t);
        teamRepository.save(t);
        studentRepository.save(s);
    }
}
