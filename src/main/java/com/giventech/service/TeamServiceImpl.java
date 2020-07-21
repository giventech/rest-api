package com.giventech.service;

import com.giventech.entity.Team;
import com.giventech.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> findAllTeams() {
        return teamRepository.findAll();
    }

    @Transactional
            (rollbackFor = Exception.class,
                    noRollbackFor = EntityNotFoundException.class)
    public Team createTeam(Team team ) {
        return  teamRepository.save(team);
    }

    public Team findTeam(long id) throws EntityNotFoundException {
        Team team = teamRepository.findById(id).orElse(null);
        if (team == null) throw new EntityNotFoundException("This is an error"+id);
        return team;
    }
}