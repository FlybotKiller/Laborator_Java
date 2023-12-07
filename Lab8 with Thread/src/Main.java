import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IFileOutputService oservice = new FileOutputService();
        List<Games> gamesList = new ArrayList<>();
        String csvFilePath = "src/games.csv";
        CsvReader csvReader = new CsvReader(csvFilePath, gamesList);
        //Thread csvThread = new Thread(csvReader);  //also add this if we implement Runnable instead
        csvReader.start();
        try {
            csvReader.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("");
        System.out.println("Csv reading is complete.");
        Collections.sort(gamesList);
        oservice.writeGamesToFile("src/gamesout.csv", gamesList);
    }
}