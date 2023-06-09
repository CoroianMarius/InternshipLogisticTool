package com.ibm.den.services;

import com.ibm.den.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm.den.repository.TeamRepository;
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
        teamRepository.save(currentTeam);
        return currentTeam;
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }


}
