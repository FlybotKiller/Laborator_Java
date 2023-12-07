import java.util.List;
import java.io.*;

public class FileOutputService implements IFileOutputService {
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
