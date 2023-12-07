import java.util.*;
import java.util.stream.Collectors;

public class Main {
    Map<String, List<Cuisines>> countryMap = new HashMap<>();
    String[] asian_countries = {"India", "Thailand", "South Korea"};

    public static void main(String[] args) {
        IFileInputService iservice = new FileInputService();
        List<Cuisines> cuisinesFromFile = iservice.getCuisinesFromFile("src/cuisines.csv");
        for (var cuisine : cuisinesFromFile) {
            System.out.println(cuisine);
        }
        System.out.println("");
        List<Cuisines> _spicyDishesList = new ArrayList<>();
        List<Cuisines> _notSpicyDishesList = new ArrayList<>();
        WorldCuisines worldCuisines = new WorldCuisines();
        worldCuisines.sortBySpiceLevel(cuisinesFromFile, _spicyDishesList, _notSpicyDishesList);
        System.out.println("");
        worldCuisines.quickSpicyDishes(_spicyDishesList);
        Collections.sort(_notSpicyDishesList);
        System.out.println("");
        worldCuisines.displayByDecades(_notSpicyDishesList);
        Main main = new Main();
        main.groupDishesByCountry(_spicyDishesList);
    }

    void groupDishesByCountry(List<Cuisines> spicy) {
        countryMap.clear();
        String country;
        for (var cuisine : spicy) {
            country = cuisine.country;
            if (!countryMap.containsKey(country)) {
                countryMap.put(country, new ArrayList<>());
            }
            countryMap.get(country).add(cuisine);
        }

        Iterator<Map.Entry<String, List<Cuisines>>> iterator = countryMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Cuisines>> entry = iterator.next();
            for (var c : asian_countries) {
                if (entry.getKey().equals(c)) {
                    iterator.remove();
                    break;
                }
            }
        } 

        for (Map.Entry<String, List<Cuisines>> entry : countryMap.entrySet()) {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println(entry.getKey() + ":");
            for (var cuisine : entry.getValue()) {
                System.out.println("- " + cuisine);
            }
        }

    }
}