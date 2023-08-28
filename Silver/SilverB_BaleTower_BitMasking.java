import java.util.*;

public class SilverB_BaleTower_BitMasking {

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        Scanner input = new Scanner(System.in);
        int numBales = input.nextInt();
        Bale[] bales = new Bale[numBales];

        for (int i = 0; i < numBales; i++) {
            bales[i] = new Bale(input.nextInt(), input.nextInt());
        }

        Arrays.sort(bales, new sortByWidth());
        for (Bale n: bales) {
            System.out.println(n.width + " " + n.breadth);
        }

        int best = 0;
        int height;
        int previousBreadth;
        /** generate all possible subsets */
        for (int i = 0; i < (1<<numBales); i++) {
            previousBreadth = 0;
            height = 0;
            for (int j = 0; j < numBales; j++) {
                if ( (i & 1<<j) > 0) {  // if the jth bit from the right is 1
                    if (bales[j].breadth > previousBreadth) { // if the breadth is less than the previous breadth
                        height++;
                        previousBreadth = bales[j].breadth;  // set new previous breadth
                    }
                }
            }
            best = Math.max(best, height);
        }

        System.out.print(best);
    }

    static class sortByWidth implements Comparator<Bale> {
        public int compare(Bale one, Bale two) {
            if (one.width > two.width) {
                return 1;
            }
            return -1;
        }
    }

}

class Bale {
    int width; int breadth;

    public Bale(int width, int breadth) {
        this.width = width;
        this.breadth = breadth;
    }
}

/**
 for (Bale n: bales) {
 System.out.println(n.width + " " + n.breadth);
 }
 */