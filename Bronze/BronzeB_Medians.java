import java.util.*;
import java.lang.*;

public class BronzeB_Medians {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[][] grid = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = input.nextInt();
            }
        }

        int[] holder = new int[size];
        int[] firstMedian = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                holder[j] = grid[i][j];
            }
            Arrays.sort(holder);
            firstMedian[i] = holder[size/2];
        }

        Arrays.sort(firstMedian);
        System.out.print(firstMedian[size/2]);
    }
}
