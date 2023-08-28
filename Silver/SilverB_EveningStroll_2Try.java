import java.util.Scanner;

 public class SilverB_EveningStroll_2Try {
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         int rows = input.nextInt();
         int columns = input.nextInt();
         int[][] field = new int[rows][columns];

         boolean firstFound = false;
         int i1 = 0; int j1 = 0;
         int i2 = 0; int j2 = 0;
         char temp;
         String line;
         for (int i = 0; i < rows; i++) {
             for (int j = 0; j < columns; j++) {
                 temp = input.next().charAt(0);
                 if (temp == 'B' && !firstFound) {
                     i1 = i; j1 = j;
                     firstFound = true;
                 }
                 else if (temp == 'B' && firstFound) {
                     i2 = i; j2 = j;
                 }
                 else if (temp == 'R') {
                     field[i][j] = -1;
                 }
             }
             line = input.nextLine();
         }

         /** fill in the left side and top side of field with 1's where no rock */
         boolean rockFound = false;
         for (int i = i1; i <= i2; i++) {
             if (field[i][j1] == -1) {
                 rockFound = true;
                 continue;
             }
             if (field[i][j1] != -1 && !rockFound) {
                 field[i][j1] = 1;
             }
         }
         rockFound = false;
         for (int j = j1; j <= j2; j++) {
             if (field[i1][j] == -1) {
                 rockFound = true;
                 continue;
             }
             if (field[i1][j] != -1 && !rockFound) {
                 field[i1][j] = 1;
             }
         }

         /** fill in the rest */
         for (int i = i1 + 1; i <= i2; i++) {
             for (int j = j1 + 1; j <= j2; j++) {
                 if (field[i][j] != -1) {
                     if (field[i - 1][j] != -1 && field[i][j - 1] != -1) {
                         field[i][j] = field[i - 1][j] + field[i][j - 1];
                     }
                     else if (field[i - 1][j] == -1 && field[i][j - 1] == -1) {
                         field[i][j] = 0;
                     }
                     else if (field[i - 1][j] != -1) {
                         field[i][j] = field[i - 1][j];
                     }
                     else if (field[i][j - 1] != -1) {
                         field[i][j] = field[i][j - 1];
                     }
                 }
             }
         }
         System.out.print(field[i2][j2]);
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
