import java.util.*;

public class SilverB_WaterBowls_BitMasking {

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        Scanner input = new Scanner(System.in);
        int[] bowls = new int[20];
        int[] copy = new int[20];
        for (int i = 0; i < 20; i++) {
            bowls[i] = input.nextInt();
            copy[i] = bowls[i];
        }

        int best = 20;
        int flips;
        boolean solved;
        /** all flips subsets */
        for (int i = 0; i < (1 << 20); i++) {
            flips = 0;
            solved = true;

            /** check if the bit at j is 1 */
            for (int j = 0; j < 20; j++) {
                /** if so, make surrounding bits 0 */
                if ((i & 1 << j) > 0) {
                    flips++;
                    if (copy[j] == 0)
                        copy[j] = 1;
                    else if (copy[j] == 1)
                        copy[j] = 0;
                    if (j-1 >=0)
                        if (copy[j-1] == 0)
                            copy[j-1] = 1;
                        else if (copy[j-1] == 1)
                            copy[j-1] = 0;
                    if (j+1 < 20)
                        if (copy[j+1] == 0)
                            copy[j+1] = 1;
                        else if (copy[j+1] == 1)
                            copy[j+1] = 0;
                }
            }

            /** check if all bowls are 0 */
            for (int k = 0; k < 20; k++) {
                if (copy[k] == 1) {
                    solved = false;
                    break;
                }
            }
            if (solved) {
                best = Math.min(best, flips);
            }
            /** reset copy */
            for (int k = 0; k < 20; k++) {
                copy[k] = bowls[k];
            }

        }
        System.out.print(best);
    }
}


/**
 for (Bale n: bales) {
 System.out.println(n.width + " " + n.breadth);
 }
 */