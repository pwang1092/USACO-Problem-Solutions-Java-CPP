import java.util.*;

 public class SilverB_Goldilocks {
     public static void main(String[] args) {
         /** 1. scan the temperature productions */
         Scanner input = new Scanner(System.in);
         int numCows = input.nextInt();
         int[] milkProduction = new int[3];
         for (int i = 0; i < 3; i++) {
             milkProduction[i] = input.nextInt();
         }
         /** 2. make points array and sort based on position*/
         point[] points = new point[numCows*2];
         for (int i = 0; i < numCows*2; i+=2) {
             points[i] = new point(input.nextInt(), 1);
             points[i+1] = new point(input.nextInt(), -1);
         }

         Arrays.sort(points, new sortByPos());

         /** 3. scan through all points and calculate milk production
          * if we scan another start point, just right increases, hot decreases
          * if we scan end point, just right decreases and cold increases
          */
         int max = numCows * milkProduction[0];
         int cold = numCows;
         int good = 0;
         int hot = 0;
         for (int i = 0; i < numCows*2; i++) {
             if (points[i].state == 1) {
                 cold--;
                 good++;
             }
             else if (points[i].state == -1) {
                 good--;
                 hot++;
             }
             max = Math.max(max, cold * milkProduction[0] + good * milkProduction[1] + hot * milkProduction[2]);
         }

         System.out.print(max);
     }

     static class sortByPos implements Comparator<point> {
         public int compare(point one, point two) {
             if (one.pos > two.pos) {
                 return 1;
             }
             /** if start point and endpoint are at the same pos, we want start point to be first
              * So, we can factor in the comfortable before moving infinitesimally to the right and subtracting the next cow */
             if (one.pos == two.pos && one.state == -1 && two.state == 1) {
                 return 1;
             }
             return -1;
         }
     }
}

class point {
     int pos;
     int state;

     point(int pos, int state) {
         this.pos = pos;
         this.state = state;
     }
}

/**
 for (point n: points) {
 System.out.println(n.pos + " " + n.state);
 }
 */