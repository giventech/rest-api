package com.giventech.teams.service;

import com.giventech.teams.entity.Team;

import java.util.List;

public interface TeamService {
    List<Team> findAllTeams();

    Team createTeam(Team team);

    Team findTeam(long id);
}


