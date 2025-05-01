package com.n_queens.game_logic;

import com.n_queens.exceptions.InvalidMoveException;
import com.n_queens.exceptions.InvalidPositionException;
import com.n_queens.exceptions.QueensException;

import java.util.Arrays;
import java.util.List;

import static com.n_queens.util.QueensUtils.invalidPositionCheck;


public class Queens {

    private final int size;
    private int[][] board;
    private int nQueens;
    private State gameState;
    /**
     * Constructs a Queens game with a specified board size.
     *
     * @param n the size of the board (n x n)
     */
    private Queens(int n) {
        this.board = new int[n][n];
        this.size = n;
        this.gameState = State.INCOMPLETE;
    }

    /**
     * Creates a Queens game instance with the specified board size.
     *
     * @param n the size of the board (n x n)
     * @return a new Queens instance
     * @throws IllegalArgumentException if the board size is less than 1
     */
    public static Queens create(int n) throws IllegalArgumentException {
        if (n < 1) throw new IllegalArgumentException("Cannot create board with negative number of fields");
        return new Queens(n);
    }

    /**
     * Retrieves the size of the board.
     *
     * @return the size of the board (n x n)
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets the current number of queens placed on the board.
     *
     * @return the number of queens placed
     */
    public int getNQueens() {
        return nQueens;
    }

    /**
     * Places a queen at the specified board position.
     *
     * @param row the row index (starting from 1)
     * @param col the column character (A, B, C, ...)
     * @return the updated game state
     * @throws QueensException if the position is invalid or already occupied
     */
    public State setQueen(int row, char col) throws QueensException {
        int shiftedRow = shiftingRow(row);
        int letterIndex = letterIndex(col);

        invalidPositionCheck(this.size, letterIndex, col, row);

        if (hasQueen(row, col)) throw new InvalidMoveException("The position " + row + " " + col + " is already taken");
        if (gameState == State.COMPLETE) throw new UnsupportedOperationException("The game is completed. ");

        board[shiftedRow][letterIndex] = 1;
        nQueens++;

        return getGameState();
    }

    /**
     * Removes a queen from the specified board position.
     *
     * @param row the row index (starting from 1)
     * @param col the column character (A, B, C, ...)
     * @return the updated game state
     * @throws QueensException if the position is invalid or if removal is not allowed
     */
    public State removeQueen(int row, char col) throws QueensException {
        int shiftedRow = shiftingRow(row);
        int letterIndex = letterIndex(col);

        invalidPositionCheck(this.size, letterIndex, col, row);

        if (gameState == State.INCOMPLETE)
            throw new UnsupportedOperationException("Element cannot be removed from game in progress.");
        if (board[shiftedRow][letterIndex] != 1)
            throw new InvalidMoveException("The postion " + row + " " + col + " is empty at the time");
        if (gameState == State.COMPLETE) throw new UnsupportedOperationException("The game is completed");

        board[shiftedRow][letterIndex] = 0;
        nQueens--;

        return getGameState();
    }

    /**
     * Checks if a queen is located at the specified board position.
     *
     * @param row the row index (starting from 1)
     * @param col the column character (A, B, C, ...)
     * @return true if a queen is present, false otherwise
     * @throws InvalidPositionException if the position is out of board bounds
     */
    public boolean hasQueen(int row, char col) throws InvalidPositionException {
        int shiftedRow = shiftingRow(row);
        int letterIndex = letterIndex(col);

        invalidPositionCheck(this.size, letterIndex, col, row);

        return board[shiftedRow][letterIndex] == 1;
    }

    /**
     * Determines the current game state based on the position of queens.
     *
     * @return the current state (INCOMPLETE, COMPLETE, or INVALID)
     */
    public State getGameState() {
        Integer[] positions = new Integer[size];
        Arrays.fill(positions, -1);

        //row check, making game invalid if > 1 queen in the row
        for (int[] integers : board) {
            if ((int) Arrays.stream(integers).filter(e -> e == 1).count() > 1) {
                gameState = State.INVALID;
                return gameState;
            }
        }
        //filling the position array with positions of Queens
        for (int j = 0; j < board.length; j++) {
            for (int k = 0; k < board[j].length; k++) {
                if (board[j][k] == 1) positions[j] = k;
            }
        }
        //in case there are some rows that miss queen
        if (Arrays.stream(positions).anyMatch(e -> e == -1)) {
            gameState = State.INCOMPLETE;
            return gameState;
        }

        //column check
        if (Arrays.stream(positions).distinct().count() < positions.length) {
            gameState = State.INVALID;
            return gameState;
        }

        //main diagonal check
        if (Arrays.stream(positions).map(e -> List.of(positions).indexOf(e) - e).toList().stream().distinct().count() < positions.length) {
            gameState = State.INVALID;
            return gameState;
        }
        //second diagonal check
        if (Arrays.stream(positions).map(e -> e + List.of(positions).indexOf(e)).toList().stream().distinct().count() < positions.length) {
            gameState = State.INVALID;
            return gameState;
        }
        gameState = State.COMPLETE;

        return gameState;
    }

    /**
     * Resets the game by clearing all queens and resetting the board.
     */
    public void clear() {
        board = new int[size][size];
        gameState = State.INCOMPLETE;
        nQueens = 0;
    }

    //Custom helping methods

    /**
     * Converts a column character (A, B, C, ...) into its corresponding index.
     *
     * @param letter the column character
     * @return the zero-based index of the column
     */
    public int letterIndex(char letter) {
        return Character.toUpperCase(letter) - 'A';
    }

    /**
     * Converts a one-based row index into a zero-based index.
     *
     * @param row the one-based row index
     * @return the zero-based row index
     */
    public int shiftingRow(int row) {
        return row - 1;
    }

    /**
     * Checks if a queen is located at the specified position using numeric indices.
     *
     * @param row the row index (starting from 1)
     * @param col the zero-based column index
     * @return true if a queen is present, false otherwise
     * @throws InvalidPositionException if the position is out of board bounds
     */
    public boolean hasQueen(int row, int col) throws InvalidPositionException {
        int shiftedRow = shiftingRow(row);

        if ((row > size || row < 1) && (col >= size || col < 0)) throw new InvalidPositionException(row, col);
        else if (row > size || row < 1) throw new InvalidPositionException(row);
        else if (col > size || col < 0) throw new InvalidPositionException(col);

        return board[shiftedRow][col] == 1;
    }

    /**
     * Converts a `State` enum value into a user-friendly string representation.
     *
     * @param gameState the current game state
     * @return the string representation of the game state
     */
    public String getStringGameState(State gameState) {
        String stateToReturn = "";
        switch (gameState) {
            case COMPLETE -> stateToReturn = "complete";
            case INCOMPLETE -> stateToReturn = "incomplete";
            case INVALID -> stateToReturn = "invalid";
        }
        return stateToReturn;
    }

}

