import java.util.*;
import java.lang.*;

public class BronzeB_MowingField {
    public static void main(String[] args) {
        // receive input
        Scanner input = new Scanner(System.in);
        int numDirections = input.nextInt();
        String[][] directions = new String[numDirections][2];
        for (int i = 0; i < numDirections; i++) {
            directions[i][0] = input.next();
            directions[i][1] = input.next();
        }

        int startX = 1000;
        int startY = 1000;
        int[][] grid = new int[2001][2001];
        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) {
                grid[i][j] = -1;
            }
        }

        int x = 1001;
        int time = 0;
        for (int i = 0; i < numDirections; i++) {
            if (directions[i][0].equals("N")) {
                for (int j = 0; j < Integer.parseInt(directions[i][1]); j++) {
                    grid[startX][startY] = time;
                    startY++;
                    time++;
                    if (grid[startX][startY] > -1) {
                        x = min(x, time - grid[startX][startY]);
                        grid[startX][startY] = time;
                    }
                }
            }
            else if (directions[i][0].equals("E")) {
                for (int j = 0; j < Integer.parseInt(directions[i][1]); j++) {
                    grid[startX][startY] = time;
                    startX++;
                    time++;
                    if (grid[startX][startY] > -1) {
                        x = min(x, time - grid[startX][startY]);
                        grid[startX][startY] = time;
                    }
                }
            }
            else if (directions[i][0].equals("S")) {
                for (int j = 0; j < Integer.parseInt(directions[i][1]); j++) {
                    grid[startX][startY] = time;
                    startY--;
                    time++;
                    if (grid[startX][startY] > -1) {
                        x = min(x, time - grid[startX][startY]);
                        grid[startX][startY] = time;
                    }
                }
            }
            else if (directions[i][0].equals("W")) {
                for (int j = 0; j < Integer.parseInt(directions[i][1]); j++) {
                    grid[startX][startY] = time;
                    startX--;
                    time++;
                    if (grid[startX][startY] > -1) {
                        x = min(x, time - grid[startX][startY]);
                        grid[startX][startY] = time;
                    }
                }
            }
        }

        if (x == 1001) {
            System.out.print(-1);
            System.exit(0);
        }
        System.out.println(x);
    }

    public static int min(int one, int two) {
        if (one < two) {
            return one;
        }
        return two;
    }
}



