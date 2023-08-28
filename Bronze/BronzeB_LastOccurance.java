import java.util.*;
import java.lang.*;

public class BronzeB_LastOccurance {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int numQueries = input.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = input.nextInt();
        }
        int[] queries = new int[numQueries];
        for (int i = 0; i < numQueries; i++) {
            queries[i] = input.nextInt();
        }

        for (int i = 0; i < numQueries; i++) {
            System.out.println(modifiedUpperBound(array, queries[i]));
        }
    }

    public static int modifiedUpperBound(int[] array, int query) {
        int low = 0;
        int high = array.length;
        int mid;
        while (low < high) {
            mid = (low + high)/2;
            if (query < array[mid]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        if (array[low - 1] == query) {
            return low - 1;
        }
        return -1;
    }
}


