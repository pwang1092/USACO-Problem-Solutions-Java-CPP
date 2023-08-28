import java.util.*;
import java.lang.*;

public class BronzeB_AngryCows {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int numBales = input.nextInt();
        int[] array = new int[numBales];
        for (int i = 0; i < numBales; i++) {
            array[i] = input.nextInt();
        }

        Arrays.sort(array);

        int center;
        int radius;
        int centerR;
        int centerL;
        int targetR;
        int targetL;
        int maxExploded = 0;
        int counter = 0;
        boolean expR;
        boolean expL;
        for (int i = 0; i < numBales; i++) {
            center = i;
            counter++;
            radius = 1;
            centerL = center;
            centerR = center;
            targetR = center + 1;
            targetL = center - 1;

            while(true) {
                expR = false;
                expL = false;
                while (targetR < numBales && (array[centerR] + radius>= array[targetR])) {
                    expR = true;
                    counter++;
                    targetR++; 
                }
                while (targetL > -1 && (array[centerL] - radius <= array[targetL])) {
                    expL = true;
                    counter++;
                    targetL--;
                }

                if (!expR && !expL) {
                    break;
                }
                if (expR) {
                    centerR = targetR - 1;
                }
                if (expL) {
                    centerL = targetL + 1;
                }
                radius++;
            }
            maxExploded = max(counter, maxExploded);
            counter = 0;
        }
        System.out.print(maxExploded);
    }

    public static int max(int one, int two) {
        if (one > two) {
            return one;
        }
        return two;
    }
}
