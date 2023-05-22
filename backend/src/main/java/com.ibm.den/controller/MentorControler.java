package com.ibm.den.controller;

import com.ibm.den.entities.Mentor;
import com.ibm.den.services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mentor")
public class MentorControler {

    @Autowired
    private MentorService mentorService;


    @GetMapping("")
    public List<Mentor> getAllMentors(){
        return mentorService.getAllMentors();
    }

    @GetMapping("/{mentor_id}")
    public Mentor getMentorById(@PathVariable Long mentor_id){
        return mentorService.findById(mentor_id);
    }

    @PostMapping("/newMentor")
    public Mentor createMentor(@RequestBody Mentor mentor){
        return mentorService.addMentor(mentor);
    }


    @PutMapping("/{mentor_id}")
    public Mentor updateMentor(@PathVariable Long mentor_id, @RequestBody Mentor mentor){
        return mentorService.updateMentor(mentor_id, mentor);
    }
    //delete mapping
    @DeleteMapping("/{mentor_id}")
    public void deleteMentor(@PathVariable Long mentor_id){
        mentorService.deleteMentor(mentor_id);
    }

}
