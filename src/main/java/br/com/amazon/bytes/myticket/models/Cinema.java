package main.java.br.com.amazon.bytes.myticket.models;

import java.util.ArrayList;
import java.util.List;

public class Cinema {

    private final List<Movie> movies = new ArrayList<>();
    private final List<Room> rooms = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();

    public void addMovie(Movie movie) { movies.add(movie); }
    public void addRoom(Room room) { rooms.add(room); }
    public void addReservation(Reservation reservation) { reservations.add(reservation); }

    public List<Movie> getMovies() { return movies; }
    public List<Room> getRooms() { return rooms; }
    public List<Reservation> getReservations() { return reservations; }
}
