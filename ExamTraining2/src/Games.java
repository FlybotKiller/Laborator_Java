public class Games implements Comparable<Games> {
    private Integer ID;
    private String title;
    private String developer;
    private String genre;
    private Integer release_year;
    private String platforms;
    private Integer price;
    private Double rating;
    private Integer playtime;

    public Games(Integer ID, String title, String developer, String genre, Integer release_year, String platforms, Integer price, Double rating, Integer playtime) {
        this.ID = ID;
        this.title = title;
        this.developer = developer;
        this.genre = genre;
        this.release_year = release_year;
        this.platforms = platforms;
        this.price = price;
        this.rating = rating;
        this.playtime = playtime;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getPlaytime() {
        return playtime;
    }

    public void setPlaytime(Integer playtime) {
        this.playtime = playtime;
    }

    @Override
    public String toString() {
        return "Games{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", developer='" + developer + '\'' +
                ", genre='" + genre + '\'' +
                ", release_year=" + release_year +
                ", platforms='" + platforms + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", playtime=" + playtime +
                '}';
    }

    @Override
    public int compareTo(Games other_game) {
        return this.price.compareTo(other_game.price);
    }
}
