package com.laboratorjava.tema.Lab9;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class FileInputService implements IFileInputService{
    @Override
    public List<Games> getGamesFromFile(String filePath) {
        List<Games> gamesList = new ArrayList<>();
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
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
}
