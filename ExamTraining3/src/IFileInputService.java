import java.util.List;
public interface IFileInputService {
    List<DartsPlayers>[] GetPlayersFromFile(String filePath);
}