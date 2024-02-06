import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DartsPlayersManager {
    Map<String, List<DartsPlayers>> playersMap = new HashMap<>();

    void sortHighScorers(List<DartsPlayers> high) {
        for (var player : high) {
            if (player.getRatare() < 3 && player.getPremii_castigate() > 450) {
                System.out.println(player);
            }
        }
    }

    void groupPlayersByCategory(List<DartsPlayers> high) {
        playersMap.clear();
        String category;
        for (var player : high) {
            category = player.getCategorie();
            if (!playersMap.containsKey(category)) {
                playersMap.put(category, new ArrayList<>());
            }
            playersMap.get(category).add(player);
        }

        for (Map.Entry<String, List<DartsPlayers>> entry : playersMap.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (var player : entry.getValue()) {
                System.out.println("- " + player);
            }
        }
    }
}
