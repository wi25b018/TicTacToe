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
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }
}
