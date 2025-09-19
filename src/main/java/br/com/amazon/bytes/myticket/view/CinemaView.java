package main.java.br.com.amazon.bytes.myticket.view;

import main.java.br.com.amazon.bytes.myticket.models.Movie;
import main.java.br.com.amazon.bytes.myticket.models.Room;
import main.java.br.com.amazon.bytes.myticket.service.CinemaService;

import java.util.List;
import java.util.Scanner;

public class CinemaView {

    private static final String SEPARATOR = "**************************************";

    private final CinemaService service;
    private final Scanner scanner = new Scanner(System.in);

    public CinemaView(CinemaService service) {
        this.service = service;
    }

    public void start() {
        int option;
        do {
            System.out.println("1. [Filmes em Cartaz]");
            System.out.println("2. [Reservar Ingresso]");
            System.out.println("0. [Finalizar sistema]");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    listMoviesFlow();
                    break;
                case 2:
                    reserveSeatFlow();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }

    private void listMoviesFlow() {
        List<Movie> movies = service.getMovies();
        if (movies == null || movies.isEmpty()) {
            System.out.println("Nenhum filme disponível.");
            return;
        }
        for (int i = 0; i < movies.size(); i++) {
            Movie m = movies.get(i);
            System.out.printf("%d. %s | Duration: %s | Genre: %s%n", i + 1, m.getTitle(), m.getDuration(), m.getGenre());

        }
        System.out.println(SEPARATOR);
        System.out.print("Pressione ENTER para voltar ao menu principal...");
        scanner.nextLine();
    }

    private void reserveSeatFlow() {
        List<Movie> movies = service.getMovies();
        if (movies == null || movies.isEmpty()) {
            System.out.println("Nenhum filme disponível.");
            return;
        }
        System.out.println(SEPARATOR);
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i).getTitle());
        }
        System.out.println(SEPARATOR);
        System.out.print("Escolha o filme: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida.");
            scanner.nextLine();
            return;
        }
        int movieIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        if (movieIndex < 0 || movieIndex >= movies.size()) {
            System.out.println("Filme inválido.");
            return;
        }
        Movie movie = movies.get(movieIndex);

        System.out.print("Digite seu nome: ");
        String customer = scanner.nextLine();

        System.out.print("Quantos assentos deseja reservar? ");
        if (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida.");
            scanner.nextLine();
            return;
        }
        int seatCount = scanner.nextInt();
        scanner.nextLine();

        Room room = service.getRoomForMovie();

        System.out.println("Escolha seu assento abaixo:");
        showSeats(room);

        int reserved = 0;
        while (reserved < seatCount) {
            System.out.print("Escolha o assento (" + (reserved + 1) + "): ");
            String seatName = scanner.nextLine();
            int[] pos = parseSeatName(seatName);

            boolean invalid = pos.length == 0 || pos[0] < 0 || pos[1] < 0 || pos[0] >= room.getRows() || pos[1] >= room.getCols();
            boolean alreadyReserved = !invalid && room.isReserved(pos[0], pos[1]);

            if (invalid) {
                System.out.println("Assento inválido.");
            } else if (alreadyReserved) {
                System.out.println("Assento já reservado.");
            } else {
                room.reserveSeat(pos[0], pos[1]);
                reserved++;
            }
        }

        System.out.println();
        System.out.println("Parabéns " + customer + ", reservou " + seatCount + " ingressos com sucesso para o filme " + movie.getTitle() + ", Boa sessão!");
        System.out.println();
        System.out.println("Tabela de assentos atualizada:");
        System.out.println();
        showSeats(room);
        System.out.println();
        System.out.println(SEPARATOR);
        System.out.println();
        System.out.println("Finalizando o sistema... Volte Sempre " + customer + "!");
        System.exit(0);
    }

    private int[] parseSeatName(String seatName) {
        try {
            String[] parts = seatName.substring(1).split("C");
            int row = Integer.parseInt(parts[0]) - 1;
            int col = Integer.parseInt(parts[1]) - 1;
            return new int[]{row, col};
        } catch (Exception e) {
            return new int[0];
        }
    }

    private void showSeats(Room room) {
        for (int i = 0; i < room.getRows(); i++) {
            for (int j = 0; j < room.getCols(); j++) {
                String seat = room.isReserved(i, j) ? " X " : room.getSeatName(i, j);
                System.out.print(seat);
                if (j < room.getCols() - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < room.getRows() - 1) {
                System.out.println("---------------------------------");
            }
        }
    }
}
