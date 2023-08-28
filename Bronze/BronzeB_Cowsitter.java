import java.util.*;
import java.lang.*;

public class BronzeB_Cowsitter {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int numSitter = input.nextInt();
        int[][] array = new int[numSitter][2];
        for (int i = 0; i < numSitter; i++) {
            array[i][0] = input.nextInt();
            array[i][1] = input.nextInt();
        }

        int[] timeLine = new int[1001];
        int maxTime = 0;
        int time = 0;
        int counter = 0;
        for (int i = 0; i < numSitter; i++) { // choose one to fire
            for (int j = 0; j < numSitter; j++) {
                if (j == i) {
                    continue;
                }
                timeLine[array[j][0]] = 1;
                timeLine[array[j][1]] = -1;
            }
            for (int k = 0; k <= 1000; k++) {
                if (timeLine[k] == 1) {
                    counter++;
                } else if (timeLine[k] == -1) {
                    counter--;
                }
                if (counter >= 1) {
                    time++;
                }
            }
            maxTime = Math.max(maxTime, time);
            time = 0;
            /** reset timeline */
            for (int m = 0; m <= 1000; m++) {
                timeLine[m] = 0;
            }
        }
        System.out.print(maxTime);
    }
}


