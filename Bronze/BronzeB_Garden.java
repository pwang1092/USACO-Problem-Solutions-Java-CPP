import java.util.*;
import java.lang.*;

public class BronzeB_Garden {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int gardenlength = input.nextInt();
        int numCommands = input.nextInt();
        int[][] array = new int[numCommands][2];
        for (int i = 0; i < numCommands; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0)
                    array[i][j] = input.nextInt() - 1;
                else
                    array[i][j] = input.nextInt();
            }
        }

        boolean[] garden = new boolean[gardenlength];
        for (int i = 0; i < gardenlength; i++) {
            garden[i] = false;
        }
        int count = 0;
        for (int i = 0; i < numCommands; i++) {
            count = array[i][0];
            garden[count] = true;
            while (true) {
                count += array[i][1];
                if (count >= gardenlength) {
                    break;
                }
                garden[count] = true;
            }
        }

        int solution = 0;
        for (int i = 0; i < gardenlength; i++) {
            if (garden[i] == false) {
                solution++;
            }
        }
        System.out.print(solution);
    }
}


