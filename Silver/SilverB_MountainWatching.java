import java.util.Scanner;
import java.util.*;

 public class SilverB_MountainWatching {
     public static void main(String[] args) {
         /** scan numChickens, numCows */
         Scanner input = new Scanner(System.in);
         int numHeights = input.nextInt();
         int[] heights = new int[numHeights];
         for (int i = 0; i < numHeights; i++) {
             heights[i] = input.nextInt();
         }

         boolean climb = false;
         int max = check(heights, 0);
         for (int i = 0; i < numHeights - 1; i++) {
            if (heights[i+1] > heights[i]) {
                climb = true;
            }
            else if (heights[i+1] < heights[i] && climb == true) {
                max = Math.max(check(heights, i), max);
                climb = false;
            }
         }
         max = Math.max(check(heights, heights.length - 1), max);
         System.out.print(max);
     }

     /** scan to the left and right until increasing starts */
     public static int check(int[] heights, int pos) {
         int right = pos;
         int left = pos;
         for (int i = pos; i < heights.length-1; i++) {
             if (heights[i+1] > heights[i]) {
                 right = i;
                 break;
             }
             if (i+1 == heights.length - 1 && heights[i+1] <= heights[i]) {
                 right = heights.length - 1;
             }
         }
         for (int i = pos; i > 0; i--) {
             if (heights[i-1] > heights[i]) {
                 left = i;
                 break;
             }
             if (i - 1 == 0 && heights[i-1] <= heights[i]) {
                 left = i-1;
             }
         }
         return right - left + 1;
     }
}

/**
 for (int i = 0; i < numHeights; i++) {
 System.out.println(heights[i]);
 }
 */