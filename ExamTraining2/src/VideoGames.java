import java.util.*;

public class VideoGames {

    Map<String, List<Games>> gameMap = new HashMap<>();

    public void showLongPlaytimeGames(List<Games> _longPlaytimeGames) {
        System.out.println("Long playtime games which came out after 2010 with a rating of 4.5 or higher:");
        for (var game : _longPlaytimeGames) {
            if (game.getRating() >= 4.5 && game.getRelease_year() > 2010) {
                System.out.println("Games{" +
                        "title='" + game.getTitle() + '\'' +
                        ", genre='" + game.getGenre() + '\'' +
                        ", price=" + game.getPrice() +
                        '}');
            }
        }
    }

    public void sortShortGamesByPrice(List<Games> _shortPlaytimeGames) {
        System.out.println("Short playtime games sorted by price:");
        Collections.sort(_shortPlaytimeGames);
        for (var game : _shortPlaytimeGames) {
            if (game.getRating() < 4.0) {
                System.out.println("Games{" +
                        "ID=" + game.getID() +
                        ", title='" + game.getTitle() + '\'' +
                        ", developer='" + game.getDeveloper() + '\'' +
                        ", genre='" + game.getGenre() + '\'' +
                        ", release_year=" + game.getRelease_year() +
                        ", platforms='" + game.getPlatforms() + '\'' +
                        ", price=" + game.getPrice() +
                        ", rating=" + game.getRating() +
                        ", playtime=" + game.getPlaytime() +
                        '}');
            }
        }
    }

    public void groupLongGamesByGenre(List<Games> _longPlaytimeGames) {
        gameMap.clear();
        String genre;
        for (var game : _longPlaytimeGames) {
            genre = game.getGenre();
            if (!gameMap.containsKey(genre)) {
                gameMap.put(genre, new ArrayList<>());
            }
            gameMap.get(genre).add(game);
        }

        Iterator<Map.Entry<String, List<Games>>> iterator = gameMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Games>> entry = iterator.next();
            if (entry.getKey().equalsIgnoreCase("Action")) {
                iterator.remove();
                break;
            }
        }

        for (Map.Entry<String, List<Games>> entry : gameMap.entrySet()) {
            System.out.println("GENRE " + entry.getKey() + ":");
            for (var game : entry.getValue()) {
                System.out.println("- " + game);
            }
        }
    }
}
