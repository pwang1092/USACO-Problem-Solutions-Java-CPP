import java.util.Scanner;
import java.util.*;

 public class SilverB_SocialDistancing {
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         int numCows = input.nextInt();
         int numIntervals = input.nextInt();

        Interval[] intervals = new Interval[numIntervals];
        for (int i = 0; i < numIntervals; i++) {
            intervals[i] = new Interval(input.nextInt(), input.nextInt());
        }

        Arrays.sort(intervals, new sortByLeft());

        /** binary search the step size and check isOk for each*/
        int left = 1; int right = Integer.MAX_VALUE; int mid;
        while (left < right) {
            mid = (left + right + 1)/2;
            if(isOk(intervals, mid, numCows)) {
                left = mid;
            }
            else {
                right = mid-1;
            }
        }
        System.out.print(left);
     }

     public static boolean isOk(Interval[] intervals, int step, int numCows) {
         /** isOk sets position at leftmost and moves onto next interval if right is surpassed
          * at the end, if numCows reached, the satisfied */
         int counter = 1; int pos = intervals[0].first;
         for (int i = 0; i < intervals.length; i++) {
             while (pos + step <= intervals[i].second) {
                pos = Math.max(pos+step, intervals[i].first);
                counter++;
                if (counter >= numCows)
                    break;
             }
             if (counter >= numCows)
                 return true;
         }
         return false;
     }

     static class sortByLeft implements Comparator<Interval> {
         public int compare(Interval one, Interval two) {
            if (one.first > two.first) {
                return 1;
            }
            return -1;
         }
     }
 }

 class Interval {
     public int first;
     public int second;

     public Interval(int first, int second) {
         this.first = first;
         this.second = second;
     }
 }


/**
 for (Interval n: intervals) {
 System.out.println(n.first + " " + n.second)
 }
 */