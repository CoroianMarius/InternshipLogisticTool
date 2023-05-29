package com.ibm.den.controller;

import com.ibm.den.dto.TeamDto;
import com.ibm.den.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import com.ibm.den.services.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/{email}")
    public TeamDto getTeam(@PathVariable String email)
    {
        return teamService.getTeam(email);
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
