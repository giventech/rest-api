package com.giventech.test;


import com.giventech.teams.entity.Team;
import com.giventech.teams.repository.TeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TeamRepositoryIntTest {

    @Autowired
    private TestEntityManager entityManager;

    @Qualifier("teamRepository")
    @Autowired
    private TeamRepository teamRepository;


    // write test cases here
    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given

        // when
        List<Team> teams = teamRepository.findAll();

        // then
        assert (teams.size() > 1);
    }
}
