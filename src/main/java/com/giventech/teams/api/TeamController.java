package com.giventech.teams.api;


import com.giventech.teams.entity.Team;
import com.giventech.teams.service.TeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static  org.springframework.http.MediaType.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    TeamService  teamService;

    @GetMapping("returnok")
    ResponseEntity<String> returnOkService() {
        return new ResponseEntity("It's ok", HttpStatus.OK);
    }

    @GetMapping("/team")
    public ResponseEntity<List<Team> > getTeams() {
        List <Team> teams  = teamService.findAllTeams();
        if (teams == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(teams);
        }
    }
    @Operation(summary = "Get All teams", description = "Get All teams ", tags = {"All teams"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Team.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiError.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiError.class))}),
            @ApiResponse(responseCode = "404", description = "Not found", content = {@Content(mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "422", description = "Unprocessable entity", content = {@Content(mediaType = APPLICATION_JSON_VALUE)}),
    })
    @PostMapping("/team")
    public Team  getTeams(@RequestBody Team team) {
      return teamService.createTeam(team);
    }


    /**
     * Swagger annotation describes the
     * @param id
     * @return
     */
    @Operation(summary = "Get team", description = "Find a team ", tags = {"Find team "})
     @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Team.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiError.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiError.class))}),
            @ApiResponse(responseCode = "404", description = "Not found", content = {@Content(mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "422", description = "Unprocessable entity", content = {@Content(mediaType = APPLICATION_JSON_VALUE)}),
    })

    @GetMapping("/team/{id}")
    @ResponseBody
    public Team  getTeams(@PathVariable Long id) {
        return teamService.findTeam(id);
    }
}


