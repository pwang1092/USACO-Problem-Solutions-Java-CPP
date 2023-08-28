import java.util.*;
import java.lang.*;

public class SilverB_DiscoParty {
    public static void main(String[] args) {
        /** scan input */
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        int columns = input.nextInt();
        char[][] matrix = new char[rows][columns];

        String temp;
        for (int i = 0; i < rows; i++) {
            temp = input.next();
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = temp.charAt(j);
            }
        }

        /** pass coordinates for top left corner, matrix, and array to hold answer */
        int[] ans = new int[1];
        dfs(0, 0, matrix, ans);
        System.out.print(ans[0]);
    }

    public static void dfs(int row, int column, char[][] matrix, int[] ans) {
        /** return if bottom row or right column reached */
        /** increment answer if bottom right corner reached */
        if (row == matrix.length-1 && column == matrix[0].length-1) {
            ans[0]++;
            return;
        }
        if (row == matrix.length-1 || column == matrix[0].length-1) {
            return;
        }
        /** check all cells below row and to the right of column */
        for (int i = row+1; i < matrix.length; i++) {
            for (int j = column+1; j < matrix[0].length; j++) {
                /** Condition: different color */
                if (matrix[row][column] != matrix[i][j]) {
                    dfs(i, j, matrix, ans);
                }
            }
        }
    }
}

/**
 for (int i = 0; i < rows; i++) {
 for (int j = 0; j < columns; j++) {
 System.out.print(matrix[i][j]);
 }
 System.out.println();
 }
 */