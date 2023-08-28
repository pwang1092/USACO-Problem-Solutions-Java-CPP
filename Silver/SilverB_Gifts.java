import java.util.*;

 public class SilverB_Gifts {
     public static void main(String[] args) {
         /** 1. scan the temperature productions */
         Scanner input = new Scanner(System.in);
         int numCows = input.nextInt();
         int budget = input.nextInt();
         Present[] array = new Present[numCows];

         for (int i = 0; i < numCows; i++) {
             array[i] = new Present(input.nextInt(), input.nextInt());
         }

         Arrays.sort(array, new sortByTotal());

         int total;
         int max = 0;
         int keep;
         for (int i = 0; i < numCows; i++) {
             keep = 0;
             total = 0;
             for (int j = 0; j < numCows; j++) {
                 if (j == i) {
                     total += array[j].price / 2 + array[j].shipping;
                 }
                 else {
                     total += array[j].total;
                 }
                 if (total > budget) {
                     keep = j;
                     break;
                 }
             }
             max = Math.max(max, keep);
         }

         System.out.print(max);
     }

     static class sortByTotal implements Comparator<Present> {
         public int compare(Present one, Present two) {
             if (one.total > two.total) {
                 return 1;
             }
             return -1;
         }
     }
}

class Present {
    int price;
    int shipping;
    int total;

    public Present(int price, int shipping) {
        this.price = price;
        this.shipping = shipping;
        total = price + shipping;
    }
}

/**
 for (Present n: array) {
 System.out.println(n.price + " " + n.shipping);
 }
 */