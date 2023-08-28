import java.util.*;
import java.lang.*;

public class SilverB_GrazingPatterns {
    public static void main(String[] args) {
        /** scan input */
        Scanner input = new Scanner(System.in);
        int numBare = input.nextInt();
        int[][] bareArray = new int[numBare][2];
        int[][] matrix = new int[5][5];
        for (int i = 0; i < numBare; i++) {
            bareArray[i][0] = input.nextInt() - 1;
            bareArray[i][1] = input.nextInt() - 1;
            matrix[bareArray[i][0]][bareArray[i][1]] = -1; // plots with no grass have value of -1
        }

        int pathLength = (25-numBare-1); // total pathLength doesn't count beginning square
        boolean[][] visited = new boolean[5][5];
        int[] ans = new int[1];
        visited[0][0] = true;
        matrixSearch(matrix, 0, 0, 0, pathLength, ans, visited);
        System.out.print(ans[0]);
    }
    public static void matrixSearch(int[][] matrix, int posX, int posY, int pathLength, int totalPathLength, int[] ans, boolean[][] visited) {
        /** if we reach lower corner and covered all grassy squares, iterate counter */
        if (posX == 4 && posY == 4) {
            if (pathLength == totalPathLength) {
                ans[0]++;
            }
            return;
        }

        /** for each direction:
         * 1. check bounds
         * 2. check if plot is grassy
         * 3. check if it has been visited
         * If yes, go in direction. Mark as visited and un-mark after return.
         */

        if (posX + 1 < 5 && matrix[posX + 1][posY] != -1 && !visited[posX + 1][posY]) {
            visited[posX + 1][posY] = true;
            matrixSearch(matrix, posX + 1, posY, pathLength+1, totalPathLength, ans, visited);
            visited[posX + 1][posY] = false;
        }
        if (posY + 1 < 5 && matrix[posX][posY + 1] != -1 && !visited[posX][posY + 1]) {
            visited[posX][posY + 1] = true;
            matrixSearch(matrix, posX, posY + 1, pathLength+1, totalPathLength, ans, visited);
            visited[posX][posY + 1] = false;
        }
        if (posX - 1 >= 0 && matrix[posX - 1][posY] != -1 && !visited[posX - 1][posY]) {
            visited[posX - 1][posY] = true;
            matrixSearch(matrix, posX - 1, posY, pathLength+1, totalPathLength, ans, visited);
            visited[posX - 1][posY] = false;
        }
        if (posY - 1 >= 0 && matrix[posX][posY - 1] != -1 && !visited[posX][posY - 1]) {
            visited[posX][posY - 1] = true;
            matrixSearch(matrix, posX, posY - 1, pathLength+1, totalPathLength, ans, visited);
            visited[posX][posY - 1] = false;
        }
    }
}

/**
 for (int i = 0; i < 5; i++) {
 for (int j = 0; j < 5; j++) {
 System.out.print(field[i][j]);
 }
 System.out.println();
 }
 */