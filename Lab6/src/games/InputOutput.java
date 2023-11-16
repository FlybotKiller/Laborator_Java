package games;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InputOutput {
    public static void main(String[] args) throws IOException {
        IFileInputOutputService ioService = new FileInputOutputService();
        List<Games> gamesFromFile = ioService.getGamesFromFile("src/games/games.csv");
        for (var game : gamesFromFile) {
            System.out.println(game);
        }

        Collections.sort(gamesFromFile);
        ioService.writeGamesToFile("src/games/gamesout.csv", gamesFromFile);
    }
}
