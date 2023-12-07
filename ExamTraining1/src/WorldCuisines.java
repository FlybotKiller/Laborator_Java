import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

public class WorldCuisines {
    void sortBySpiceLevel(List<Cuisines> cuisineList, List<Cuisines> spicy, List<Cuisines> not_spicy) {
        spicy.clear();
        not_spicy.clear();
        /*Map<Boolean, List<Cuisines>> group = cuisineList.stream()
                .collect(Collectors.partitioningBy(cuisines -> "Hot".equals(cuisines.spice_level)));
        spicy.addAll(group.get(true));
        not_spicy.addAll(group.get(false)); */  //Map and partitioning alternative
        cuisineList.stream()
                .filter(cuisines -> "Hot".equals(cuisines.spice_level))
                .forEach(spicy::add);
        cuisineList.stream()
                .filter(cuisines -> !"Hot".equals(cuisines.spice_level))
                .forEach(not_spicy::add);
        System.out.println("Spicy dishes: ");
        spicy.forEach(System.out::println);
        System.out.println("");
        System.out.println("Not spicy dishes: ");
        not_spicy.forEach(System.out::println);
    }

    void quickSpicyDishes(List<Cuisines> spicy) {
        System.out.println("Quick spicy dishes: ");
        for (var cuisines : spicy) {
            if (cuisines.cooking_time_min < 50) {
                System.out.println(cuisines);
            }
        }
    }

    void displayByDecades(List<Cuisines> not_spicy) {
        int currentDecade = not_spicy.get(0).year_introduced / 10 * 10;
        System.out.println("Dishes through the decades: ");
        System.out.println(currentDecade + "s:");
        for (var cuisine : not_spicy) {
            int cuisineDecade = cuisine.year_introduced / 10 * 10;
            if (cuisineDecade != currentDecade) {
                System.out.println(cuisineDecade + "s:");
                currentDecade = cuisineDecade;
            }
            System.out.println(cuisine);
        }
    }
}
