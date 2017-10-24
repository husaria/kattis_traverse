import java.util.Scanner;

public class EightQueens {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        String input = "********\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........";
        Scanner sc = new Scanner(input);

        final int boardSize = 8;
        String[] boardArray = new String[boardSize];

        int n = 0;
        while (sc.hasNext()) {
            boardArray[n] = sc.next();
            n++;
        }

        int[][] pairedCoordinates = new int[boardSize][];

        int i = 0;
        for (int y = boardSize - 1; y >= 0; y--) {
            String[] line = boardArray[i].split("");
            for (int x = 0; x < boardSize - 1; x++) {
                int[] tempPairOfSingleCoordinates = new int[2];
                if (line[x].equals("*")) {
                    tempPairOfSingleCoordinates[0] = x;
                    tempPairOfSingleCoordinates[1] = y;
                    pairedCoordinates[i] = tempPairOfSingleCoordinates;
                    i++;
                }
            }


        }


        String result = "valid";

        for (int m = pairedCoordinates.length; m >= 2; m--) {
            int x1 = pairedCoordinates[m - 1][0];
            int y1 = pairedCoordinates[m - 1][1];
            for (int p = m - 2; p > 0; p--) {
                int x2 = pairedCoordinates[p][0];
                int y2 = pairedCoordinates[p][1];
                if (x1 == x2 || y1 == y2) {
                    result = "invalid";
                    break;
                } else if ((x1 < x2 && y1 < y2) || (x1 > x2 && y1 > y2)) {
                    if (x1 - y1 == x2 - y2) {
                        result = "invalid";
                        break;
                    }
                } else if ((x1 < x2 && y1 > y2) || (x1 > x2 && y1 < y2)) {
                    if (x1 + y1 == x2 + y2) {
                        result = "invalid";
                        break;
                    }

                }
            }
            if (result.equals("invalid")) {
                break;
            }
        }

        System.out.println(result);
    }
}
