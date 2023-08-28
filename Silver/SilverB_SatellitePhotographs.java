import java.util.*;
import java.lang.*;

public class SilverB_SatellitePhotographs {
    public static void main(String[] args) {
        /** scan input */
        Scanner input = new Scanner(System.in);
        int column = input.nextInt();
        int row = input.nextInt();
        char[][] field = new char[row][column];
        // make a field matrix
        String temp;
        for (int i = 0; i < row; i++) {
            temp = input.next();
            for (int j = 0; j < column; j++) {
                field[i][j] = temp.charAt(j);
            }
        }

        /** dfs at every starting asterik */
        int max = 0;
        int[] ans = new int[1];
        int[] di = new int[]{-1, 0, 1, 0};
        int[] dj = new int[]{0, 1, 0, -1};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (field[i][j] == '*') {
                    field[i][j] = '.'; // can erase after we have gone over it
                    dfs(field, i, j, di, dj, ans);
                    max = Math.max(max, ans[0]);
                    ans[0] = 0;
                }
            }
        }
        System.out.print(max + 1); // add one to count the starting one
    }

    public static void dfs(char[][] field, int row, int column, int[] di, int[] dj, int[] ans) {
        int r; int c;
        for (int k = 0; k < 4; k++) {
            r = row + di[k];
            c = column + dj[k]; // test all positions
            /** if in bounds and neighbor is an asterik,
             * change to a period, add to solutions,
             * and go to next position */
            if (r >=0 && r < field.length && c >=0 && c < field[0].length && field[r][c] == '*') {
                field[r][c] = '.';
                ans[0]++;
                dfs(field, r, c, di, dj, ans);
            }
        }
    }
}

/**
 for (int i = 0; i < row; i++) {
 for (int j = 0; j < column; j++) {
 System.out.print(field[i][j]);
 }
 System.out.println();
 }
 */