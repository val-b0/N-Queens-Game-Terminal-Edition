package com;

import com.n_queens.exceptions.InvalidMoveException;
import com.n_queens.exceptions.InvalidPositionException;
import com.n_queens.exceptions.QueensException;
import com.n_queens.game_logic.Queens;
import com.n_queens.game_logic.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the {@link Queens} class.
 * Contains unit tests to verify the functionality of different methods in the Queens class.
 */
class QueensTest {
    /**
     * Instance of the {@link Queens} class used for testing various methods.
     */
    Queens testingEntity;

    /**
     * Initializes the testing environment before each test by creating a 4x4 Queens board.
     */
    @BeforeEach
    void set_up() {
        testingEntity = Queens.create(4);
    }

    /**
     * Tests the creation of a {@link Queens} object and validates the constructor behavior.
     *
     * @throws QueensException If any invalid operation is attempted on the Queens board.
     */
    @Test
    void create_and_constructor() throws QueensException {
        assertThrows(IllegalArgumentException.class, () -> Queens.create(-1));
        assertThrows(IllegalArgumentException.class, () -> Queens.create(0));

        //Proves that 2D array created is indeed of the given size in both dimensions
        assertThrows(InvalidPositionException.class, () -> testingEntity.setQueen(5, 'A'));
        assertThrows(InvalidPositionException.class, () -> testingEntity.setQueen(1, 'E'));
        testingEntity.setQueen(4, 'D');// 4x4
        testingEntity.setQueen(4, 'C');
        testingEntity.removeQueen(4, 'D');

        assertEquals(4, testingEntity.getSize());
        assertEquals(1, testingEntity.getNQueens());
        assertEquals(State.INCOMPLETE, testingEntity.getGameState());
    }

    /**
     * Verifies that the {@link Queens#getSize()} method returns the correct size of the board.
     */
    @Test
    void getSize_test() {
        assertEquals(4, testingEntity.getSize());
        testingEntity = Queens.create(1);
        assertEquals(1, testingEntity.getSize());
        testingEntity = Queens.create(2);
        assertEquals(2, testingEntity.getSize());
    }

    /**
     * Validates the {@link Queens#getNQueens()} method by checking the number of queens set on the board.
     *
     * @throws QueensException If any invalid placement or removal of queens is attempted.
     */
    @Test
    void getNQueens_test() throws QueensException {
        assertEquals(0, testingEntity.getNQueens());
        testingEntity.setQueen(1, 'A');
        testingEntity.setQueen(2, 'A');
        testingEntity.setQueen(3, 'A');

        testingEntity.setQueen(1, 'B');
        testingEntity.setQueen(2, 'B');
        testingEntity.setQueen(3, 'B');

        assertEquals(6, testingEntity.getNQueens());
        testingEntity.removeQueen(1, 'A');
        testingEntity.removeQueen(2, 'A');
        testingEntity.removeQueen(3, 'A');
        assertEquals(3, testingEntity.getNQueens());

    }

    /**
     * Tests the {@link Queens#setQueen(int, char)} method by validating queen placement rules.
     *
     * @throws QueensException If a queen is set in an invalid position or other errors occur.
     */
    @Test
    void setQueen_test() throws QueensException {
        assertThrows(InvalidPositionException.class, () -> testingEntity.setQueen(0, 'E'));
        assertThrows(InvalidPositionException.class, () -> testingEntity.setQueen(5, 'B'));
        assertThrows(InvalidPositionException.class, () -> testingEntity.setQueen(1, 'F'));
        assertThrows(InvalidPositionException.class, () -> testingEntity.setQueen(-1, 'A'));

        //setting occupied cell check
        testingEntity.setQueen(1, 'B');
        testingEntity.setQueen(2, 'D');
        testingEntity.setQueen(3, 'A');
        testingEntity.setQueen(4, 'C');

        assertThrows(InvalidMoveException.class, () -> testingEntity.setQueen(1, 'B'));

        //proofing set works
        assertTrue(testingEntity.hasQueen(1, 'B'));
        assertTrue(testingEntity.hasQueen(2, 'D'));
        assertTrue(testingEntity.hasQueen(3, 'A'));
        assertTrue(testingEntity.hasQueen(4, 'C'));

        //setting while game finished check
        assertThrows(UnsupportedOperationException.class, () -> testingEntity.setQueen(1, 'C'));
    }

