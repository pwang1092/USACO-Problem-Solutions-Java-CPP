import java.util.*;
import java.lang.*;

public class BronzeB_Brodovi {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = input.nextInt();
        }

        /** interval array to hold intervals. Subtract those that are divisible by any other */
        ArrayList<Integer> intervalArray = new ArrayList<>();
        int interval;
        //first run. get first interval.
        int counter = 1;
        interval = array[1] - 1;
        intervalArray.add(interval);

        /** starting at the third day, second interval. */
        boolean newInterval = true;
        for (int i = 2; i < num; i++) {
            interval = array[i] - 1;
            /** scan through intervalArray to see if it is divisible by any other. */
            for (int j = 0; j < intervalArray.size(); j++) {
                if (interval % intervalArray.get(j) == 0) {
                    newInterval = false;
                    break;
                }
            }
            if (newInterval) { //add interval if it is not a multiple and increment counter
                intervalArray.add(interval);
                counter++;
            }

            newInterval = true; // reset newInterval boolean
        }
        System.out.print(counter);
    }
}
