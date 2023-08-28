import java.util.*;
import java.lang.*;

public class BronzeB_Binarysearch {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int numQueries = input.nextInt();
        int[] array = new int[num];
        int[] arrayQueries = new int[numQueries];
        for (int i = 0; i < num; i++) {
            array[i] = input.nextInt();
        }
        for (int i = 0; i < numQueries; i++) {
            arrayQueries[i] = input.nextInt();
        }

        if (num == 0) {
            for (int i = 0; i < numQueries; i++) {
                System.out.println("-1");
            }
            System.exit(0);
        }

        //print queries
        for (int i = 0; i < numQueries; i++) {
            if ( array[lowerBound(array, arrayQueries[i])] == arrayQueries[i]) {
                System.out.println(lowerBound(array, arrayQueries[i]));
            }
            else
                System.out.println(-1);
        }
    }

    public static int lowerBound(int[] array, int num) {
        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low < high) {
            mid = (low + high)/2;
            if (num <= array[mid]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}


