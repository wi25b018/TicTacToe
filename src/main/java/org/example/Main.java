package org.example;

import java.util.Scanner;

public class Main {
    private static final char EMPTY = '-';

    public static void main(String[] args) {
        char[] board = {
                EMPTY, EMPTY, EMPTY,
                EMPTY, EMPTY, EMPTY,
                EMPTY, EMPTY, EMPTY
        };

        Scanner scanner = new Scanner(System.in);

        printBoard(board);

        System.out.print("Choose an empty square from 1 to 9: ");
        int square = scanner.nextInt();

        if (square < 1 || square > 9) {
            System.out.println("Invalid square. Please choose a number from 1 to 9.");
            return;
        }

        int index = square - 1;

        if (board[index] != EMPTY) {
            System.out.println("This square is already taken.");
            return;
        }

        board[index] = 'X';

        System.out.println("Move accepted.");
        printBoard(board);
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

}
