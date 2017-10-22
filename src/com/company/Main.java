package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        String input = "4\n" +
                "2 3\n" +
                "0 2\n" +
                "1 0\n" +
                "2 2";
        Scanner sc = new Scanner(input);

        int boardSize = sc.nextInt();

        int[] coordinates = new int[2 * boardSize];
        for (int i = 0; i < 2 * boardSize; i++) {
            coordinates[i] = sc.nextInt();
        }

        int[][] pairedCoord = new int[boardSize][];
        int n = 1;
        for (int j = 0; j < boardSize; j++) {
            int[] tempCoord = new int[2];
            tempCoord[0] = coordinates[n - 1];
            tempCoord[1] = coordinates[n];
            pairedCoord[j] = tempCoord;
            n = n + 2;
        }

        String result = "CORRECT";

        for (int x = pairedCoord.length; x >= 2; x--) {
            int x1 = pairedCoord[x - 1][0];
            int y1 = pairedCoord[x - 1][1];
            int x2 = pairedCoord[x - 2][0];
            int y2 = pairedCoord[x - 2][1];
            if (x1 == x2 || y1 == y2 || (Math.abs(x1 - y1) == Math.abs(x2 - y2))) {
                result = "INCORRECT";
                break;
            }
        }

        System.out.println(result);
    }
}