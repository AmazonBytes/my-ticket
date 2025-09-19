package main.java.br.com.amazon.bytes.myticket.view;

import main.java.br.com.amazon.bytes.myticket.service.CinemaService;

import java.util.Scanner;

public class CinemaView {

    private CinemaService service;
    private Scanner scanner = new Scanner(System.in);

    public CinemaView(CinemaService service) {
        this.service = service;
    }

    public void showMenu() {
        System.out.println("1. List movies");
        System.out.println("2. Reserve seat");
        System.out.println("0. Exit");
    }

    public void start() {
        int option;
        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    service.listMovies();
                    break;
                case 2:
                    System.out.println("Feature not implemented yet.");
                    break;
            }
        } while (option != 0);
    }

}
