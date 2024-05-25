package com.example.homework2.controller;


import com.example.homework2.model.Player;
import com.example.homework2.model.Team;
import com.example.homework2.repository.PlayerRepository;
import com.example.homework2.repository.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;


@Controller
public class IndexController {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public IndexController(PlayerRepository playerRepository, TeamRepository teamRepository){
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    //Home
    @RequestMapping("/")
    public String index() {
        return "index"; //view name
    }

    //Show Players
    @RequestMapping("/players")
    public String players(Model model) {
        model.addAttribute("playerList", playerRepository.findAll());
        return "players";
    }

    //Show Teams
    @RequestMapping("/teams")
    public String teams(Model model) {
        model.addAttribute("teamList", teamRepository.findAll());
        return "teams";
    }

    //Add Player in Players Tab
    @GetMapping(value = "/addplayer")
    public String addPlayer(Model model) {
        int currentYear = LocalDate.now().getYear();
        model.addAttribute("currentYear", currentYear);
        return "addplayer";
    }

    //Add Player
    @PostMapping("/addplayer")
    public String result(String name, int birthYear, char gender) {
        Player newPlayer = new Player(name, gender, birthYear);
        playerRepository.save(newPlayer);
        return "redirect:players";
    }

    //View Team Roster
    @RequestMapping ("/viewRoster/{id}")
    public String viewRoster(Model model, @PathVariable Integer id) {
        model.addAttribute("playerList", teamRepository.findById(id).orElse(null).getPlayers());
        model.addAttribute("teamId", id);

        return "viewRoster";
    }

    //add Team
    @GetMapping("/addteam")
    public String addPlayer() {
        return "/addteam";
    }

    //adding a new team postmapping
    @PostMapping("/addteam")
    public String addPlayer(String color, char gender, Integer minAge, Integer maxAge) {
        Team newTeam = new Team(color, gender, minAge, maxAge);
        teamRepository.save(newTeam);

        return "redirect:teams";
    }

    //edit Player
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id) {
        model.addAttribute("player", playerRepository.findById(id).orElse(null));
        int currentYear = LocalDate.now().getYear();
        model.addAttribute("currentYear", currentYear);
        model.addAttribute("teams", teamRepository.findAll());
        return "edit";
    }

    //edit player postmapping
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, String name, int birthYear, char gender, Integer team) {
        Player currentPlayer = playerRepository.findById(id).orElse(null);

        Team currentTeam = currentPlayer.getTeam();
        Team changedTeam = null;

        if (team != null) {
            changedTeam = teamRepository.findById(team).orElse(null);
        }


        currentPlayer.setName(name);
        currentPlayer.setBirthYear(birthYear);
        currentPlayer.setGender(gender);

        if (currentTeam != null && changedTeam != null && currentTeam != changedTeam) {
            currentTeam.removePlayer(currentPlayer);
            currentPlayer.setTeam(changedTeam);
            teamRepository.save(currentTeam);
            teamRepository.save(changedTeam);
        }
        else if (currentTeam == null && changedTeam != null) {
            currentPlayer.setTeam(changedTeam);
            teamRepository.save(changedTeam);
        }
        else if (currentTeam != null && changedTeam == null) {
            currentTeam.removePlayer(currentPlayer);
            teamRepository.save(currentTeam);
            currentPlayer.setTeam(null);
        }

        playerRepository.save(currentPlayer);

        return ("redirect:../players");
    }
}


