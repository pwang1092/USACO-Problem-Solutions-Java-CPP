import java.util.*;
import java.lang.*;

public class SilverB_RelayRace {
    public static void main(String[] args) {
        /** scan input */
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        int[] duration = new int[numCows];
        ArrayList<ArrayList<Integer>> signals = new ArrayList<>();

        // make a duration array and arraylist of signals
        int numSignals;
        for (int i = 0; i < numCows; i++) {
            duration[i] = input.nextInt();
            signals.add(new ArrayList<>());
            numSignals = input.nextInt();
            for (int j = 0; j < numSignals; j++) {
                signals.get(i).add(input.nextInt());
            }
        }

        for (int i = 0; i < numCows; i++) {
            System.out.print(duration[i] + " ");
            for (int j = 0; j < signals.get(i).size(); j++) {
                System.out.print(signals.get(i).get(j) + " ");
            }
            System.out.println();
        }

        /** problem begins */
        boolean[] alreadyRan = new boolean[numCows]; alreadyRan[0] = true;
        int[] finish = new int[numCows]; finish[0] = duration[0];
        search(duration, signals, 1, finish, alreadyRan, 0);

        int max = 0;
        for (int i = 0; i < finish.length; i++) {
            max = Math.max(finish[i], max);
        }
        System.out.print(max);
    }

    public static void search(int[] duration, ArrayList<ArrayList<Integer>> signals, int numFinish, int[] finish, boolean[] alreadyRan, int index) {
        if (numFinish == duration.length) {
            return;
        }

        int nextIndex;
        for (int i = 0; i < signals.get(index).size(); i++) {
            nextIndex = signals.get(index).get(i) - 1;
            if (!alreadyRan[nextIndex]) {
                alreadyRan[nextIndex] = true;
                finish[nextIndex] = finish[index] + duration[nextIndex];
                search(duration, signals, numFinish+1, finish, alreadyRan, nextIndex);
            }
        }
    }
}

/**
 for (int i = 0; i < numCows; i++) {
 System.out.print(duration[i] + " ");
 for (int j = 0; j < signals.get(i).size(); j++) {
 System.out.print(signals.get(i).get(j) + " ");
 }
 System.out.println();
 }
 */