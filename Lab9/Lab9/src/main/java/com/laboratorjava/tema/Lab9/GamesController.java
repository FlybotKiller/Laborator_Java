package com.laboratorjava.tema.Lab9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GamesController {

    private List<Games> gamesList;

    public GamesController() {
        gamesList = readCSV();
    }

    private List<Games> readCSV() {
        int newID = 1;
        IFileInputService iservice = new FileInputService();
        List<Games> gamesFromFile = iservice.getGamesFromFile("C:\\Users\\denis\\OneDrive\\Desktop\\Lab9\\Lab9\\src\\main\\java\\com\\laboratorjava\\tema\\Lab9\\games.csv");
        Collections.sort(gamesFromFile);
        for (var game : gamesFromFile) {
            game.setId(newID++);
        }
        return gamesFromFile;
    }


    //GET endpoint to retrieve all games
    @GetMapping
    public List<Games> getAllGames() {
        return gamesList;
    }

    //GET endpoint to retrieve a specific game by id
    @GetMapping("/{id}")
    public Games getGameById(@PathVariable("id") Integer id) {
        return gamesList.stream()
                .filter(games -> games.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    //POST endpoint to add a new game
    @PostMapping
    public Games addGame(@RequestBody Games game) {
        gamesList.add(game);
        return game;
    }

    //PUT endpoint to update an existing game's name
    @PutMapping("/{id}")
    public Games updateGame(@PathVariable("id") Integer id, @RequestBody Games updatedGame) {
        for (var game : gamesList) {
            if (game.getId().equals(id)) {
                game.setTitle(updatedGame.getTitle());
                return game;
            }
        }
        return null; //user not found
    }

    //DELETE endpoint
    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable("id") Integer id) {
        gamesList.removeIf(games -> games.getId().equals(id));
    }

}