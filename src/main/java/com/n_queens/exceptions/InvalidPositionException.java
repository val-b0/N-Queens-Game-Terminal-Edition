package main.java.com.n_queens.exceptions;

public class InvalidPositionException extends QueensException {
    private int row;
    private char col;
    private int colInt;

    public InvalidPositionException(int row, char col) {
        super("The column " + col + " and the row " + row + " do not exist");
        this.row = row;
        this.col = col;
    }

    //for the custom method in Queen
    public InvalidPositionException(int row, int col) {
        super("The column " + col + " and the row " + row + " do not exist");
        this.row = row;
        this.colInt = col;
    }

    public InvalidPositionException(int row) {
        super("The row " + row + " does not exist. ");
        this.row = row;
    }

    public InvalidPositionException(char col) {
        super("The column " + col + " does not exist. ");
        this.col = col;
    }

    public char getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getColInt() {
        return colInt;
    }
}
