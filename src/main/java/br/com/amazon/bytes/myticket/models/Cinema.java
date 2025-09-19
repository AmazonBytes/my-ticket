package main.java.br.com.amazon.bytes.myticket.models;

import java.util.ArrayList;

public class Cinema {

    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public void addMovie(Movie movie) { movies.add(movie); }
    public void addRoom(Room room) { rooms.add(room); }
    public void addReservation(Reservation reservation) { reservations.add(reservation); }

    public ArrayList<Movie> getMovies() { return movies; }
    public ArrayList<Room> getRooms() { return rooms; }
    public ArrayList<Reservation> getReservations() { return reservations; }
}
