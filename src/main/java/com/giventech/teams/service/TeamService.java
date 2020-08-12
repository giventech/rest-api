package com.giventech.teams.service;

import com.giventech.teams.entity.Team;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

import java.sql.SQLException;
import java.util.List;

public interface TeamService {

    // In case of SQL Exception it it will retry to call the services
    // backoff is the period by which the retry is attempted again
    @Retryable(
            value = { SQLException.class },
            maxAttempts = 2,
            backoff = @Backoff(delay = 5000))
    List<Team> findAllTeams();

    Team createTeam(Team team);


    Team findTeam(long id);
}


