package com.company;

import java.util.Scanner;

public class Queens {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String input = "1\n" +
//                "0 0";
//        Scanner sc = new Scanner(input);

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

        if (boardSize == 2) {
            result = "INCORRECT";
            System.out.println(result);
            System.exit(0);
        }

        for (int m = pairedCoord.length; m >= 2; m--) {
            int x1 = pairedCoord[m - 1][0];
            int y1 = pairedCoord[m - 1][1];
            for (int p = m - 2; p > 0; p--) {
                int x2 = pairedCoord[p][0];
                int y2 = pairedCoord[p][1];
                if (x1 == x2 || y1 == y2) {
                    result = "INCORRECT";
                    break;
                } else if ((x1 < x2 && y1 < y2) || (x1 > x2 && y1 > y2)) {
                    if (x1-y1 == x2-y2){
                        result = "INCORRECT";
                        break;
                    }
                } else if ((x1 < x2 && y1 > y2) || (x1 > x2 && y1 < y2)) {
                    if (x1+y1 == x2+y2) {
                        result = "INCORRECT";
                        break;
                    }

                }
            }
            if (result.equals("INCORRECT")) {
                break;
            }
        }

        System.out.println(result);
    }
}