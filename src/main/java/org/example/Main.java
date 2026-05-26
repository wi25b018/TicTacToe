package org.example;

import java.util.Scanner;

public class Main {
    private static final char EMPTY = '-';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {

            char[] board = {
                    EMPTY, EMPTY, EMPTY,
                    EMPTY, EMPTY, EMPTY,
                    EMPTY, EMPTY, EMPTY
            };

            char currentPlayer = 'X';
            boolean gameOver = false;

            while (!gameOver) {

                printBoard(board);

                System.out.print("Player " + currentPlayer + ", choose an empty square from 1 to 9: ");
                int square = scanner.nextInt();

                if (square < 1 || square > 9) {
                    System.out.println("Invalid square. Please choose a number from 1 to 9.");
                    continue;
                }

                int index = square - 1;

                if (board[index] != EMPTY) {
                    System.out.println("This square is already taken.");
                    continue;
                }

                board[index] = currentPlayer;

                if (hasWinner(board, currentPlayer)) {
                    printBoard(board);
                    System.out.println(currentPlayer + " wins!");
                    gameOver = true;

                } else if (isDraw(board)) {
                    printBoard(board);
                    System.out.println("The game is a draw.");
                    gameOver = true;

                } else {

                    if (currentPlayer == 'X') {
                        currentPlayer = 'O';
                    } else {
                        currentPlayer = 'X';
                    }
                }
            }

            System.out.print("Do you want to start a new game? yes/no: ");
            String answer = scanner.next();

            playAgain = answer.equalsIgnoreCase("yes");
        }

        System.out.println("Game ended.");
    }

    private static void printBoard(char[] board) {
        System.out.println();
        System.out.println("Current game board:");
        System.out.println();

        System.out.println(formatCell(board, 0) + " | " + formatCell(board, 1) + " | " + formatCell(board, 2));
        System.out.println("--+---+--");

        System.out.println(formatCell(board, 3) + " | " + formatCell(board, 4) + " | " + formatCell(board, 5));
        System.out.println("--+---+--");

        System.out.println(formatCell(board, 6) + " | " + formatCell(board, 7) + " | " + formatCell(board, 8));

        System.out.println();
    }

    private static char formatCell(char[] board, int index) {

        if (board[index] == EMPTY) {
            return Character.forDigit(index + 1, 10);
        }

        return board[index];
    }

    private static boolean hasWinner(char[] board, char player) {

        int[][] winningCombinations = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };

        for (int[] combination : winningCombinations) {

            if (board[combination[0]] == player
                    && board[combination[1]] == player
                    && board[combination[2]] == player) {

                return true;
            }
        }

        return false;
    }

    private static boolean isDraw(char[] board) {

        for (char cell : board) {

            if (cell == EMPTY) {
                return false;
            }
        }

        return !hasWinner(board, 'X') && !hasWinner(board, 'O');
    }
}