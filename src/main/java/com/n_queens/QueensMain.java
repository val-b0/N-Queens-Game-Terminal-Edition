package main.java.com.n_queens;

import main.java.com.n_queens.game_logic.Queens;
import main.java.com.n_queens.game_logic.State;

import java.util.Scanner;

public class QueensMain {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.print("What size: ");
        int n = scanner.nextInt();
        Queens game = Queens.create(n);

        System.out.println();
        printBoard(game);

        boolean terminate = false;
        while (!terminate) {
            System.out.println();
            System.out.print("Put on chosen cell (P) | Remove (R) | Clear (C) | Quit (Q): ");
            char cmd = Character.toUpperCase(scanner.next().charAt(0));
            if (cmd == 'P') {
                System.out.print("The queen is put on the cell: ");
                int row = scanner.nextInt();
                System.out.print("                Column: ");
                char col = Character.toUpperCase(scanner.next().charAt(0));

                State gameState = game.setQueen(row, col);
                if (gameState == State.COMPLETE) terminate = true;
                printBoard(game);

            } else if (cmd == 'R') {
                System.out.print("Removing queen from cell: ");
                int row = scanner.nextInt();
                System.out.print("                   Column: ");
                char col = Character.toUpperCase(scanner.next().charAt(0));

                State gameState = game.removeQueen(row, col);
                if (gameState == State.COMPLETE) terminate = true;
                printBoard(game);

            } else if (cmd == 'C') {
                game.clear();
                printBoard(game);
            } else if (cmd == 'Q') {
                terminate = true;
            } else {
                System.out.println("Unverified command!");
            }
        }
        scanner.close();
    }

    private static void printBoard(Queens game) throws Exception {
        System.out.print("   |");
        for (int col = 0; col < game.getSize(); col++) {
            System.out.print(String.format(" %c ", (char) ('A' + col)));
        }
        System.out.println("|");
        System.out.print("---|");
        for (int col = 0; col < game.getSize(); col++) {
            System.out.print("---");
        }
        System.out.println("|");

        for (int row = 1; row <= game.getSize(); row++) {
            System.out.print(String.format(" %d |", row));
            for (int col = 0; col < game.getSize(); col++) {
                System.out.print(game.hasQueen(row, col) ? " Q " : " . ");
            }
            System.out.println("|");
        }
        System.out.print("---|");
        for (int col = 0; col < game.getSize(); col++) {
            System.out.print("---");
        }
        System.out.println("|");
        System.out.println();
        System.out.println("Stand: " + game.getStringGameState(game.getGameState()));
    }

}

