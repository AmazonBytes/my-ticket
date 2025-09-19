package main.java.br.com.amazon.bytes.myticket.service;

import main.java.br.com.amazon.bytes.myticket.models.Cinema;
import main.java.br.com.amazon.bytes.myticket.models.Movie;
import main.java.br.com.amazon.bytes.myticket.models.Reservation;
import main.java.br.com.amazon.bytes.myticket.models.Room;

public class CinemaService {

    private final Cinema cinema;

    public CinemaService(Cinema cinema) {
        this.cinema = cinema;
    }

    public boolean reserveSeat(String customer, Movie movie, Room room, int row, int col) {
        if (room.reserveSeat(row, col, customer)) {
            Reservation reservation = new Reservation(customer, movie, room, row, col);
            cinema.addReservation(reservation);
            return true;
        }
        return false;
    }

    public void listMovies() {
        for (Movie movie : cinema.getMovies()) {
            System.out.println(movie.getTitle() + " (" + movie.getDuration() + " min, " + movie.getAgeRating() + ")");
        }
    }

}
