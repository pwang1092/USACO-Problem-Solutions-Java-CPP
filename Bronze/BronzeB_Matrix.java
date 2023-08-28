import java.util.*;
import java.lang.*;

public class BronzeB_Matrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        // odd start point
        int Asum;
        int Bsum;
        int exp = 0;
        int maxBeauty = 0;
        int beauty;
        // odd center
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                Asum = matrix[r][c]; Bsum = matrix[r][c];
                exp = 1;
                while ( inLimit(size, exp, r, c) ) {
                    Asum += matrix[r+exp][c+exp] + matrix[r-exp][c-exp];
                    Bsum += matrix[r+exp][c-exp] + matrix[r-exp][c+exp];
                    beauty = Asum - Bsum;
                    maxBeauty = Math.max(maxBeauty, beauty);
                    exp++;
                }
            }
        }
        //even center
        for (int r = 0; r < size - 1; r++) { // reference the square by top left corner
            for (int c = 0; c < size - 1; c++) { // same reasoning
                Asum = 0; Bsum = 0;
                exp = 0;
                while (true) {
                    if (r+exp+1 >= size || c+exp+1 >= size || r-exp < 0 || c-exp < 0) {
                        break;
                    }
                    Asum += matrix[r+exp+1][c+exp+1] + matrix[r-exp][c-exp];
                    Bsum += matrix[r+exp+1][c-exp] + matrix[r-exp][c+exp+1];
                    beauty = Asum - Bsum;
                    maxBeauty = Math.max(maxBeauty, beauty);
                    exp++;
                }
            }
        }
        System.out.print(maxBeauty);
    }

    public static boolean inLimit(int size, int expand, int row, int column) {
        if ( row+expand < size && row-expand >= 0 && column+expand < size && column-expand >= 0) {
            return true;
        }
        return false;
    }
}


