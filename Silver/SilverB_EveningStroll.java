import java.util.Scanner;

 public class SilverB_EveningStroll {
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         int rows = input.nextInt();
         int columns = input.nextInt();
         char[][] field = new char[rows][columns];

         boolean firstFound = false;
         int i1 = 0; int j1 = 0;
         int i2 = 0; int j2 = 0;
         String line;
         for (int i = 0; i < rows; i++) {
             for (int j = 0; j < columns; j++) {
                 field[i][j] = input.next().charAt(0);
                 if (field[i][j] == 'B' && !firstFound) {
                     i1 = i; j1 = j;
                     firstFound = true;
                 }
                 else if (field[i][j] == 'B' && firstFound) {
                     i2 = i; j2 = j;
                 }
             }
             line = input.nextLine();
         }

         int[] ans = new int[1];
         dfs(field, i1, j1, i2, j2, ans);
         System.out.print(ans[0]);
     }

     public static void dfs(char[][] field, int i1, int j1, int i2, int j2, int[] ans) {
         if (i1 == i2 && j1 == j2) {
             ans[0]++;
             return;
         }

         if (i1 + 1 <= i2) {
             if (field[i1+1][j1] != 'R') {
                 dfs(field, i1 + 1, j1, i2, j2, ans);
             }
         }

         if (j1 + 1 <= j2) {
             if (field[i1][j1+1] != 'R') {
                 dfs(field, i1, j1 + 1, i2, j2, ans);
             }
         }

     }
 }

/**
 for (int i = 0; i < rows; i++) {
 for (int j = 0; j < columns; j++) {
 System.out.print(field[i][j] + " ");
 }
 System.out.println();
 }
 */
