package com.giventech.teams.repository;

import com.giventech.teams.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
        @Override
        List<Team> findAll();

        @Override
        Optional<Team> findById(Long aLong);




}
