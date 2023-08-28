import java.util.*;
import java.lang.*;

public class BronzeB_Hoofpaperscissors {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int numGames = input.nextInt();
        int[][] array = new int[numGames][2];
        for (int i = 0; i < numGames; i++) {
            for (int j = 0; j < 2; j++) {
                array[i][j] = input.nextInt();
            }
        }

        int game1 = 0;
        for (int i = 0; i < numGames; i++) {
            if (array[i][0] == 1 && array[i][1] == 2) {
                game1++;
            }
            else if (array[i][0] == 2 && array[i][1] == 3) {
                game1++;
            }
            else if (array[i][0] == 3 && array[i][1] == 1) {
                game1++;
            }
        }

        int game2 = 0;
        for (int i = 0; i < numGames; i++) {
            if (array[i][0] == 1 && array[i][1] == 3) {
                game2++;
            }
            else if (array[i][0] == 3 && array[i][1] == 2) {
                game2++;
            }
            else if (array[i][0] == 2 && array[i][1] == 1) {
                game2++;
            }
        }

        if (game1 > game2) {
            System.out.print(game1);
        }
        else
            System.out.print(game2);
    }
}


