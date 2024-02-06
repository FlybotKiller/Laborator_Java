import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputService implements IFileInputService {
    @Override
    public List<DartsPlayers>[] GetPlayersFromFile(String filePath) {
        List<DartsPlayers> playersList = new ArrayList<>();
        List<DartsPlayers> high = new ArrayList<>();
        List<DartsPlayers> medium = new ArrayList<>();
        List<DartsPlayers> low = new ArrayList<>();
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            bufferedReader.readLine(); //citeste primul rand
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineParts = line.split(",");
                DartsPlayers player = new DartsPlayers(Integer.parseInt(lineParts[0].trim()), lineParts[1].trim(), lineParts[2].trim(),
                        lineParts[3].trim(), Integer.parseInt(lineParts[4].trim()), Integer.parseInt(lineParts[5].trim()), Integer.parseInt(lineParts[6].trim()));
                playersList.add(player);
            }
            playersList.stream()
                    .filter(player -> player.getScor_total() > 300)
                    .forEach(high :: add);
            playersList.stream()
                    .filter(player -> player.getScor_total() >= 250 && player.getScor_total() <= 300)
                    .forEach(medium :: add);
            playersList.stream()
                    .filter(player -> player.getScor_total() < 250)
                    .forEach(low :: add);
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        List<DartsPlayers>[] listArray = new List[] {playersList, low, medium, high};
        return listArray;
    }
}
