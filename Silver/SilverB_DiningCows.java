import java.util.*;

public class SilverB_DiningCows {
    public static void main(String[] args) {
        /** 1. scan the temperature productions */
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        int[] array = new int[numCows];

        for (int i = 0; i < numCows; i++) {
            array[i] = input.nextInt();
        }

        int min = numCows;
        int ans = 0;
        /** try every position as the first 2. The indexes before this will have be ones
         * and the ones after will have to be twos. Increment ans accordingly.
         */
        for (int first2 = 0; first2 < numCows; first2++) {
            ans = 0;
            for (int i = 0; i < first2; i++) { // first part fill with 1s
                if (array[i] == 2) {
                    ans++;
                }
            }
            for(int i = first2; i < numCows; i++) { // fills second part with 2s
                if (array[i] == 1) {
                    ans++;
                }
            }
            min = Math.min(min, ans);
        }

        /** try edge case where all are ones, not covered in above */
        ans = 0;
        for (int i = 0; i < numCows; i++) {
            if (array[i] == 2) {
                ans++;
            }
        }
        min = Math.min(ans, min);

        System.out.print(min);
    }
}

/**
 for (int i = 0; i < numCows; i++) {
 System.out.println(array[i]);
 }
 */