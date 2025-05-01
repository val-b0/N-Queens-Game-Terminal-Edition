package com.n_queens.exceptions;

/**
 * Represents an exception thrown when an attempted move in the
 * N-Queens game is invalid. This custom exception provides specific
 * feedback about invalid moves and extends {@code QueensException}.
 */
public class InvalidMoveException extends QueensException {

    /**
     * Constructs an {@code InvalidMoveException} with the provided detail message.
     *
     * @param args the detail message describing the reason for the exception
     */
    public InvalidMoveException(String args) {
        super(args);
    }
}
