import java.util.*;
import java.lang.*;

public class BronzeB_OhTheseRollers {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int numRollers = input.nextInt();
        int[][] array = new int[numRollers][3];
        for (int i = 0; i < numRollers; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = input.nextInt();
            }
        }

        int currentWheel = 0;
        boolean[] isUsed = new boolean[numRollers];
        /** find start wheel */
        for (int i = 0; i < numRollers; i++) {
            if (array[i][0] == 0 && array[i][1] == 0) {
                currentWheel = i;
                isUsed[i] = true;
            }
        }

        for (int i = 0; i < numRollers; i++) {
            for (int j = 0; j < numRollers; j++) {
                if (isUsed[j] == false) {
                    if ( Math.pow(array[j][0] - array[currentWheel][0], 2) + Math.pow(array[j][1] - array[currentWheel][1], 2) == Math.pow(array[j][2] + array[currentWheel][2], 2)) {
                        currentWheel = j;
                        isUsed[j] = true;
                    }
                }
            }
        }

        System.out.print(array[currentWheel][0] + " " + array[currentWheel][1]);
    }
}
