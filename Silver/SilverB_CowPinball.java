import java.util.Scanner;

public class SilverB_CowPinball {
    public static void main(String[] args) {
        /** scan input */
        Scanner input = new Scanner(System.in);
        int numRows = input.nextInt();
        int[][] array = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                array[i][j] = input.nextInt();
            }
            for (int j = i+1; j < numRows; j++) {
                array[i][j] = -1;
            }
        }

        int[] max = new int[1];
        int total = array[0][0];
        dfs(array, 0, 0, total, max);
        System.out.print(max[0]);
    }

    public static void dfs(int[][] array, int i, int j, int total, int[] max) {
        if (i == array.length - 1) {
            max[0] = Math.max(total, max[0]);
            return;
        }

        if (i+1 < array.length) {
            dfs(array, i + 1, j, total + array[i + 1][j], max);
            dfs(array, i + 1, j + 1, total + array[i + 1][j + 1], max);
        }
    }
}

/**
 for(int i = 0; i < numRows; i++) {
 for (int j = 0; j < numRows; j++) {
 System.out.print(array[i][j] + " ");
 }
 System.out.println();
 }
 */