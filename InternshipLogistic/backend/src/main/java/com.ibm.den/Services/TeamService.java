package com.ibm.den.Services;

import com.ibm.den.Classes.Team;
import com.ibm.den.Controller.TeamController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm.den.Repository.TeamRepository;
import java.util.ArrayList;

@Service
public class TeamService {

    @Autowired
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public ArrayList<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long id)
    {
        return teamRepository.findById(id).orElse(null);
    }

    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(Long id, Team team) {
        Team currentTeam = teamRepository.findById(id).orElse(null);
        currentTeam.setLeader(team.getLeader());
        currentTeam.setStudents(team.getStudents());
        teamRepository.save(currentTeam);
        return currentTeam;
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }


}
