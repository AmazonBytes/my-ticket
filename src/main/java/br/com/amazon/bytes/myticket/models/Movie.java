package main.java.br.com.amazon.bytes.myticket.models;

public class Movie {

    private String title;

    private int duration;

    private int genre;

    private int ageRating;


    public Movie(String title, int duration, int genre, int ageRating) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.ageRating = ageRating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }
}
