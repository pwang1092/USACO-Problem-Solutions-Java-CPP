import java.util.*;
import java.lang.*;

public class SilverB_ReoderingCows {
    public static void main(String[] args) {
        /** scan input */
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        int[] a = new int[numCows];
        int[] revB = new int[numCows+1];

        for (int i = 0; i < numCows; i++) {
            a[i] = input.nextInt();
        }

        int temp;
        for (int i = 0; i < numCows; i++) {
            temp = input.nextInt();
            revB[temp] = i; // reverse indexing
        }

        int length;
        int maxLength = 0;
        int numCycle = 0;
        int holder;
        int keep;
        for (int i = 0; i < numCows; i++) {
            length = 0;
            keep = a[i];
            if (revB[keep] != i) {
                numCycle++;
                while(revB[keep] != i) {
                    holder = a[revB[keep]];
                    a[revB[keep]] = keep;
                    keep = holder;
                    length++;
                }
            }
            maxLength = Math.max(maxLength, length);
        }

        System.out.print(numCycle + " ");
        if (maxLength == 0) {
            System.out.print(-1);
            System.exit(0);
        }
        System.out.print(maxLength + 1);
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