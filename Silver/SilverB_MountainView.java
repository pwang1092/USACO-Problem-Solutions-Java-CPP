import java.util.Scanner;
import java.util.*;

 public class SilverB_MountainView{
     public static void main(String[] args) {
         /** scan numChickens, numCows */
         Scanner input = new Scanner(System.in);
         int numMountains = input.nextInt();
         Range[] intervals = new Range[numMountains];

         int x; int y;
         for (int i = 0; i < numMountains; i++) {
             x = input.nextInt(); y = input.nextInt();
             intervals[i] = new Range(x-y, x+y);
         }

         Arrays.sort(intervals, new sort());

         int count = 1;
         int max = intervals[0].right;
         for (int i = 1; i < numMountains; i++) {
             if (intervals[i].right > max) {
                 max = intervals[i].right;
                 count++;
             }
         }
         System.out.print(count);
     }
     static class sort implements Comparator<Range> {
         public int compare(Range one, Range two) {
            if (one.left > two.left) {
                return 1;
            }
            else if (one.left == two.left && one.right < two.right) {
                return 1;
            }
            return -1;
         }
     }
}

class Range {
     public int left;
     public int right;

     public Range(int left, int right) {
         this.left = left;
         this.right = right;
     }
}

/**
 for (int i = 0; i < numChickens; i++) {
 System.out.println(chickens[i]);
 }
 for (cowInterval n: cows) {
 System.out.println(n.left + " " + n.right);
 }
 */