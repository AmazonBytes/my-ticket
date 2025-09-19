package main.java.br.com.amazon.bytes.myticket.models;

public class Movie {

    private String title;
    private String duration;
    private String genre;

    public Movie(String title, String duration, String genre) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }
}
