package com.n_queens.util;

import com.n_queens.exceptions.InvalidPositionException;

/**
 * Utility class containing reusable methods for validating chessboard positions
 * in the N-Queens game. Designed to simplify and centralize validation logic.
 */
public class QueensUtils {

    /**
     * Private constructor to enforce non-instantiability of this utility class.
     * Throws an exception if instantiation is attempted.
     *
     * @throws UnsupportedOperationException if an attempt is made to construct an instance.
     */
    private QueensUtils() {
        throw new UnsupportedOperationException("Cannot instantiate utility class");
    }

    /**
     * Validates whether a given position on the chessboard is valid.
     * A position is valid if its row and column index fall within the range of the board's dimensions.
     *
     * @param size        The size (n) of the chessboard (n x n).
     * @param letterIndex The column index (0-based) derived from a letter coordinate.
     * @param col         The column index as an integer (e.g., ASCII value or direct index).
     * @param row         The row index (1-based) of the chessboard position.
     * @throws InvalidPositionException if the provided row or column index is out of bounds.
     */
    public static void invalidPositionCheck(int size, int letterIndex, int col, int row) throws InvalidPositionException {
        if ((row > size || row < 1) && (letterIndex >= size || letterIndex < 0))
            throw new InvalidPositionException(row, col);
        else if (row > size || row < 1) throw new InvalidPositionException(row);
        else if (letterIndex >= size || letterIndex < 0) throw new InvalidPositionException(col);
    }

}
