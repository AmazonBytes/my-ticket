package main.java.br.com.amazon.bytes.myticket.models;

public class Room {

    private final int number;
    private final String[][] seats = new String[5][5];

    public Room(int number) {
        this.number = number;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                seats[i][j] = "";
    }

    public boolean reserveSeat(int row, int col, String customer) {
        if (seats[row][col].isEmpty()) {
            seats[row][col] = customer;
            return true;
        }
        return false;
    }

    public void showSeatMap() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(seats[i][j].isEmpty() ? "[ ]" : "[X]");
            }
            System.out.println();
        }
    }

    public int getNumber() { return number; }
}
