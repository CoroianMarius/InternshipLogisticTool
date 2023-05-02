package com.ibm.den.Controller;

import com.ibm.den.Classes.Team;
import org.springframework.beans.factory.annotation.Autowired;
import com.ibm.den.Services.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    TeamService teamService;


    @GetMapping("")
    public ArrayList<Team> getTeams()
    {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable Long id)
    {
        return teamService.getTeamById(id);
    }

    @PostMapping("")
    public Team addTeam(@RequestBody Team team) {
        return teamService.addTeam(team);
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Long id, @RequestBody Team team) {
        return teamService.updateTeam(id, team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id)
    {
        teamService.deleteTeam(id);
    }

}
