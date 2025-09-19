package main.java.br.com.amazon.bytes.myticket;

import main.java.br.com.amazon.bytes.myticket.models.Cinema;
import main.java.br.com.amazon.bytes.myticket.service.CinemaService;
import main.java.br.com.amazon.bytes.myticket.view.CinemaView;

public class Application {

    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        CinemaService service = new CinemaService(cinema);
        CinemaView view = new CinemaView(service);
        view.start();
    }
}
