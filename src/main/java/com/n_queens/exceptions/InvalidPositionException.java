package com.n_queens.exceptions;

/**
 * Exception thrown when an invalid position (row or column) is accessed or referenced in the N-Queens game.
 */
public class InvalidPositionException extends QueensException {
    private int row;
    private char col;
    private int colInt;

    /**
     * Constructs an exception with the specified row and column (as a character).
     *
     * @param row The row index causing the exception.
     * @param col The column character causing the exception.
     */
    public InvalidPositionException(int row, char col) {
        super("The column " + col + " and the row " + row + " do not exist");
        this.row = row;
        this.col = col;
    }

    /**
     * Constructs an exception with the specified row and column (as an integer).
     *
     * @param row The row index causing the exception.
     * @param col The column index causing the exception.
     */
    public InvalidPositionException(int row, int col) {
        super("The column " + col + " and the row " + row + " do not exist");
        this.row = row;
        this.colInt = col;
    }

    /**
     * Constructs an exception with the specified row.
     *
     * @param row The row index causing the exception.
     */
    public InvalidPositionException(int row) {
        super("The row " + row + " does not exist. ");
        this.row = row;
    }

    /**
     * Constructs an exception with the specified column.
     *
     * @param col The column character causing the exception.
     */
    public InvalidPositionException(char col) {
        super("The column " + col + " does not exist. ");
        this.col = col;
    }

    /**
     * Gets the column character that caused the exception.
     *
     * @return The invalid column as a character.
     */
    public char getCol() {
        return col;
    }

    /**
     * Gets the row index that caused the exception.
     *
     * @return The invalid row index.
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column index (as an integer) that caused the exception.
     *
     * @return The invalid column index.
     */
    public int getColInt() {
        return colInt;
    }
}
