package com.giventech.api;


import com.giventech.entity.Team;
import com.giventech.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SimpleController {

    @Autowired
    TeamService  teamService;

    @GetMapping("returnok")
    ResponseEntity<String> returnOkService() {
        return new ResponseEntity("It's ok", HttpStatus.OK);
    }

    @GetMapping("teams")
    public ResponseEntity<List<Team> > getTeams() {
        List <Team> teams  = teamService.findAllTeams();
        if (teams == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(teams);
        }
    }

    @PostMapping("team")
    public Team  getTeams(@RequestBody Team team) {
      return teamService.createTeam(team);
    }
}
