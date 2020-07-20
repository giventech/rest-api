package com.giventech.service;

import com.giventech.entity.Team;

import java.util.List;

public interface TeamService {
    List<Team> findAllTeams();
    Team createTeam(Team team);
}


