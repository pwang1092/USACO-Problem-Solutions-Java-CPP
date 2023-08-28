import java.util.*;
import java.lang.*;

public class SilverB_FireDrill {
    public static void main(String[] args) {
        /** scan input */
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();

        int i = 1; // index 0, 1
        boolean[] moved = new boolean[numCows + 1];
        moved[1] = true;
        int destination;

        while (true) {
            destination = (2*i) % numCows; // circular seating
            if (destination == 0) {        // if statement in special case of the very last cow
                destination = numCows;
            }
            if (moved[destination]) {
                break;
            }
            moved[destination] = true;
            i = destination;
        }
        System.out.print(i);
    }
}

/**
 for (int i = 0; i < numCows; i++) {
 System.out.println(a[i]);
 }
 for (int i = 1; i < numCows + 1; i++) {
 System.out.println(revB[i]);
 }
 */