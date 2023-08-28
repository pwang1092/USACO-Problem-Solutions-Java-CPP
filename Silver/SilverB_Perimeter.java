import java.util.*;
import java.lang.*;

public class SilverB_Perimeter {
    public static void main(String[] args) {
        /** scan input */
        Scanner input = new Scanner(System.in);
        int numBales = input.nextInt();
        int[][] bales = new int[numBales][2];
        int minX = 101;
        int maxX = 0;
        int minY = 101;
        int maxY = 0;
        for (int i = 0; i < numBales; i++) {
            bales[i][0] = input.nextInt();
            if (bales[i][0] < minX) {
                minX = bales[i][0];
            }
            if (bales[i][0] > maxX) {
                maxX = bales[i][0];
            }
            bales[i][1] = input.nextInt();
            if (bales[i][1] > maxY) {
                maxY = bales[i][1];
            }
            if (bales[i][1] < minY) {
                minY = bales[i][1];

            }
        }

        // surround with 0s by adding one to bale position input.
        int[][] field = new int[maxX-minX+3][maxY-minY+3];
        for (int i = 0; i < numBales; i++) {
            field[bales[i][0]-minX+1][bales[i][1]-minY+1] = 1;
        }

        int[] di = new int[]{1, 0, -1, 0};
        int[] dj = new int[]{0, 1, 0, -1};
        boolean[][] visited = new boolean[102][102]; visited[0][0] = true;
        int[] ans = new int[1];
        dps(field, 0, 0, di, dj, visited, ans);

        System.out.print(ans[0]);
    }

    public static void dps(int[][] field, int row, int column, int[] di, int[] dj, boolean[][] visited, int[] ans) {
        if (field[row][column] == 1) {
            ans[0]++;
            return;
        }

        visited[row][column] = true;
        int r; int c;
        for (int k = 0; k < 4; k++) {
            r = row + di[k];
            c = column + dj[k];
            if (r < field.length && r >=0 && c < field[0].length && c >=0 && !visited[r][c]) {
                dps(field, r, c, di, dj, visited, ans);
            }
        }
    }
}

/**
 for (int i = 0; i < 102; i++) {
 for (int j = 0; j < 102; j++) {
 System.out.print(field[i][j]);
 }
 System.out.println();
 }
 */