    /**
     * Tests the {@link Queens#removeQueen(int, char)} method by ensuring queens can be removed under valid scenarios.
     *
     * @throws QueensException If invalid queen removal operations are performed.
     */
    @Test
    void removeQueen_test() throws QueensException {
        assertThrows(InvalidPositionException.class, () -> testingEntity.removeQueen(0, 'E'));
        assertThrows(InvalidPositionException.class, () -> testingEntity.removeQueen(5, 'B'));
        assertThrows(InvalidPositionException.class, () -> testingEntity.removeQueen(1, 'F'));
        assertThrows(InvalidPositionException.class, () -> testingEntity.removeQueen(-1, 'A'));

        //removing while game incomplete
        testingEntity.setQueen(1, 'A');
        assertThrows(UnsupportedOperationException.class, () -> testingEntity.removeQueen(1, 'A'));

        //removing empty value
        testingEntity.setQueen(1, 'B');
        assertThrows(InvalidMoveException.class, () -> testingEntity.removeQueen(1, 'C'));

        testingEntity.clear();

        //removing while game completed
        testingEntity.setQueen(1, 'B');
        testingEntity.setQueen(2, 'D');
        testingEntity.setQueen(3, 'A');
        testingEntity.setQueen(4, 'C');

        assertThrows(UnsupportedOperationException.class, () -> testingEntity.removeQueen(1, 'B'));
        testingEntity.clear();

        //proofing if removal works
        testingEntity.setQueen(1, 'B');
        testingEntity.setQueen(2, 'D');
        testingEntity.setQueen(3, 'A');
        testingEntity.setQueen(4, 'D');

        testingEntity.removeQueen(4, 'D');

        assertFalse(testingEntity.hasQueen(4, 'D'));

    }

    /**
     * Validates the {@link Queens#hasQueen(int, char)} method by checking the presence of queens at specific positions.
     *
     * @throws QueensException If invalid positions are checked for queens.
     */
    @Test
    void hasQueen_test() throws QueensException {
        assertThrows(InvalidPositionException.class, () -> testingEntity.hasQueen(0, 'E'));
        assertThrows(InvalidPositionException.class, () -> testingEntity.hasQueen(5, 'B'));
        assertThrows(InvalidPositionException.class, () -> testingEntity.hasQueen(1, 'F'));
        assertThrows(InvalidPositionException.class, () -> testingEntity.hasQueen(-1, 'A'));

        testingEntity.setQueen(1, 'A');
        testingEntity.setQueen(2, 'A');

        assertTrue(testingEntity.hasQueen(1, 'A'));
        assertTrue(testingEntity.hasQueen(2, 'A'));

        assertFalse(testingEntity.hasQueen(3, 'A'));
        assertFalse(testingEntity.hasQueen(4, 'B'));

    }

    /**
     * Tests the {@link Queens#getGameState()} method by verifying different game states: INCOMPLETE, INVALID, and COMPLETE.
     *
     * @throws QueensException If invalid operations are performed on the board.
     */
    @Test
    void getGameState_test() throws QueensException {
        assertEquals(State.INCOMPLETE, testingEntity.getGameState());

        //row failed
        testingEntity.setQueen(1, 'A');
        assertEquals(State.INCOMPLETE, testingEntity.getGameState());
        testingEntity.setQueen(1, 'B');
        assertEquals(State.INVALID, testingEntity.getGameState());

        testingEntity.clear();

        //column failed
        testingEntity.setQueen(1, 'A');
        assertEquals(State.INCOMPLETE, testingEntity.getGameState());
        testingEntity.setQueen(2, 'A');
        testingEntity.setQueen(3, 'A');
        testingEntity.setQueen(4, 'A');
        assertEquals(State.INVALID, testingEntity.getGameState());

        testingEntity.clear();

        //main diagonal check
        testingEntity.setQueen(1, 'A');
        assertEquals(State.INCOMPLETE, testingEntity.getGameState());
        testingEntity.setQueen(2, 'B');
        testingEntity.setQueen(3, 'C');
        testingEntity.setQueen(4, 'D');
        assertEquals(State.INVALID, testingEntity.getGameState());

        testingEntity.clear();

        //second diagonal check
        testingEntity.setQueen(1, 'D');
        assertEquals(State.INCOMPLETE, testingEntity.getGameState());
        testingEntity.setQueen(2, 'C');
        testingEntity.setQueen(3, 'B');
        testingEntity.setQueen(4, 'A');
        assertEquals(State.INVALID, testingEntity.getGameState());

        testingEntity.clear();


        //completion check
        testingEntity.setQueen(1, 'B');
        assertEquals(State.INCOMPLETE, testingEntity.getGameState());
        testingEntity.setQueen(2, 'D');
        testingEntity.setQueen(3, 'A');
        testingEntity.setQueen(4, 'C');
        assertEquals(State.COMPLETE, testingEntity.getGameState());
    }

    /**
     * Validates the {@link Queens#clear()} method, ensuring it resets the board and game state appropriately.
     *
     * @throws QueensException If any invalid operation is attempted during the test.
     */
    @Test
    void clear() throws QueensException {
        testingEntity.setQueen(1, 'A');
        testingEntity.setQueen(2, 'A');
        assertEquals(State.INCOMPLETE, testingEntity.getGameState());
        assertEquals(2, testingEntity.getNQueens());

        testingEntity.clear();

        //proofing every cell is empty
        char[] letters = {'A', 'B', 'C', 'D'};
        for (char letter : letters) {
            for (int j = 1; j <= 4; j++) {
                assertFalse(testingEntity.hasQueen(j, letter));
            }
        }

        //proofing other parameters are set to default values
        assertEquals(State.INCOMPLETE, testingEntity.getGameState());
        assertEquals(0, testingEntity.getNQueens());

    }
}