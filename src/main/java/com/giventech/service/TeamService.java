package com.giventech.service;

import com.giventech.entity.Team;

import java.util.List;

public interface TeamService {
    public List<Team> findAllTeams();
    public Team createTeam(Team team);

}


