import java.util.*;
import java.lang.*;

public class SilverB_Reflections {
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

        int[] ans = new int[1];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            search(matrix, i, 0, 'R', ans);
            max = Math.max(max, ans[0]);
            ans[0] = 0;
        }
        for (int i = 0; i < rows; i++) {
            search(matrix, i, columns-1, 'L', ans);
            max = Math.max(max, ans[0]);
            ans[0] = 0;
        }
        for (int j = 0; j < columns; j++) {
            search(matrix, 0, j, 'D', ans);
            max = Math.max(max, ans[0]);
            ans[0] = 0;
        }
        for (int j = 0; j < columns; j++) {
            search(matrix, rows-1, j, 'U', ans);
            max = Math.max(max, ans[0]);
            ans[0] = 0;
        }

        System.out.print(max);
    }

    public static void search(char[][] matrix, int row, int column, char direction, int[] ans) {
        int newRow; int newColumn;
        while(row >= 0 && row < matrix.length && column >=0 && column < matrix[0].length) {
            /** forward slash */
            if (matrix[row][column] == '/') {
                if (direction == 'R') {
                    newRow = row - 1;
                    newColumn = column;
                    direction = 'U';
                }
                else if (direction == 'D') {
                    newRow = row;
                    newColumn = column - 1;
                    direction = 'L';
                }
                else if (direction == 'L') {
                    newRow = row + 1;
                    newColumn = column;
                    direction = 'D';
                }
                else {
                    newRow = row;
                    newColumn = column + 1;
                    direction = 'R';
                }
            }
            /** if backslash */
            else {
                if (direction == 'R') {
                    newRow = row + 1;
                    newColumn = column;
                    direction = 'D';
                }
                else if (direction == 'D') {
                    newRow = row;
                    newColumn = column + 1;
                    direction = 'R';
                }
                else if (direction == 'L') {
                    newRow = row - 1;
                    newColumn = column;
                    direction = 'U';
                }
                else {
                    newRow = row;
                    newColumn = column - 1;
                    direction = 'L';
                }
            }

            /** update row, column, and direction */
            row = newRow;
            column = newColumn;
            ans[0]++;
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