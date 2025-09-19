package main.java.br.com.amazon.bytes.myticket.service;

import main.java.br.com.amazon.bytes.myticket.models.Movie;
import main.java.br.com.amazon.bytes.myticket.models.Room;

import java.util.ArrayList;
import java.util.List;

public class CinemaService {

    private final List<Movie> movies = new ArrayList<>();
    private final Room room = new Room(5, 5);

    public CinemaService() {
        movies.add(new Movie("Meu Amigo Totoro (1988) – Studio Ghibli Fest 2025", "105 min", "Animation, Fantasy"));
        movies.add(new Movie("Demon Slayer: Kimetsu no Yaiba Castelo Infinito", "156 min", "Action, Animation"));
        movies.add(new Movie("Invocação do Mal 4: O Último Ritual", "135 min", "Horror"));
        movies.add(new Movie("A grande viagem da sua vida", "109 min", "Drama"));
        movies.add(new Movie("Animais Perigosos", "85 min", "Horror, Action"));
        movies.add(new Movie("It", "132 min", "Horror, Thriller"));

    }

    public List<Movie> getMovies() {
        return movies;
    }

    public Room getRoomForMovie(Movie movie) {
        return room;
    }

    public boolean reserveSeat(String customer, Movie movie, Room room, int row, int col) {
        return room.reserveSeat(row, col);
    }

    public String generateReservationMessage(String customerName, String[] seats, Movie selectedMovie) {
        return String.format(
                "Seats reserved for %s: %s\nMovie: %s\nDuration: %d min\nGenre: %s\nEnjoy your session!",
                customerName,
                String.join(" ", seats),
                selectedMovie.getTitle(),
                selectedMovie.getDuration(),
                selectedMovie.getGenre()
        );
    }

    public void printMoviesList() {
        for (Movie movie : movies) {
            System.out.printf(
                    "%s | Duration: %s | Genre: %s\n",
                    movie.getTitle(),
                    movie.getDuration(),
                    movie.getGenre()
            );
        }
    }
}
