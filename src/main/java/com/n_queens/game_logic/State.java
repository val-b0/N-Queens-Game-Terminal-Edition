package com.n_queens.game_logic;

/**
 * Represents the possible states of the N-Queens game.
 */
public enum State {

    /**
     * Indicates the game is successfully completed
     * with all queens placed without conflicts.
     */
    COMPLETE,

    /**
     * Indicates the game is incomplete
     * with queens still needing to be placed.
     */
    INCOMPLETE,

    /**
     * Indicates the game is in an invalid state
     * due to conflicts between queens.
     */
    INVALID
}
