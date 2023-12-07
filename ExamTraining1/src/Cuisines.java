public class Cuisines implements Comparable<Cuisines> {
    String country;
    String dish_name;
    String main_ingredient;
    Integer cooking_time_min;
    Integer servings;
    String spice_level;
    Integer calories;
    Integer year_introduced;
    String chef_name;

    public Cuisines(String country, String dish_name, String main_ingredient, Integer cooking_time_min, Integer servings, String spice_level, Integer calories, Integer year_introduced, String chef_name) {
        this.country = country;
        this.dish_name = dish_name;
        this.main_ingredient = main_ingredient;
        this.cooking_time_min = cooking_time_min;
        this.servings = servings;
        this.spice_level = spice_level;
        this.calories = calories;
        this.year_introduced = year_introduced;
        this.chef_name = chef_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getMain_ingredient() {
        return main_ingredient;
    }

    public void setMain_ingredient(String main_ingredient) {
        this.main_ingredient = main_ingredient;
    }

    public Integer getCooking_time_min() {
        return cooking_time_min;
    }

    public void setCooking_time_min(Integer cooking_time_min) {
        this.cooking_time_min = cooking_time_min;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSpice_level() {
        return spice_level;
    }

    public void setSpice_level(String spice_level) {
        this.spice_level = spice_level;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getYear_introduced() {
        return year_introduced;
    }

    public void setYear_introduced(Integer year_introduced) {
        this.year_introduced = year_introduced;
    }

    public String getChef_name() {
        return chef_name;
    }

    public void setChef_name(String chef_name) {
        this.chef_name = chef_name;
    }

    @Override
    public String toString() {
        return "Cuisines{" +
                "dish_name='" + dish_name + '\'' +
                ", main_ingredient='" + main_ingredient + '\'' +
                ", calories=" + calories +
                '}';
    }


    @Override
    public int compareTo(Cuisines other_cuisine) {
        return other_cuisine.year_introduced.compareTo(this.year_introduced);
    }
}
