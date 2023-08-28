import java.util.*;
import java.lang.*;

public class BronzeB_Loadbalancing {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        int farmSize = input.nextInt();
        int[][] cowArray = new int[numCows][2];
        for (int i = 0; i < numCows; i++) {
            for (int j = 0; j < 2; j++) {
                cowArray[i][j] = input.nextInt();
            }
        }

        int minMax = 100;
        int fx;
        int fy;
        int[] quadrants = new int[4];
        for (int i = 0; i < numCows; i++) {
            fx = cowArray[i][0] - 1;
            for (int j = 0; j < numCows; j++) {
                fy = cowArray[j][1] - 1;
                //scan cows
                for (int k = 0; k < numCows; k++) {
                    if (cowArray[k][0] > fx && cowArray[k][1] > fy) {
                        quadrants[0]++;
                    }
                    else if (cowArray[k][0] > fx && cowArray[k][1] < fy) {
                        quadrants[1]++;
                    }
                    else if (cowArray[k][0] < fx && cowArray[k][1] > fy) {
                        quadrants[2]++;
                    }
                    else quadrants[3]++;
                }

                if (max(quadrants) < minMax) {
                    minMax = max(quadrants);
                }
                //reset quadrant counter
                for (int x = 0; x < quadrants.length; x++) {
                    quadrants[x] = 0;
                }
            }
        }
        System.out.print(minMax);
    }

    public static int max(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}


