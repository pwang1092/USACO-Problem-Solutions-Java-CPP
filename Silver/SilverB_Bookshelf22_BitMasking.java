import java.util.*;

public class SilverB_Bookshelf22_BitMasking {

    public static void main(String[] args) {
        /** 1. scan the temperature productions */
        solve();
    }

    public static void solve() {
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        int shelfHeight = input.nextInt();
        int[] heightsArr = new int[numCows];

        for (int i = 0; i < numCows; i++) {
            heightsArr[i] = input.nextInt();
        }

        int best = Integer.MAX_VALUE;
        int sum;
        /** outer loop for i all possible binary strings */


        System.out.print(best - shelfHeight);
    }

}

/**
 for (int i = 0; i < adjectiveList.size(); i++) {
 for (int j = 0; j < adjectiveList.get(i).size(); j++) {
 System.out.print(adjectiveList.get(i).get(j) + " ");
 }
 System.out.println();
 }
 */