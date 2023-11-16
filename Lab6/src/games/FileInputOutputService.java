package games;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileInputOutputService implements IFileInputOutputService {
    @Override
    public List<Games> getGamesFromFile(String filePath) {
        List<Games> gamesList = new ArrayList<>();
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] lineParts = line.split(",");
                Games game = new Games(Integer.parseInt(lineParts[0]), lineParts[1],
                        lineParts[2], Double.valueOf(lineParts[3]), lineParts[4],
                        lineParts[5], lineParts[6]);
                gamesList.add(game);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return gamesList;
    }

    @Override
    public void writeGamesToFile(String filePath, List<Games> gamesList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            int newID = 1;
            String line;
            for (var game : gamesList) {
                game.setId(newID++);
                line = game.id + "," + game.title + "," + game.release_date + "," +
                        game.rating + "," + game.mode + "," + game.story_time + "," + game.publisher;
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
