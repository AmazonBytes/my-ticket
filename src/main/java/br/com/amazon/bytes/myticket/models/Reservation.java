package main.java.br.com.amazon.bytes.myticket.models;

public class Reservation {

    private String customer;
    private Movie movie;
    private Room room;
    private int row;
    private int col;

    public Reservation(String customer, Movie movie, Room room, int row, int col) {
        this.customer = customer;
        this.movie = movie;
        this.room = room;
        this.row = row;
        this.col = col;
    }

    public String getCustomer() { return customer; }
    public Movie getMovie() { return movie; }
    public Room getRoom() { return room; }
    public int getRow() { return row; }
    public int getCol() { return col; }
}
