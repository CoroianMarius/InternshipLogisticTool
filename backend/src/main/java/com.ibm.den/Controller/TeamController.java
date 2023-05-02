package com.ibm.den.Controller;

import com.ibm.den.Classes.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.ibm.den.Services.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller("/team")
public class TeamControler {

    @Autowired
    private final TeamService teamService;
    

    @GetMapping("")
    public ArrayList<Team> getTeam() {
        return  TeamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable Long id) {
        return  TeamService.getTeam(id);
    }

    @PostMapping("")
    public Team addTeam(@RequestBody Team team) {
        return teamService.addTeam(team);
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Long id, @RequestBody Team team) {
        return  TeamService.updateTeam();
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        return  TeamService.deleteTeam();
    }

}
