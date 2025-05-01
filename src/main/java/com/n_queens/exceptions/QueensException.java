package com.n_queens.exceptions;

/**
 * A custom exception for handling errors related to the n-Queens game.
 * This serves as a base exception class for specific n-Queens exceptions.
 */
public class QueensException extends Exception {
    /**
     * Constructs a QueensException with the specified detail message.
     *
     * @param message The detail message describing the exception.
     */
    public QueensException(String message) {
        super(message);
    }
}
