import java.util.*;
import java.lang.*;

public class BronzeB_SentientStars {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int numStars = input.nextInt();
        int[] array = new int[numStars];
        for (int i = 0; i < numStars; i++) {
            array[i] = input.nextInt();
        }

        int ans = 0;
        for ( int i = numStars - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                ans = i;
                break;
            }
        }
        System.out.print(ans);
    }
}


