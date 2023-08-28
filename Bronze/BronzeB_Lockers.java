import java.util.*;
import java.lang.*;

public class BronzeB_Lockers {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        int[][] array = new int[numCows][3];
        for (int i = 0; i < numCows; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = input.nextInt();
            }
        }

        int[] arrayTime = new int[1000];
        for (int i = 0; i < numCows; i++) {
            arrayTime[array[i][0]] = array[i][2];
            arrayTime[array[i][1]] = -array[i][2];
        }

        int maximum = 0;
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += arrayTime[i];
            if (sum > maximum) {
                maximum = sum;
            }
        }

        System.out.print(maximum);
    }
}


