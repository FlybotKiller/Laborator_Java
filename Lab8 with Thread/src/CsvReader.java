import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvReader extends Thread{
    String csvFilePath;
    List<Games> gamesList;

    public CsvReader(String csvFilePath, List<Games> gamesList) {
        this.csvFilePath = csvFilePath;
        this.gamesList = gamesList;
    }

    @Override
    public void run() {
        try {
            FileReader reader = new FileReader(csvFilePath);
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
    }
}

//Implements Runnable example:
/*
public class CsvReader implements Runnable {
    String csvFilePath;
    List<Games> gamesList;
    public CsvReader(String csvFilePath, List<Games> gamesList) {
        this.csvFilePath = csvFilePath;
        this.gamesList = gamesList;
    }

    @Override
    public void run() {
        try {
            FileReader reader = new FileReader(csvFilePath);
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
    }
}
 */
