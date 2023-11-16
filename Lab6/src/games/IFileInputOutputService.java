package games;
import java.util.List;
public interface IFileInputOutputService {
    List<Games> getGamesFromFile(String filePath);
    void writeGamesToFile(String filePath, List<Games> usersList);

}
