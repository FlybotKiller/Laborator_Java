import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IFileInputService  iservice = new FileInputService();
        DartsPlayersManager playermanager = new DartsPlayersManager();
        List<DartsPlayers>[] lists =  iservice.GetPlayersFromFile("src/4LF621.csv");
        List<DartsPlayers> playersFromFile = lists[0];
        List<DartsPlayers> _lowScorersList = lists[1];
        List<DartsPlayers> _mediumScorersList = lists[2];
        List<DartsPlayers> _highScorersList = lists[3];
        for(var player : playersFromFile) {
            System.out.println(player);
        }
        System.out.println("");
        System.out.println("High scorers:");
        for(var player : _highScorersList) {
            System.out.println(player);
        }
        System.out.println("");
        System.out.println("Medium Scorers:");
        for(var player : _mediumScorersList) {
            System.out.println(player);
        }
        System.out.println("");
        System.out.println("Low Scorers:");
        for(var player : _lowScorersList) {
            System.out.println(player);
        }
        System.out.println("");
        System.out.println("Sorted High scorers:");
        playermanager.sortHighScorers(_highScorersList);
        System.out.println("");
        System.out.println("Sorted Medium scorers:");
        Collections.sort(_mediumScorersList);
        for(var players : _mediumScorersList){
            System.out.println(players);
        }
        System.out.println("");
        System.out.println("Grouped High scorers by Category:");
        playermanager.groupPlayersByCategory(_highScorersList);
    }
}