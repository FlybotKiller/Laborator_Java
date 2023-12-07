import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputService implements IFileInputService {

    @Override
    public List<Cuisines> getCuisinesFromFile(String filePath) {
        List<Cuisines> cuisinesList = new ArrayList<>();
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] lineParts = line.split(",");
                Cuisines cuisine = new Cuisines(lineParts[0].trim(), lineParts[1].trim(),
                        lineParts[2].trim(), Integer.parseInt(lineParts[3].trim()),
                        Integer.parseInt(lineParts[4].trim()), lineParts[5].trim(),
                        Integer.parseInt(lineParts[6].trim()), Integer.parseInt(lineParts[7].trim()),
                        lineParts[8].trim());
                cuisinesList.add(cuisine);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return cuisinesList;
    }
}
