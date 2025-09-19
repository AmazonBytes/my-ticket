package main.java.br.com.amazon.bytes.myticket.models;

public class Room {

    private final int rows;
    private final int cols;
    private final boolean[][] seats;
    private final String[][] seatNames;

    public Room(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.seats = new boolean[rows][cols];
        this.seatNames = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seatNames[i][j] = "R" + (i + 1) + "C" + (j + 1);
            }
        }
    }

    public int[] getSeatPosition(String seatName) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (seatNames[i][j].equalsIgnoreCase(seatName)) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public boolean isReserved(int row, int col) {
        return seats[row][col];
    }

    public String getSeatName(int row, int col) {
        return seatNames[row][col];
    }

    public boolean reserveSeat(int row, int col) {
        if (!seats[row][col]) {
            seats[row][col] = true;
            return true;
        }
        return false;
    }
}
