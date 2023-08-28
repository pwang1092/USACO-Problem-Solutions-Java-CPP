import java.util.Scanner;

 public class SilverB_TreasureCave {
     int[] left;
     int[] right;
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         int numPassages = input.nextInt();
         int numSplits = input.nextInt();
         int treasureLocation = input.nextInt();

         int index;
         int[] left = new int[numPassages + 1];
         int[] right = new int[numPassages + 1];
         for (int i = 0; i < numSplits; i++) {
             index = input.nextInt();
             left[index] = input.nextInt();
             right[index] = input.nextInt();
         }

         int[] path = new int[numPassages];
         dfs(path, left, right, 1, 1, treasureLocation, false);
     }

     public static void dfs(int[] path, int[] left, int[] right, int edge, int length, int t, boolean done) {
         if (edge == 0 || done) {
             return;
         }
         path[length] = edge;
         if (edge == t) {
             System.out.println(length);
             for (int i = 1; i <= length; i++) {
                 System.out.println(path[i]);
             }
             done = true;
         }
         if (edge < left.length) {
             dfs(path, left, right, left[edge], length + 1, t, done);
             dfs(path, left, right, right[edge], length + 1, t, done);
         }
     }
 }


