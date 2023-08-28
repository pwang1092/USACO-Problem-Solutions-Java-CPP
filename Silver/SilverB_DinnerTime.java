import java.util.*;
import java.lang.*;

public class SilverB_DinnerTime {
    public static void main(String[] args) {
        /** scan input */
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        int numSeats = input.nextInt();
        long[][] cowPos = new long[numCows][2];
        long[][] seatPos = new long[numSeats][2];

        for (int i = 0; i < numCows; i++) {
            cowPos[i][0] = input.nextInt();
            cowPos[i][1] = input.nextInt();
        }
        for (int i = 0; i < numSeats; i++) {
            seatPos[i][0] = input.nextInt();
            seatPos[i][1] = input.nextInt();
        }


        long d;
        int pos = 0;
        long minD;
        boolean[] cowMarked = new boolean[numCows];
        for (int i = 0; i < numSeats; i++) { // each seat
            minD = Long.MAX_VALUE;
            for (int j = 0; j < numCows; j++) {
                if (!cowMarked[j]) {
                    d = (seatPos[i][0]-cowPos[j][0])*(seatPos[i][0]-cowPos[j][0]) + (seatPos[i][1]-cowPos[j][1])*(seatPos[i][1]-cowPos[j][1]);
                    if (d < minD) {
                        minD = d;
                        pos = j;
                    }
                }
            }
            cowMarked[pos] = true;
        }

        boolean printed = false;
        for (int i = 0; i < cowMarked.length; i++) {
            if (!cowMarked[i]) {
                printed = true;
                System.out.println(i + 1);
            }
        }
        if (!printed) {
            System.out.print(0);
        }
    }
}

/**
 for (int i = 0; i < numCows; i++) {
 System.out.println(cowPos[i][0] + " " + cowPos[i][1]);
 }
 for (int i = 0; i < numSeats; i++) {
 System.out.println(seatPos[i][0] + " " + seatPos[i][1]);
 }
 */