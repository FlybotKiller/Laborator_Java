package games;

public class Games implements Comparable<Games> {
    Integer id;
    String title;
    String release_date;
    Double rating;
    String mode;
    String story_time;
    String publisher;


    public Games(Integer id, String title, String release_date, Double rating, String mode, String story_time, String publisher) {
        this.id = id;
        this.title = title;
        this.release_date = release_date;
        this.rating = rating;
        this.mode = mode;
        this.story_time = story_time;
        this.publisher = publisher;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public Double getRating() {
        return rating;
    }

    public String getMode() {
        return mode;
    }

    public String getStory_time() {
        return story_time;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setStory_time(String story_time) {
        this.story_time = story_time;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Games{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", release_date='" + release_date + '\'' +
                ", rating=" + rating +
                ", mode='" + mode + '\'' +
                ", story_time=" + story_time +
                ", publisher='" + publisher + '\'' +
                '}';
    }

    @Override
    public int compareTo(Games other_game) {
        return other_game.rating.compareTo(this.rating);
    }
}
