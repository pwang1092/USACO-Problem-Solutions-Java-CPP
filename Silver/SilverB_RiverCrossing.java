import java.util.*;

public class SilverB_RiverCrossing {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        int numFerries = input.nextInt();
        int ferrySize = input.nextInt();

        int[] cowWakeTime = new int[numCows];
        for (int i = 0; i < numCows; i++) {
            cowWakeTime[i] = input.nextInt();
        }

        Arrays.sort(cowWakeTime);

        int max = cowWakeTime[numCows-1];
        int min = 0;
        int mid;
        while (min < max) {
            mid = (min + max)/2;
            if (isOK(cowWakeTime, mid, numFerries, ferrySize)) {
                max = mid;
            }
            else {
                min = mid+1;
            }
        }

        System.out.print(min);
    }

    public static boolean isOK(int[] cowWakeTime, int limit, int numFerries, int capacity) {
        int first = 0;
        int last;

        for (int i = 0; i < numFerries; i++) {
            if (first + capacity-1 >= cowWakeTime.length) {
                return true;
            }
            if (cowWakeTime[first + capacity - 1] - cowWakeTime[first] <= limit) {
                last = first + capacity - 1;
            } else {
                last = first + capacity - 1;
                while (cowWakeTime[last] > cowWakeTime[first] + limit) {
                    last--;
                }
            }
            first = last + 1;
            if (first >= cowWakeTime.length) {
                return true;
            }
        }
        if (first>= cowWakeTime.length) {
            return true;
        }
        return false;
    }
}

/**
 for (int i = 0; i < matrix.length; i++) {
 for (int j = 0; j < matrix.length; j++) {
 System.out.print(matrix[i][j]);
 }
 System.out.println();
 }
 */