import java.util.Scanner;
import java.util.*;

 public class SilverB_CrossRoad {
     public static void main(String[] args) {
         /** scan numChickens, numCows */
         Scanner input = new Scanner(System.in);
         int numChickens = input.nextInt();
         int numCows = input.nextInt();

         /** get array of chickens */
         int[] chickens = new int[numChickens];
         for (int i = 0; i < numChickens; i++) {
             chickens[i] = input.nextInt();
         }
         /** get array of cows using interval class */
         cowInterval[] cows = new cowInterval[numCows];
         for (int i = 0; i < numCows; i++) {
             cows[i] = new cowInterval(input.nextInt(), input.nextInt());
         }

         /** sort the arrays */
         Arrays.sort(chickens);
         Arrays.sort(cows, new sortByRight());

         boolean[] marked = new boolean[numCows];
         int count = 0;
         for (int i = 0; i < numChickens; i++) {
             for (int j = 0; j < numCows; j++) {
                 if (!marked[j] && chickens[i] >= cows[j].left && chickens[i] <= cows[j].right) {
                     marked[j] = true;
                     count++;
                     break;
                 }
             }
         }

         System.out.print(count);
     }

     static class sortByRight implements Comparator<cowInterval> {
         public int compare(cowInterval one, cowInterval two) {
             if (one.right > two.right) {
                 return 1;
             }
             return -1;
         }
     }
 }

 /** interval class has left point and a right point */
class cowInterval {
     public int left;
     public int right;

     public cowInterval(int left, int right) {
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