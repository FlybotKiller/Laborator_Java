import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Games> _longPlaytimeGames = new ArrayList<>();
        List<Games> _shortPlaytimeGames = new ArrayList<>();
        List<Games> _undefinedPlaytimeGames = new ArrayList<>();
        Main main = new Main();
        VideoGames videoGames = new VideoGames();
        main.sortGamesFromFile("src/videoGames.csv", _longPlaytimeGames, _shortPlaytimeGames, _undefinedPlaytimeGames);
        System.out.println("Long playtime games:");
        for (var game : _longPlaytimeGames) {
            System.out.println(game);
        }
        System.out.println("");
        System.out.println("Short playtime games:");
        for (var game : _shortPlaytimeGames) {
            System.out.println(game);
        }
        System.out.println("");
        System.out.println("Undefined playtime games:");
        for (var game : _undefinedPlaytimeGames) {
            System.out.println(game);
        }
        System.out.println("");
        videoGames.showLongPlaytimeGames(_longPlaytimeGames);
        System.out.println("");
        System.out.println("");
        videoGames.sortShortGamesByPrice(_shortPlaytimeGames);
        System.out.println("");
        System.out.println("");
        videoGames.groupLongGamesByGenre(_longPlaytimeGames);

    }

    public void sortGamesFromFile(String filePath, List<Games> _longPlaytimeGames, List<Games> _shortPlaytimeGames, List<Games> _undefinedPlaytimeGames) {
        List<Games> gamesList = new ArrayList<>();
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                // System.out.println(line); //testing to see how much of the file is read before encountering possible errors
                String[] lineParts = line.split(",");
                int price;
                if (lineParts[6].trim().equalsIgnoreCase("Free")) {
                    price = 0;
                } else {
                    price = (int) Double.parseDouble(lineParts[6].trim());
                }
                Games game = new Games(Integer.parseInt(lineParts[0]), lineParts[1].trim(), lineParts[2].trim(),
                        lineParts[3].trim(), Integer.parseInt(lineParts[4].trim()), lineParts[5].trim(),
                        price, Double.valueOf(lineParts[7].trim()),
                        Integer.parseInt(lineParts[8].trim()));
                gamesList.add(game);
            }
            for (var game : gamesList) {
                if (game.getPlaytime() > 50 && game.getPlaytime() != 999) {
                    _longPlaytimeGames.add(game);
                }
                if (game.getPlaytime() <= 50) {
                    _shortPlaytimeGames.add(game);
                }
                if (game.getPlaytime() == 999) {
                    _undefinedPlaytimeGames.add(game);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}