import java.util.List;

public interface IFileOutputService {
    void writeGamesToFile(String filePath, List<Games> gamesList);
}
